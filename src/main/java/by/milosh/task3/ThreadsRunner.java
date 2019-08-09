package by.milosh.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreadsRunner {
    public static void start(List<Integer> customersQueue, int numberOfTerminals) {
        Semaphore sem = new Semaphore(numberOfTerminals, true);

        List<Thread> listThread = new ArrayList<>();
        for (int i = 1; i < customersQueue.size() + 1; i++) {
            listThread.add(new Thread(new Customer(i, customersQueue.get(i - 1), sem)));
        }

        try {
            for (Thread thread : listThread) {
                thread.start();
                thread.sleep(1);
            }
            Thread.currentThread().join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
