package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static final String DELIMITER = ",|:";

    public List<Number> parseNumber(String string) {
        String numberPart = string.split("\n")[0];
        String[] numberStrings = numberPart.split(DELIMITER);

        return Arrays.stream(numberStrings)
                .map(Number::from)
                .toList();
    }

}
