package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DelimiterTest {

    private static final String NUMBER_DELIMITER = "1";

    @Test
    void 숫자를_받으면_예외가_발생한다() {
        assertThatThrownBy(() -> Delimiter.from(NUMBER_DELIMITER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 구분자로 정의할 수 없습니다");
    }

}
