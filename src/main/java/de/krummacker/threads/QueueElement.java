package de.krummacker.threads;

public class QueueElement {

    private static int counter = 0;

    private Integer number;
    private boolean processed = false;

    private QueueElement(Integer number) {
        this.number = number;
    }

    public static QueueElement create() {
        int number;
        synchronized (QueueRunner.class) {
            number = ++counter;
        }
        return new QueueElement(number);
    }

    public void process() {
        if (processed) {
            throw new IllegalStateException("Queue element '" + number + "' has already been processed!");
        }
        processed = true;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
