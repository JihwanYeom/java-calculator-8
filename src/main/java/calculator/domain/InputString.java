package calculator.domain;

import java.util.Objects;
import java.util.Optional;

public class InputString {

    private final String numberString;
    private final String delimiterString;

    private InputString(String numberString, String delimiterString) {
        this.numberString = numberString;
        this.delimiterString = delimiterString;
    }

    public static InputString from(String inputString) {
        String[] line = inputString.split("\\\\n");
        String numberString;
        String delimiterString = "";
        if(line.length == 1) {
            numberString = line[0];
            return new InputString(numberString, delimiterString);
        }
        delimiterString = line[0];
        numberString = line[1];
        return new InputString(numberString, delimiterString);
    }

    public static InputString of(String numberString, String delimiterString) {
        return new InputString(numberString, delimiterString);
    }

    public Optional<Delimiter> extractDelimiter(Parser parser) {
        if (delimiterString.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(parser.parseDelimiter(delimiterString));
    }

    public Numbers extractNumbers(Delimiters delimiters, Parser parser) {
        return Numbers.from(parser.parseNumber(numberString, delimiters));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputString that = (InputString) o;
        return Objects.equals(numberString, that.numberString) &&
                Objects.equals(delimiterString, that.delimiterString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberString, delimiterString);
    }
}
