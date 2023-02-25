package de.krummacker.threads;

import java.util.Random;

public class QueueRunner {

    private static class QueueProducer implements Runnable {

        private String name;

        public QueueProducer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            //noinspection InfiniteLoopStatement
            while (true) {
                waitArbitrary();
                QueueElement element = QueueElement.create();
                try {
                    QUEUE.put(element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer " + name + " puts element '" + element
                        + "'. Current queue size: " + QUEUE.size());
            }
        }
    }

    private static class QueueConsumer implements Runnable {

        private String name;

        public QueueConsumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                waitArbitrary();
                try {
                    QueueElement element = QUEUE.take();
                    System.out.println("Consumer " + name + " takes element '" + element
                            + "'. Current queue size: " + QUEUE.size());
                    element.process();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    private final static Random RANDOM = new Random();
    private final static LinkedListQueue QUEUE = new LinkedListQueue();

    /**
     * Called by the VM on program start.
     *
     * @param args the arguments specified on the command line
     */
    public static void main(String[] args) {
        for (char c = 'A'; c <= 'J'; ++c) {
            new Thread(new QueueProducer(String.valueOf(c))).start();
        }
        for (char c = 'q'; c <= 'z'; ++c) {
            new Thread(new QueueConsumer(String.valueOf(c))).start();
        }
    }

    /**
     * Waits a random time between 10ms and 500ms.
     */
    private static void waitArbitrary() {
        try {
            int r = RANDOM.nextInt(490);
            Thread.sleep(10 + r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
