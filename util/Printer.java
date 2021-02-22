package util;

import java.util.Arrays;

import org.hibernate.stat.Statistics;

public class Printer {


    public static void print(String name, long number) {
        if (number > 0)
            System.out.println(name + "=" + number);
    }

    public static void stats(Statistics stat) {
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

    public static void print(Object obj) {
        if (obj.getClass().isArray()) {
            System.out.println(Arrays.toString((Object[]) obj));
        } else {
            System.out.println(obj);
        }
    }

}