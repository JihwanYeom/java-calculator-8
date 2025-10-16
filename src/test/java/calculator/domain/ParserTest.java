package calculator.domain;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    private static final String TEST_INPUT = "1,2:3";

    @Test
    void 문자열을_받아_구분자로_구분된_숫자들을_반환해야한다() {
        Parser parser = new Parser();
        List<Number> numbers = parser.parseNumber(TEST_INPUT);

        assertThat(numbers).hasSize(3);
        assertThat(numbers.get(0)).isEqualTo(Number.from("1"));
        assertThat(numbers.get(1)).isEqualTo(Number.from("2"));
        assertThat(numbers.get(2)).isEqualTo(Number.from("3"));
    }

}
