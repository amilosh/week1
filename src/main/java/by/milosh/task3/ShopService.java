package by.milosh.task3;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ShopService {
    public int calculateTime(List<Integer> customersQueue, int numberOfTerminals) {
        Shop.initializeShop(numberOfTerminals);

        ThreadsRunner.start(customersQueue, numberOfTerminals);

        System.out.println(Shop.terminalProduct);

        Optional<Integer> maxValue = Shop.terminalProduct.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getValue);

        return maxValue.orElse(0);
    }
}
