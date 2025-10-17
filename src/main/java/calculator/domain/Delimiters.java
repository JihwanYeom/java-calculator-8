package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private static final Delimiter DEFAULT_DELIMITER_COLON = Delimiter.from(":");
    private static final Delimiter DEFAULT_DELIMITER_COMMA = Delimiter.from(",");
    private static final String REGULAR_EXPRESSION_DELIMITER = "|";

    private final List<Delimiter> delimiters;
    public Delimiters() {
        delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER_COLON);
        delimiters.add(DEFAULT_DELIMITER_COMMA);
    }

    public void add(Delimiter delimiter) {
        this.delimiters.add(delimiter);
    }

    public String toRegularExpression() {
        List<String> delimiterList = delimiters.stream()
                .map(Delimiter::toString)
                .toList();
        return String.join(REGULAR_EXPRESSION_DELIMITER, delimiterList);
    }

}
