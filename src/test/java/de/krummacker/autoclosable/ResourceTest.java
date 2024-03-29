package de.krummacker.autoclosable;

import org.testng.annotations.Test;

public class ResourceTest {

    @Test
    public void testOldStyle() {
        Resource resource = null;
        try {
            resource = new Resource();
            resource.someAction();
        } catch (Exception ignored) {
        } finally {
            assert resource != null;
            resource.close();
        }
    }

    @Test
    public void testNewStyle() {
        try (Resource resource = new Resource()) {
            resource.someAction();
        } catch (Exception ignored) {
        }
    }
}
