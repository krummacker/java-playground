package de.krummacker.threads;

import java.util.LinkedList;

public class LinkedListQueue {

    private final LinkedList<QueueElement> internal = new LinkedList<>();

    public void put(QueueElement element) throws InterruptedException {
        internal.addLast(element);
    }

    public int size() {
        return internal.size();
    }

    public QueueElement take() throws InterruptedException {

        // Poor man's assurance that we have something to take
        while (internal.isEmpty()) {
            Thread.sleep(100);
        }

        QueueElement result;
        synchronized (internal) {
            result = internal.removeFirst();
        }
        return result;
    }
}
