package by.milosh.task1;

import by.milosh.task1.exception.FormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberService {
    public String create(String numbers) throws FormatException {
        NumbersFormatValidator.validate(numbers);

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(numbers.substring(0, 3));
        sb.append(") ");
        sb.append(numbers.substring(3, 6));
        sb.append("-");
        sb.append(numbers.substring(6, 10));
        return sb.toString();
    }

    public String createRegex(String numbers) throws FormatException {
        NumbersFormatValidator.validateRegex(numbers);

        int[] cuttingNumbers = {3, 3, 4};
        String[] phoneNumberParts = new String[cuttingNumbers.length];

        for (int i = 0; i < cuttingNumbers.length; i++) {
            Pattern p = Pattern.compile("^(\\d{" + cuttingNumbers[i] + "})");
            Matcher m = p.matcher(numbers);
            if (m.find()) {
                phoneNumberParts[i] = m.group(0);
            }
            numbers = numbers.substring(cuttingNumbers[i]);
        }

        String phoneFormat = "() -";
        return phoneFormat.replaceAll("(\\()", "$1" + phoneNumberParts[0])
                .replaceAll("(\\) )", "$1" + phoneNumberParts[1])
                .replaceAll("(\\-)", "$1" + phoneNumberParts[2]);
    }
}
