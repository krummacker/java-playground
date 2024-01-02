package de.krummacker.cache;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.Serializable;

public class HashMapCacheTest {

    /**
     * Dummy implementation so that we can test the HashMapCache class.
     */
    private final static Cache<Serializable> UNDERLYING_CACHE = new Cache<>() {

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

    @BeforeMethod
    public void setUp() {
        cache = new HashMapCache<>(UNDERLYING_CACHE);
    }

    @AfterMethod
    public void tearDown() {
        cache = null;
    }

    /**
     * Make sure that a second get returns then same object as the first get has returned before.
     */
    @Test
    public void testGet() {
        @SuppressWarnings("all")
        String first = new String("id");
        @SuppressWarnings("all")
        String second = new String("id");
        Serializable firstResult = cache.get(first);
        Serializable secondResult = cache.get(second);
        Assert.assertSame(firstResult, secondResult);
    }

    /**
     * Make sure that a cached object is forgotten after invalidate.
     */
    @Test
    public void testInvalidateGet() {
        @SuppressWarnings("all")
        String first = new String("id");
        @SuppressWarnings("all")
        String second = new String("id");
        Assert.assertNotSame(first, second);
        Serializable firstResult = cache.get(first);
        cache.invalidate(first);
        Serializable secondResult = cache.get(second);
        Assert.assertNotSame(firstResult, secondResult);
    }
}