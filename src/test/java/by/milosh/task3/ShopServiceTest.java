package by.milosh.task3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest {
    private static final int TASK3_CASE_NUMBER_OF_TERMINALS = 3;
    private static final List<Integer> TASK3_CASE_CUSTOMER_QUEUE = new ArrayList<>(Arrays.asList(3, 4, 5, 3, 3));
    private static final int TASK3_CASE_ASSERT = 7;

    private ShopService shopService;

    @Before
    public void beforeTest() {
        shopService = new ShopService();
    }

    @Test
    public void testCalculateTime() {
        int result = shopService.calculateTime(TASK3_CASE_CUSTOMER_QUEUE, TASK3_CASE_NUMBER_OF_TERMINALS);
        assertEquals(result, TASK3_CASE_ASSERT);
    }
}
