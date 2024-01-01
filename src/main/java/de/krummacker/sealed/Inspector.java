package de.krummacker.sealed;

import java.util.Set;

public class Inspector {

    public static void inspect(Set<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            switch (fruit) {
                case Banana b -> System.out.println("Banana: " + b);
                case Mango m -> System.out.println("Mango: " + m);
                case PassionFruit p -> System.out.println("PassionFruit: " + p);
            }
        }
    }

    public static void main(String[] args) {
        var fruits = Set.of(new Banana(), new Mango(), new PassionFruit(),
                new Banana(), new PassionFruit());
        inspect(fruits);
    }
}
