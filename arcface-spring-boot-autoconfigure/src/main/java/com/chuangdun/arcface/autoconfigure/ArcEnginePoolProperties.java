package com.chuangdun.arcface.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Nick
 */
@ConfigurationProperties(prefix = "face.engine.pool", ignoreUnknownFields = false)
public class ArcEnginePoolProperties {
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private int maxIdle = DEFAULT_MAX_IDLE;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int minIdle = DEFAULT_MIN_IDLE;

    public static final boolean DEFAULT_LIFO = true;
    public static final boolean DEFAULT_FAIRNESS = false;
    public static final long DEFAULT_MAX_WAIT_MILLIS = -1L;
    public static final long DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS = 1800000L;
    public static final long DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS = -1L;
    public static final long DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS = 10000L;
    public static final int DEFAULT_NUM_TESTS_PER_EVICTION_RUN = 3;
    public static final boolean DEFAULT_TEST_ON_CREATE = false;
    public static final boolean DEFAULT_TEST_ON_BORROW = false;
    public static final boolean DEFAULT_TEST_ON_RETURN = false;
    public static final boolean DEFAULT_TEST_WHILE_IDLE = false;
    public static final long DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS = -1L;
    public static final boolean DEFAULT_BLOCK_WHEN_EXHAUSTED = true;
    public static final boolean DEFAULT_JMX_ENABLE = true;
    public static final String DEFAULT_JMX_NAME_PREFIX = "pool";
    public static final String DEFAULT_JMX_NAME_BASE = null;

    private boolean lifo = DEFAULT_LIFO;
    private boolean fairness = DEFAULT_FAIRNESS;
    private long maxWaitMillis = DEFAULT_MAX_WAIT_MILLIS;
    private long minEvictableIdleTimeMillis = DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
    private long evictorShutdownTimeoutMillis = DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS;
    private long softMinEvictableIdleTimeMillis = DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
    private int numTestsPerEvictionRun = DEFAULT_NUM_TESTS_PER_EVICTION_RUN;
    private boolean testOnCreate = DEFAULT_TEST_ON_CREATE;
    private boolean testOnBorrow = DEFAULT_TEST_ON_BORROW;
    private boolean testOnReturn = DEFAULT_TEST_ON_RETURN;
    private boolean testWhileIdle = DEFAULT_TEST_WHILE_IDLE;
    private long timeBetweenEvictionRunsMillis = DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS;
    private boolean blockWhenExhausted = DEFAULT_BLOCK_WHEN_EXHAUSTED;
    private boolean jmxEnabled = DEFAULT_JMX_ENABLE;
    private String jmxNamePrefix = DEFAULT_JMX_NAME_PREFIX;
    private String jmxNameBase = DEFAULT_JMX_NAME_BASE;

    public ArcEnginePoolProperties() {
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public boolean isLifo() {
        return lifo;
    }

    public void setLifo(boolean lifo) {
        this.lifo = lifo;
    }

    public boolean isFairness() {
        return fairness;
    }

    public void setFairness(boolean fairness) {
        this.fairness = fairness;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public long getEvictorShutdownTimeoutMillis() {
        return evictorShutdownTimeoutMillis;
    }

    public void setEvictorShutdownTimeoutMillis(long evictorShutdownTimeoutMillis) {
        this.evictorShutdownTimeoutMillis = evictorShutdownTimeoutMillis;
    }

    public long getSoftMinEvictableIdleTimeMillis() {
        return softMinEvictableIdleTimeMillis;
    }

    public void setSoftMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis) {
        this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
    }

    public int getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public boolean isTestOnCreate() {
        return testOnCreate;
    }

    public void setTestOnCreate(boolean testOnCreate) {
        this.testOnCreate = testOnCreate;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public boolean isBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    public boolean isJmxEnabled() {
        return jmxEnabled;
    }

    public void setJmxEnabled(boolean jmxEnabled) {
        this.jmxEnabled = jmxEnabled;
    }

    public String getJmxNamePrefix() {
        return jmxNamePrefix;
    }

    public void setJmxNamePrefix(String jmxNamePrefix) {
        this.jmxNamePrefix = jmxNamePrefix;
    }

    public String getJmxNameBase() {
        return jmxNameBase;
    }

    public void setJmxNameBase(String jmxNameBase) {
        this.jmxNameBase = jmxNameBase;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    @Override
    public String toString() {
        return "ArcEnginePoolProperties{" +
                "maxIdle=" + maxIdle +
                ", maxTotal=" + maxTotal +
                ", minIdle=" + minIdle +
                ", lifo=" + lifo +
                ", fairness=" + fairness +
                ", maxWaitMillis=" + maxWaitMillis +
                ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis +
                ", evictorShutdownTimeoutMillis=" + evictorShutdownTimeoutMillis +
                ", softMinEvictableIdleTimeMillis=" + softMinEvictableIdleTimeMillis +
                ", numTestsPerEvictionRun=" + numTestsPerEvictionRun +
                ", testOnCreate=" + testOnCreate +
                ", testOnBorrow=" + testOnBorrow +
                ", testOnReturn=" + testOnReturn +
                ", testWhileIdle=" + testWhileIdle +
                ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis +
                ", blockWhenExhausted=" + blockWhenExhausted +
                ", jmxEnabled=" + jmxEnabled +
                ", jmxNamePrefix='" + jmxNamePrefix + '\'' +
                ", jmxNameBase='" + jmxNameBase + '\'' +
                '}';
    }
}
