package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberTest {
    private static final String VERY_BIG_NUMBER = "123456789012345678901234567890123456789012345678901234567890";
    private static final String NEGATIVE_NUMBER = "-123456789";
    private static final String NOT_NUMBER = "1A2B3C4B";
    private static final String EMPTY_STRING = "";

    @Test
    void 문자열_숫자를_받아_BigInteger_값으로_저장한다() {
        Number number = Number.from(VERY_BIG_NUMBER);
        assertThat(number).isEqualTo(Number.from(VERY_BIG_NUMBER));
    }

    @Test
    void 다른_Number_객체를_받아_Number의_값을_더한_Number를_반환한다() {
        Number number1 = Number.from("1");
        Number number2 = Number.from("2");

        Number result = number1.add(number2);

        Number expect = Number.from("3");
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void 음수를_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> Number.from(NEGATIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("피연산자는 양수여야 합니다");
    }

    @Test
    void 숫자_외의_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Number.from(NOT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 피연산자가 숫자가 아닙니다");
    }

}
