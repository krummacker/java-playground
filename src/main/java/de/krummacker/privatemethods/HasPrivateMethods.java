package de.krummacker.privatemethods;

public interface HasPrivateMethods {

    static void doSomething() {
        System.out.println("I am doing something.");
        doSomethingElse();
    }

    static void doAnything() {
        System.out.println("I am doing anything.");
        doSomethingElse();
    }

    /**
     * This is a way to extract shared code from public static methods in interfaces.
     * Works from Java 9.
     */
    private static void doSomethingElse() {
        System.out.println("And now I am doing something else.");
    }

    static void main(String[] args) {
        new HasPrivateMethods() {
        }; // dummy reference to avoid warning
        doSomething();
        doAnything();
    }
}
