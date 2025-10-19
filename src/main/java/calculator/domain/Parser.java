package calculator.domain;

import java.util.List;

public interface Parser {
    List<Number> parseNumber(String numberInput, Delimiters delimiters);
    Delimiter parseDelimiter(String delimiterInput);

}
