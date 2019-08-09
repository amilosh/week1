package by.milosh.task3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Shop {
    private static Shop shop;
    public static int terminals;

    public static Map<Integer, Integer> terminalCustomer;  // terminal number and customer number
    public static Map<Integer, Integer> terminalProduct;   // terminal number and number of sold products

    private Shop() {
    }

    public static void initializeShop(int numberOfTerminals) {
        terminals = numberOfTerminals;
        if (shop == null) {
            shop = new Shop();
            terminalCustomer = new LinkedHashMap<>();
            terminalProduct = new LinkedHashMap<>();
            for (int i = 1; i < terminals + 1; i++) {
                terminalCustomer.put(i, 0);
                terminalProduct.put(i, 0);
            }
        }
    }

    public static int freeTerminal() {
        int free = 0;
        for (Map.Entry<Integer, Integer> entry : terminalCustomer.entrySet()) {
            if (entry.getValue() == 0) {
                free = entry.getKey();
                break;
            }
        }
        return free;
    }
}
