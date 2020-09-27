package de.krummacker.threads;

import java.util.concurrent.ArrayBlockingQueue;

public class SimpleArrayBlockingQueue {

    private final ArrayBlockingQueue<QueueElement> internal = new ArrayBlockingQueue<>(10);

    public void put(QueueElement element) throws InterruptedException {
        internal.put(element);
    }

    public int size() {
        return internal.size();
    }

    public QueueElement take() throws InterruptedException {
        return internal.take();
    }
}
