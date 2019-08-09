package by.milosh.task1;

import by.milosh.task1.exception.FormatException;

public class NumbersFormatValidator {
    public static void validate(String numbers) throws FormatException {
        if (numbers.length() != 10) {
            throw new FormatException("numbers length must be 10");
        }
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new FormatException("the string contains not only numbers");
        }
    }

    public static void validateRegex(String numbers) throws FormatException {
        if (!numbers.matches("\\d{10}")) {
            throw new FormatException("the string is incorrect");
        }
    }
}
