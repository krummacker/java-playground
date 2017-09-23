package de.krummacker.hello;

import de.krummacker.cache.HashMapCache;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        HashMapCache cache = new HashMapCache(null);
    }
}
