package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Numbers {
    private static final String ZERO = "0";

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public void add(Number number) {
        numbers.add(number);
    }

    public Number sum() {
        Number sum = Number.from(ZERO);
        for(Number number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers that = (Numbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
