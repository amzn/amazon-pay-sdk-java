package com.amazonservices.mws.offamazonpaymentsipn.unittest.cache;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.cache.Cache;

public class CacheTest {

    private static final String cacheKey = "unitTestKey";
    private static final String testValue = "test";
    private Cache cache = null;
    
    @Before
    public void setUp() {
        cache = new Cache();
    }
    
    @Test
    public void testCacheMiss() {
        assertNull(cache.get(cacheKey));
    }
    
    @Test
    public void testCacheHit() {
        Calendar timeout = Calendar.getInstance();
        timeout.add(Calendar.MILLISECOND, 2);
        cache.put(cacheKey, testValue, timeout);

        assertNotNull(cache.get(cacheKey));
    }
    
    @Test 
    public void testCacheTimeout() throws InterruptedException {
        Calendar timeout = Calendar.getInstance();
        timeout.add(Calendar.MILLISECOND, 2);
        cache.put(cacheKey, testValue, timeout);

        assertNotNull(cache.get(cacheKey));

        // Wait for the entry to timeout
        Thread.sleep(20);
        
        assertNull(cache.get(cacheKey));
    }
    
    @Test
    public void testCacheOverflow() throws InterruptedException {
        int numValues = 21;
        int removedValues = numValues - cache.getMaxCacheSize();

        fillCache(numValues);

        verifyCache(removedValues, numValues);
    }

    @Test
    public void testModifyCacheSize() throws InterruptedException {
        int numValues = cache.getMaxCacheSize();
        int reduceBy = 5;

        fillCache(numValues);
        
        // Reduce the size
        cache.setMaxCacheSize(numValues - reduceBy);

        verifyCache(reduceBy, numValues);
    }
    
    private void fillCache(int numValues) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        for (int i = 0; i < numValues; i++) {
            cache.put(cacheKey + i, testValue + i, c);
        }
    }
    
    /**
     * Ensures the values between cacheKey + 0 and cacheKey + endExpectedNullValues 
     * are null, and the values between cacheKey + endExpectedNullValues and
     * cacheKey + totalNumValues are not null.
     * @param endExpectedNullValues
     * @param totalNumValues
     */
    private void verifyCache(int endExpectedNullValues, int totalNumValues) {
        for (int i = 0; i < endExpectedNullValues; i++) {
            assertNull(cache.get(cacheKey + i));
        }

        for (int i = endExpectedNullValues; i < totalNumValues; i++) {
            assertEquals(testValue + i, cache.get(cacheKey + i));
        }
    }
    
}
