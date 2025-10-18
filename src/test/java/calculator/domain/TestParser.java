package calculator.domain;

import java.util.List;

class TestParser implements Parser {
    @Override
    public Delimiter parseDelimiter(String delimiterString) {
        if (delimiterString.equals("//;")) {
            return Delimiter.from(";");
        }
        throw new IllegalArgumentException("잘못된 입력입니다");
    }

    @Override
    public List<Number> parseNumber(String numberString, Delimiters delimiters) {
        return List.of(Number.from("1"), Number.from("2"), Number.from("3"));
    }
}
