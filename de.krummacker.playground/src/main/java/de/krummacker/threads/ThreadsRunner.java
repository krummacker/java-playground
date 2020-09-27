package de.krummacker.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsRunner {

    private final static ExecutorService pool = Executors.newFixedThreadPool(5);

    /**
     * Called by the VM on program start.
     *
     * @param args the arguments specified on the command line
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            pool.execute(ThreadsRunner::work);
        }
        pool.shutdown();
    }

    private static void work() {
        System.out.print("1 ");
        System.out.print("2 ");
        System.out.print("3 ");
        System.out.print("4 ");
        System.out.print("5 ");
        System.out.print("6 ");
        System.out.print("7 ");
        System.out.print("8 ");
        System.out.println("9");
    }
}
