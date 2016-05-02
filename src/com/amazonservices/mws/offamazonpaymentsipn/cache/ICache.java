package com.amazonservices.mws.offamazonpaymentsipn.cache;

import java.util.Calendar;

/**
 * Interface for a cache used by the signature verification for sns messages.
 */
public interface ICache {

    /**
     * Gets an object from the cache.
     * @param key The key for the object
     * @return The object
     */
    public Object get(String key);

    /**
     * Puts an object into the cache.
     * @param key They key for the object
     * @param value The object
     */
    public void put(String key, Object value, Calendar timeout);

}
