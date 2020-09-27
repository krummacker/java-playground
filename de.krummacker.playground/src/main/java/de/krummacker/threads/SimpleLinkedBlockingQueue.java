package de.krummacker.threads;

import java.util.concurrent.LinkedBlockingQueue;

public class SimpleLinkedBlockingQueue {

    private final LinkedBlockingQueue<QueueElement> internal = new LinkedBlockingQueue<>(10);

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
