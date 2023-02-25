package de.krummacker.optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class EntityRetrieverTest {

    private EntityRetriever entityRetriever;

    @BeforeEach
    void setUp() throws Exception {
        entityRetriever = new EntityRetriever();
    }

    @AfterEach
    void tearDown() throws Exception {
        entityRetriever = null;
    }

    @Test
    void testCreateRandomStringHappyCase() {
        Optional<String> result = entityRetriever.createRandomString(5);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(result.get().length(), 5);
    }

    @Test
    void testCreateRandomStringNegative() {
        Optional<String> result = entityRetriever.createRandomString(-5);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    void testCreateRandomStringTooLarge() {
        Optional<String> result = entityRetriever.createRandomString(Integer.MAX_VALUE);
        Assertions.assertFalse(result.isPresent());
    }
}
