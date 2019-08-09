package by.milosh.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClerkServiceTest {
    private static final List<Integer> TASK2_CASE = new ArrayList<Integer>(Arrays.asList(25, 25, 50, 50, 25, 25, 25, 100));
    private static final boolean TASK2_CASE_ASSERT = true;

    private ClerkService clerkService;

    @Before
    public void beforeTest() {
        clerkService = new ClerkService();
    }

    @Test
    public void testCheckQueue() {
        boolean result = clerkService.checkQueue(TASK2_CASE);
        assertEquals(result, TASK2_CASE_ASSERT);
    }
}
