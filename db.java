///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 16
//SOURCES **/*.java
// SOURCES sakila/**/*.java

//DEPS io.quarkus:quarkus-bom:${quarkus.version:2.0.0.Final}@pom
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
//Q:CONFIG quarkus.log.category."org.hibernate.stat".level=DEBUG
//Q:CONFIG quarkus.hibernate-orm.log.sql=falses
//Q:CONFIG quarkus.hibernate-orm.log.format-sql=true
//Q:CONFIG quarkus.hibernate-orm.jdbc.statement-batch-size=20

//Q:CONFIG quarkus.datasource.db-kind=postgresql
//Q:CONFIG quarkus.datasource.username=postgres
//Q:CONFIG quarkus.datasource.password=sakila
//Q:CONFIG quarkus.hibernate-orm.statistics=true
//Q:CONFIG quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/sakila

import static util.Printer.print;
import static util.Printer.stats;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.transaction.UserTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.stat.Statistics;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.narayana.jta.runtime.TransactionConfiguration;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class db implements QuarkusApplication {

    private final DbService dbService;

    public db(DbService dbService) {
        this.dbService = dbService;
    }

    @Override
    @ActivateRequestContext
    @Transactional
    public int run(String... args) throws Exception {
        dbService.doData("Quarkus Insights");
        return 0;
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

    @Entity
    @Table(name = "language")
    static public class Language extends PanacheEntityBase {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long language_id;

        public String name;
    }
}

@Dependent
class DbService {

    @Inject
    EntityManager em;

    @Transactional(TxType.REQUIRES_NEW)
    void updateViaEntity() {

        List<db.Actor> actors = db.Actor.listAll();

        System.out.println("Updating " + actors.size() + " actors");
        for (db.Actor actor : actors) {
            if (Character.isUpperCase(actor.first_name.charAt(0))) {
                actor.first_name = actor.first_name.toLowerCase();
            } else {
                actor.first_name = actor.first_name.toUpperCase();
            }
        }
    };

    void doData(String name) throws Exception {
        System.out.println("Hello " + name + "!");

       //managedUpdate();

       //bulkProcessing(true);
       //bulkStatelessProcessing();

      //nativeQueries();

         resultTransformers();

    }

    @TransactionConfiguration(timeout = 50000)
    private void bulkProcessing(boolean manual) {
        System.out.println("Insert lots of rows");
        for (int i = 0; i < 100000; i++) {
            db.Language lang = new db.Language();   
            lang.name = "A-" + i;
            System.out.println(lang.name);
            em.persist(lang);
            if(manual) {
            if ( i % 100 == 0 ) {
                              //commit and begin to do it manually in batches.
                              System.out.println("Manual flush!");
                           em.flush();
                           em.clear();
                         }
        }
       }
    }

    private void bulkStatelessProcessing() throws Exception {
        StatelessSession ss = getStatelessSession();

        System.out.println("Insert lots of rows with stateless session");
        for ( int i=0; i<100000; i++ ) {
            db.Language lang = new db.Language();
            lang.name = "A-" + i;
            System.out.println(lang.name);
            ss.insert(lang);
            
        }
    }

    private void managedUpdate() {
        Statistics statistics = em.getEntityManagerFactory().unwrap(SessionFactory.class).getStatistics();
        stats(statistics);
        updateViaEntity();
        stats(statistics);
    }

    @SuppressWarnings({ "unchecked", "deprecation" }) // here as we are dealing with non-type-safe streams
    private void resultTransformers() {
        print("****RESULT TRANSFORMERS****");

        String sql = """
                select extract(year from pay.payment_date) y, extract(month from pay.payment_date) m, stf.first_name, stf.last_name, sum(pay.amount)
                from staff stf
                left join payment pay
                on stf.staff_id = pay.staff_id
                group by y, m, stf.first_name, stf.last_name
                """;

        Session session = getSession();

        // Every column gets added 
        List<Map<String, Object>> list = session.createSQLQuery(sql)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

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

        List<SaleDTO> typeDtos = session.createSQLQuery(sql).addScalar("y", LongType.INSTANCE)
                .addScalar("m", LongType.INSTANCE).addScalar("sum").addScalar("first_name").addScalar("last_name")
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

        session.doWork(connection -> {

            String sql = """
                        SELECT first_name, last_name, count(*) films
                        FROM actor AS a
                        JOIN film_actor AS fa USING (actor_id)
                        GROUP BY actor_id, first_name, last_name
                        ORDER BY films DESC
                        LIMIT 1;
                    """;

/*                    
            DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);

            Field<Integer> COUNT = DSL.field("COUNT(*)", Integer.class);

            String jooqsql = create.select(ACTOR.FIRST_NAME, ACTOR.LAST_NAME, COUNT.as("films")).from(ACTOR)
                    .join(FILM_ACTOR).using(FILM_ACTOR.ACTOR_ID)
                    .groupBy(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME).orderBy(COUNT.desc()).limit(1)
                    .getSQL(ParamType.INLINED);
*/

            print(session.createSQLQuery(sql).addScalar("first_name", StringType.INSTANCE)
                    .addScalar("last_name", StringType.INSTANCE).addScalar("films", LongType.INSTANCE)
                    .getSingleResult());
        });

    }
}