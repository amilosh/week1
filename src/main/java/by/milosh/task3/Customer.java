package by.milosh.task3;

import java.util.concurrent.Semaphore;

public class Customer implements Runnable {
    public int name;
    public int products;
    public Semaphore semaphore;

    public Customer(int name, int products, Semaphore semaphore) {
        this.name = name;
        this.products = products;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            int free = Shop.freeTerminal();
            Shop.terminalCustomer.put(free, name);
            for (int i = 1; i <= products; i++) {
                Thread.sleep(25);
            }
            Shop.terminalProduct.put(free, Shop.terminalProduct.get(free) + products);
            Shop.terminalCustomer.put(free, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
