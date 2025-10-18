package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class CalculatorParser implements Parser {

    private static final String DELIMITER_PREFIX = "//";

    public List<Number> parseNumber(String numberInput, Delimiters delimiters) {
        String regularExpression = delimiters.toRegularExpression();
        String[] numberStrings = numberInput.split(regularExpression);

        return Arrays.stream(numberStrings)
                .map(Number::from)
                .toList();
    }

    public Delimiter parseDelimiter(String delimiterInput) {
        if (delimiterInput == null || !delimiterInput.startsWith(DELIMITER_PREFIX)) {
            throw new IllegalArgumentException("구분자 정의 문자열은 " + DELIMITER_PREFIX + "로 시작해야 합니다.");
        }
        String delemeterString = delimiterInput.substring(2);
        return Delimiter.from(delemeterString);
    }

}
