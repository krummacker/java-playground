package de.krummacker.flexconstructors;

public class Employee extends Person {

    public Employee(int age) {
        if (age < 18 || age > 67) { // allowed since Java 25
            throw new IllegalArgumentException();
        }
        super(age);
    }
}
