package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void 저장된_모든_Number값을_더한_결과를_Number로_반환한다() {
        Numbers numbers = Numbers.from(List.of(
                Number.from("1"),
                Number.from("2"),
                Number.from("3"))
        );

        Number expected = Number.from("6");

        Number result = numbers.sum();

        assertThat(result).isEqualTo(expected);
    }

}
