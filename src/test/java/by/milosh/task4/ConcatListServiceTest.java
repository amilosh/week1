package by.milosh.task4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatListServiceTest {
    private static final List<Integer> MAIN_LIST = new ArrayList<>(Arrays.asList(1, 3, 5));
    private static final List<Integer> LIST_2 = new ArrayList<>(Arrays.asList(1, 2));
    private static final List<Integer> LIST_3 = new ArrayList<>(Arrays.asList(4, 6));
    private static final List<Integer> LIST_4 = new ArrayList<>(Arrays.asList(0));
    private static final List<Integer> LIST_5 = new ArrayList<>(Arrays.asList(1, 9));

    private static final List<Integer> RESULT_CONCAT_TWO = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 5));
    private static final List<Integer> RESULT_CONCAT_MANY = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 2, 3, 4, 5, 6, 9));

    private ConcatListService concatListService;

    @Before
    public void beforeTest() {
        concatListService = new ConcatListService();
    }

    @Test
    public void testExecuteTwo() {
        concatListService.executeTwo(MAIN_LIST, LIST_2);
        Assert.assertEquals(MAIN_LIST, RESULT_CONCAT_TWO);
    }

    @Ignore
    @Test
    public void testExecuteMany() {
        concatListService.executeMany(MAIN_LIST, LIST_2, LIST_3, LIST_4, LIST_5);
        Assert.assertEquals(MAIN_LIST, RESULT_CONCAT_MANY);
    }
}
