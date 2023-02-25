package de.krummacker.cache;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

class HashMapCacheTest {

    /**
     * Dummy implementation so that we can test the HashMapCache class.
     */
    private final static Cache<Serializable> UNDERLYING_CACHE = new Cache<Serializable>() {

        @Override
        public Serializable get(Serializable key) {
            return key;
        }

        @Override
        public void invalidate(Serializable key) {
            // do nothing
        }
    };

    private Cache<Serializable> cache;

    @BeforeEach
    void setUp() throws Exception {
        cache = new HashMapCache<>(UNDERLYING_CACHE);
    }

    @AfterEach
    void tearDown() throws Exception {
        cache = null;
    }

    /**
     * Make sure that a second get returns the same object as the first get has returned before.
     */
    @Test
    void testGet() throws Exception {

        //noinspection RedundantStringConstructorCall
        String first = new String("id");
        //noinspection RedundantStringConstructorCall
        String second = new String("id");

        Serializable firstResult = cache.get(first);
        Serializable secondResult = cache.get(second);

        // Intentionally comparing identity, not equality
        Assertions.assertTrue(firstResult == secondResult);
    }

    /**
     * Make sure that a cached object is forgotten after invalidate.
     */
    @Test
    void testInvalidateGet() throws Exception {

        //noinspection RedundantStringConstructorCall
        String first = new String("id");
        //noinspection RedundantStringConstructorCall
        String second = new String("id");

        //noinspection StringEquality
        Assertions.assertTrue(first != second);
        Serializable firstResult = cache.get(first);
        cache.invalidate(first);
        Serializable secondResult = cache.get(second);
        Assertions.assertTrue(firstResult != secondResult);
    }
}