package calculator.domain;

import java.math.BigInteger;

public class Number {

    private final BigInteger value;

    private Number(String numberString) {
        validate(numberString);
        value = new BigInteger(numberString);
    }

    public static Number from(String numberString) {
        return new Number(numberString);
    }

    private void validate(String numberString) {
        if(numberString.isEmpty()) {
            throw new IllegalArgumentException("피연산자는 공백일 수 없습니다");
        }
        if(numberString.matches("^-\\d+$")) {
            throw new IllegalArgumentException("피연산자는 양수여야 합니다");
        }
        if(!numberString.matches("^\\d+$")) {
            throw new IllegalArgumentException("입력된 피연산자가 숫자가 아닙니다");
        }
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
