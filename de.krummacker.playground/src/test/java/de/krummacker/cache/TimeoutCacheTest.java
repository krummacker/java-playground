package de.krummacker.cache;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

class TimeoutCacheTest {

    /**
     * A mock Cache that the TimeoutCache can wrap, and that also allows checking what was invalidated.
     */
    private final class MockCache implements Cache<Serializable> {

        private final Set<Serializable> invalidatedKeys = new HashSet<>();

        @Override
        public Serializable get(Serializable key) {
            return key;
        }

        @Override
        public void invalidate(Serializable key) {
            invalidatedKeys.add(key);
        }

        private boolean isInvalidated() {
            return !invalidatedKeys.isEmpty();
        }
    }

    private final static long TIMEOUT_IN_MILLIS = 10;

    private MockCache mockCache;
    private Cache<Serializable> timeoutCache;

    @BeforeEach
    void setUp() throws Exception {
        mockCache = new MockCache();
        timeoutCache = new TimeoutCache<>(mockCache, TIMEOUT_IN_MILLIS);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockCache = null;
        timeoutCache = null;
    }

    /**
     * Make sure that the underlying cache is invalidated after the timeout once the same object is requested a second
     * time.
     */
    @Test
    void testWaitGetSameObjectAndCheckInvalidated() throws Exception {

        String id = "id";
        Serializable first = timeoutCache.get(id);

        Assertions.assertEquals(id, first);
        Assertions.assertFalse(mockCache.isInvalidated());

        Thread.sleep(TIMEOUT_IN_MILLIS + 1);
        Serializable second = timeoutCache.get(id);

        Assertions.assertEquals(id, second);
        Assertions.assertTrue(mockCache.isInvalidated());
        Assertions.assertEquals(mockCache.invalidatedKeys.size(), 1);
        Assertions.assertEquals(mockCache.invalidatedKeys.iterator().next(), id);
    }

    /**
     * Make sure that the underlying cache is invalidated after the timeout once a different object is requested.
     */
    @Test
    void testWaitGetOtherObjectAndCheckInvalidated() throws Exception {

        String firstId = "firstId";
        Object first = timeoutCache.get(firstId);

        Assertions.assertEquals(firstId, first);
        Assertions.assertFalse(mockCache.isInvalidated());

        Thread.sleep(TIMEOUT_IN_MILLIS + 1);
        String secondId = "secondId";
        Object second = timeoutCache.get(secondId);

        Assertions.assertEquals(secondId, second);
        Assertions.assertTrue(mockCache.isInvalidated());
        Assertions.assertEquals(mockCache.invalidatedKeys.size(), 1);
        Assertions.assertEquals(mockCache.invalidatedKeys.iterator().next(), firstId);
    }

    /**
     * Make sure that 3 gets lead to 3 invalidates after the timeout.
     */
    @Test
    void test3Objects3Invalidates() throws Exception {

        timeoutCache.get("id1");
        timeoutCache.get("id2");
        timeoutCache.get("id3");
        Thread.sleep(TIMEOUT_IN_MILLIS + 1);
        timeoutCache.get("id4");

        Assertions.assertTrue(mockCache.isInvalidated());
        Assertions.assertEquals(mockCache.invalidatedKeys.size(), 3);
    }

    /**
     * Make sure that calling the invalidate() method really invalidates the TimeoutCache and the underlying
     * cache.
     */
    @Test
    void testInvalidate() throws Exception {

        String key = "key";
        timeoutCache.get(key);
        timeoutCache.invalidate(key);

        Assertions.assertTrue(mockCache.isInvalidated());
    }
}