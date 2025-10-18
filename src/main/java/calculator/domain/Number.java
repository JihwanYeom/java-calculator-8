package calculator.domain;

import java.math.BigInteger;

public class Number {
    private final BigInteger value;

    private Number(String numberString) {
        validate(numberString);
        value = new BigInteger(numberString);
    }

    private Number(BigInteger number) {
        this.value = number;
    }

    public static Number from(String numberString) {
        if(numberString.isEmpty()) {
            return new Number("0");
        }
        return new Number(numberString);
    }

    private void validate(String numberString) {

        if(numberString.matches("^-\\d+$")) {
            throw new IllegalArgumentException("피연산자는 양수여야 합니다");
        }
        if(!numberString.matches("^\\d+$")) {
            throw new IllegalArgumentException("입력된 피연산자가 숫자가 아닙니다");
        }
    }

    public Number add(Number number) {
        return new Number(this.value.add(number.value));
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value.equals(number.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
