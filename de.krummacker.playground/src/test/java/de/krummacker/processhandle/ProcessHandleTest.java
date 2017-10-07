package de.krummacker.processhandle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Tests new Java 9 features around process handles.
 */
class ProcessHandleTest {

    /**
     * Make sure that this process' pid is not the pid of init.
     */
    @Test
    void testGetPid() {
        long pid = ProcessHandle.current().pid();
        Assertions.assertNotEquals(pid, 1);
    }

    /**
     * Make sure that init is still alive.
     */
    @Test
    void testInitAlive() {
        Optional<ProcessHandle> processHandle = ProcessHandle.of(1);
        boolean isAlive = processHandle.isPresent() && processHandle.get().isAlive();
        Assertions.assertTrue(isAlive);
    }
}