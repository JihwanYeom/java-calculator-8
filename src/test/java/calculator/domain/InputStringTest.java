package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

public class InputStringTest {
    Parser parser = new TestParser();

    @Test
    void 커스텀_구분자를_정의한_경우_라인을_두개로_나눈다() {
        InputString inputString = InputString.from("//;\\n1;2;3");

        InputString expected = InputString.of("1;2;3", "//;");

        assertThat(inputString).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자를_정의한_경우_숫자_라인만_초기화한다() {
        InputString inputString = InputString.from("1,2,3");

        InputString expected = InputString.of("1,2,3", "");

        assertThat(inputString).isEqualTo(expected);
    }

    @Test
    void Parser_를_주입받아_구분자를_추출한다() {
        InputString inputString = InputString.from("//;\\n1;2;3");
        Delimiter expected = Delimiter.from(";");

        Optional<Delimiter> resultOptional = inputString.extractDelimiter(parser);

        assertThat(resultOptional).isPresent();
        assertThat(resultOptional).hasValue(expected);
    }

    @Test
    void Parser_를_주입받아_숫자를_추출한다() {
        InputString inputString = InputString.from("//;\n1;2;3");
        Number number1 = Number.from("1");
        Number number2 = Number.from("2");
        Number number3 = Number.from("3");

        Numbers expected = Numbers.from(List.of(number1, number2, number3));
        Delimiters delimiters = new Delimiters();
        delimiters.add(Delimiter.from(";"));

        Numbers result = inputString.extractNumbers(delimiters,parser);

        assertThat(result).isEqualTo(expected);
    }

}
