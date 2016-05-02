package com.amazonservices.mws.offamazonpaymentsipn.cache;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple cache implementation using a synchronized LinkedHashMap.
 */
public class Cache implements ICache {

    private static final int defaultMaxCacheSize = 20;

    private Map<String, Element> cache = null;

    private int maxCacheSize = defaultMaxCacheSize;
    
    public Cache() {
        this(defaultMaxCacheSize);
    }

    public Cache(int cacheSize) {
        cache = Collections.synchronizedMap(new LinkedHashMap<String, Element>());
        maxCacheSize = cacheSize;
    }

    /**
     * Returns the value for the key or null if the value does not 
     * currently exist in the cache or has timed out.
     */
    public Object get(String key) {
        Element e = cache.get(key);
        Object retVal = null;
        if (e != null) {
            if (Calendar.getInstance().before(e.timeout)) {
                retVal = e.getValue();
            } else {
                cache.remove(key);
            }
        }
        return retVal;
    }

    /**
     * Put an object in the cache with a specified timeout.
     * @param key Unique key
     * @param value object to put in the cache
     * @param timeout when the object should timeout
     */
    public void put(final String key, final Object value, final Calendar timeout) {
        if (cache.size() > maxCacheSize - 1) {
            removeOldestKey();
        }
        cache.put(key, new Element(value, timeout));
    }

    /**
     * To make sure the cache does not infinitely grow, this method will remove
     * the element that is going to expire the soonest.
     */
    private void removeOldestKey() {
        Calendar oldestTimeout = null;
        String oldestKey = null;
        for (String key : cache.keySet()) {
            if (oldestTimeout == null) {
                oldestTimeout = cache.get(key).timeout;
                oldestKey = key;
            } else {
                if (oldestTimeout.after(cache.get(key).timeout)) {
                    oldestTimeout = cache.get(key).timeout;
                    oldestKey = key;
                }
            }
        }
        cache.remove(oldestKey);
    }

    /**
     * Sets the new max size for the cache.
     * Will remove objects from cache if current size is greater than new size.
     * Object removal will be prioritized by closest to expiration. Ties
     * will be determined based on what was added first.
     * @param size the number of objects this cache can store
     */
    public void setMaxCacheSize(final int size) {
        maxCacheSize = size;
        while (cache.size() > maxCacheSize) {
            removeOldestKey();
        }
    }

    /**
     * @return The max number of items that can be placed in the cache.
     */
    public int getMaxCacheSize() {
        return maxCacheSize;
    }

    /**
     * @return The current number of items in the cache.
     */
    public int getCurrentCacheSize() {
        return cache.size();
    }

    /**
     * Private inner class that helps keep track of when each element's value expires.
     */
    private class Element {
        private Object value;
        private Calendar timeout;

        public Element(Object value, Calendar timeout) {
            this.value = value;
            this.timeout = timeout;
        }

        public Object getValue() {
            return value;
        }
    }
}

