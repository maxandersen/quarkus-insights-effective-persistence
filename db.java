///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 15
//  Update the Quarkus version to what you want here or run jbang with
// `-Dquarkus.version=<version>` to override it.
//DEPS io.quarkus:quarkus-bom:${quarkus.version:1.11.3.Final}@pom
//DEPS io.quarkus:quarkus-picocli
//DEPS io.quarkus:quarkus-hibernate-orm-panache
//DEPS io.quarkus:quarkus-jdbc-postgresql
//DEPS org.postgresql:postgresql:42.2.14
//DEPS org.testcontainers:postgresql:1.15.2
//DEPS io.quarkus:quarkus-hibernate-orm

//jbang bug requires me to have them here
//DEPS org.jooq:jooq:3.14.7
//DEPS org.jooq:jooq-meta:3.14.7
//DEPS org.jooq:jooq-codegen:3.14.7

//Q:CONFIG quarkus.banner.enabled=false
//Q:CONFIG quarkus.log.level=WARN
//  Q:CONFIG quarkus.log.category."org.hibernate.stat".level=DEBUG
//Q:CONFIG quarkus.hibernate-orm.log.sql=true
//Q:CONFIG quarkus.hibernate-orm.log.format-sql=false
//Q:CONFIG quarkus.datasource.db-kind=postgresql
//Q:CONFIG quarkus.datasource.username=postgres
//Q:CONFIG quarkus.datasource.password=sakila
//Q:CONFIG quarkus.hibernate-orm.statistics=true
//Q:CONFIG quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/sakila
//SOURCES **/*.java
// SOURCES sakila/**/*.java

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.lang.System.out;
import static org.jooq.impl.DSL.count;
import static sakila.tables.Actor.ACTOR;
import static sakila.tables.FilmActor.FILM_ACTOR;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.stat.Statistics;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.conf.ParamType;
import org.jooq.impl.DSL;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

@CommandLine.Command
@QuarkusMain
public class db implements Runnable, QuarkusApplication {

    @CommandLine.Parameters(index = "0", description = "The greeting to print", defaultValue = "World!")
    String name;

    @Inject
    CommandLine.IFactory factory;

    private final GreetingService greetingService;

    public db(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public int run(String... args) {
        return new CommandLine(this, factory).execute(args);
    }

    @Override
    @ActivateRequestContext
    @Transactional
    public void run() {
        greetingService.sayHello(name);
    }

    @Entity
    @Table(name = "actor")
    static public class Actor extends PanacheEntityBase {
        @Id
        public long actor_id;

        public String first_name;
        public String last_name;
        public Date last_update;

        @Override
        public String toString() {
            return actor_id + ": " + first_name + " " + last_name;
        }
    }
}

@Dependent
class GreetingService {

    void print(String name, long number) {
        if (number > 0)
            System.out.println(name + "=" + number);
    }

    void stats(Statistics stat) {
        System.out.println("Hibernate non-zero Statistics:");
        print("sessions opened", stat.getSessionOpenCount());
        print("sessions closed", stat.getSessionCloseCount());
        print("transactions", stat.getTransactionCount());
        print("successful transactions", stat.getTransactionCount());
        print("optimistic lock failures", stat.getOptimisticFailureCount());
        print("flushes", stat.getFlushCount());
        print("connections obtained", stat.getConnectCount());
        print("statements prepared", stat.getPrepareStatementCount());
        print("statements closed", stat.getCloseStatementCount());
        print("second level cache puts", stat.getSecondLevelCachePutCount());
        print("second level cache hits", stat.getSecondLevelCacheHitCount());
        print("second level cache misses", stat.getSecondLevelCacheMissCount());
        print("entities loaded", stat.getEntityLoadCount());
        print("entities updated", stat.getEntityUpdateCount());
        print("entities inserted", stat.getEntityInsertCount());
        print("entities deleted", stat.getEntityDeleteCount());
        print("entities fetched", stat.getEntityFetchCount());
        print("collections loaded", stat.getCollectionLoadCount());
        print("collections updated", stat.getCollectionUpdateCount());
        print("collections removed", stat.getCollectionRemoveCount());
        print("collections recreated", stat.getCollectionRecreateCount());
        print("collections fetched", stat.getCollectionFetchCount());
        print("naturalId queries executed to database", stat.getNaturalIdQueryExecutionCount());
        print("naturalId cache puts", stat.getNaturalIdCachePutCount());
        print("naturalId cache hits", stat.getNaturalIdCacheHitCount());
        print("naturalId cache misses", stat.getNaturalIdCacheMissCount());
        print("naturalId max query time", stat.getNaturalIdQueryExecutionMaxTime());
        print("queries executed to database", stat.getQueryExecutionCount());
        print("query cache puts", stat.getQueryCachePutCount());
        print("query cache hits", stat.getQueryCacheHitCount());
        print("query cache misses", stat.getQueryCacheMissCount());
        print("update timestamps cache puts", stat.getUpdateTimestampsCachePutCount());
        print("update timestamps cache hits", stat.getUpdateTimestampsCacheHitCount());
        print("update timestamps cache misses", stat.getUpdateTimestampsCacheMissCount());
        print("max query time", stat.getQueryExecutionMaxTime());
        print("query plan cache hits", stat.getQueryPlanCacheHitCount());
        print("query plan cache misses", stat.getQueryCacheMissCount());
    }

    void print(Object obj) {
        if (obj.getClass().isArray()) {
            System.out.println(Arrays.toString((Object[]) obj));
        } else {
            System.out.println(obj);
        }
    }

    @Inject
    EntityManager em;

    @Transactional(TxType.REQUIRES_NEW)
    void updateViaEntity() {
        List<db.Actor> actors = db.Actor.listAll();

        for (db.Actor actor : actors) {
            actor.first_name = actor.first_name.toLowerCase();
        }

    };

    @SuppressWarnings({"unchecked", "deprecation"}) // here as we are dealing with non-type-safe streams
    void sayHello(String name) {
        System.out.println("Hello " + name + "!");

        Statistics statistics = em.getEntityManagerFactory().unwrap(SessionFactory.class).getStatistics();

        // stats(statistics);

        // updateViaEntity();

        // System.out.println(statistics);
        // stats(statistics);

        // nativeQueries();

        String sql = """
                select extract(year from pay.payment_date) y, extract(month from pay.payment_date) m, stf.first_name, stf.last_name, sum(pay.amount)
                from staff stf
                left join payment pay
                on stf.staff_id = pay.staff_id
                group by y, m, stf.first_name, stf.last_name
                """;

        Session session = getSession();

        List<Map> list = session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

        list.forEach(item -> {
            print(item.get("first_name") + " sold for " + item.get("sum") + " in " + item.get("y") + "-"
                    + item.get("m"));
        });

        print("Explicit types");

        list = session.createSQLQuery(sql).addScalar("y", LongType.INSTANCE).addScalar("m", LongType.INSTANCE)
                .addScalar("sum").addScalar("first_name").addScalar("last_name")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

        list.forEach(item -> {
            print(item.get("first_name") + " sold for " + item.get("sum") + " in " + item.get("y") + "-"
                    + item.get("m"));
        });

        print("DTO's");

        List<SaleDTO> typeDtos = session.createSQLQuery(sql)
                .addScalar("y", LongType.INSTANCE)
                .addScalar("m", LongType.INSTANCE)
                .addScalar("sum")
                .addScalar("first_name")
                .addScalar("last_name")
                .setResultTransformer(Transformers.aliasToBean(SaleDTO.class)).list();

        typeDtos.forEach(item -> {
            print(item.first_name + " sold for " + item.sum + " in " + item.y + "-" + item.m);
        });

    }

    static public class SaleDTO {
        public long m;
        public long y;
        public String first_name;
        public String last_name;
        public BigDecimal sum;
    }

    private Session getSession() {
        return em.unwrap(Session.class);
    }

    private StatelessSession getStatelessSession() {
        return em.getEntityManagerFactory().unwrap(SessionFactory.class).openStatelessSession();
    }

    private void nativeQueries() {
        print(em.createNativeQuery("select * from Actor", db.Actor.class).getResultStream().findFirst());

        StatelessSession session = getStatelessSession();

        String sql = """
                    SELECT first_name, last_name, count(*) films
                    FROM actor AS a
                    JOIN film_actor AS fa USING (actor_id)
                    GROUP BY actor_id, first_name, last_name
                    ORDER BY films DESC
                    LIMIT 1;
                """;

        session.doWork(connection -> {
            DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);

            Field<Integer> COUNT = DSL.field("COUNT(*)", Integer.class);

            String jooqsql = create.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME, COUNT.as("films")).from(ACTOR).join(FILM_ACTOR)
                    .using(FILM_ACTOR.ACTOR_ID).groupBy(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                    .orderBy(COUNT.desc()).limit(1).getSQL(ParamType.INLINED);

            //print(jooqsql);

            print(session.createSQLQuery(jooqsql).addScalar("first_name", StringType.INSTANCE)
                    .addScalar("last_name", StringType.INSTANCE).addScalar("films", LongType.INSTANCE)
                    .getSingleResult());
        });

    }
}