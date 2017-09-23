package de.krummacker.processhandle;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * Tests new Java 9 features around process handles.
 */
public class ProcessHandleTest {

    /**
     * Make sure that this process' pid is not the pid of init.
     */
    @Test
    public void testGetPid() {
        long pid = ProcessHandle.current().pid();
        Assert.assertNotEquals(pid, 1);
    }

    /**
     * Make sure that init is still alive.
     */
    @Test
    public void testInitAlive() {
        Optional<ProcessHandle> processHandle = ProcessHandle.of(1);
        boolean isAlive = processHandle.isPresent() && processHandle.get().isAlive();
        Assert.assertTrue(isAlive);
    }
}