package calculator.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {

    private static final String TEST_DEFAULT_NUMBER_INPUT = "1,2:3";
    private static final String TEST_CUSTOM_NUMBER_INPUT = "1;2;3";
    private static final String TEST_DELIMITER_INPUT = "//;";
    private static final String INVALID_DELIMITER_INPUT = "/;";

    @Test
    void 문자열을_받아_기본_구분자로_구분된_숫자들을_반환해야한다() {
        Parser parser = new Parser();
        List<Number> numbers = parser.parseNumber(TEST_DEFAULT_NUMBER_INPUT, new Delimiters());

        assertThat(numbers).hasSize(3);
        assertThat(numbers.get(0)).isEqualTo(Number.from("1"));
        assertThat(numbers.get(1)).isEqualTo(Number.from("2"));
        assertThat(numbers.get(2)).isEqualTo(Number.from("3"));
    }

    @Test
    void 문자열을_받아_커스텀_구분자로_구분된_숫자들을_반환해야한다() {
        Parser parser = new Parser();
        Delimiters delimiters = new Delimiters();
        delimiters.add(Delimiter.from(";"));
        List<Number> numbers = parser.parseNumber(TEST_CUSTOM_NUMBER_INPUT, delimiters);

        assertThat(numbers).hasSize(3);
        assertThat(numbers.get(0)).isEqualTo(Number.from("1"));
        assertThat(numbers.get(1)).isEqualTo(Number.from("2"));
        assertThat(numbers.get(2)).isEqualTo(Number.from("3"));
    }

    @Test
    void 문자열을_받아_구분자를_반환해야한다() {
        Parser parser = new Parser();
        Delimiter delimiter = parser.parseDelimiter(TEST_DELIMITER_INPUT);

        assertThat(delimiter).isEqualTo(Delimiter.from(";"));
    }

    @Test
    void 구분자_정의_형식이_잘못된_경우_예외가_발생한다() {
        Parser parser = new Parser();

        assertThatThrownBy(() -> parser.parseDelimiter(INVALID_DELIMITER_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 정의 문자열은 //로 시작해야 합니다.");
    }

}
