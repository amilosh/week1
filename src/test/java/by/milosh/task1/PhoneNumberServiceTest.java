package by.milosh.task1;

import by.milosh.task1.exception.FormatException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhoneNumberServiceTest {
    private static final String TASK1_CASE = "1234567890";
    private static final String TASK1_CASE_ASSERT = "(123) 456-7890";
    private static final String TASK1_CASE_INCORRECT_FORMAT = "qwerty";

    private PhoneNumberService phoneNumberService;

    @Before
    public void beforeTest() {
        phoneNumberService = new PhoneNumberService();
    }

    @Test
    public void testCreate() throws FormatException
    {
        String result = phoneNumberService.create(TASK1_CASE);
        assertEquals(result, TASK1_CASE_ASSERT);
    }

    @Test
    public void testCreateRegex() throws FormatException {
        String result = phoneNumberService.createRegex(TASK1_CASE);
        assertEquals(result, TASK1_CASE_ASSERT);
    }

    @Test(expected = FormatException.class)
    public void testCreateException() throws FormatException {
        phoneNumberService.createRegex(TASK1_CASE_INCORRECT_FORMAT);
    }

    @Test(expected = FormatException.class)
    public void testCreateRegexException() throws FormatException {
        phoneNumberService.createRegex(TASK1_CASE_INCORRECT_FORMAT);
    }
}
