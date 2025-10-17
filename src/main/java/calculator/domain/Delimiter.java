package calculator.domain;

public class Delimiter {
    private final String delimiter;

    private Delimiter(String delimiter) {
        validate(delimiter);
        this.delimiter = delimiter;
    }

    public static Delimiter from(String delimiter) {
        return new Delimiter(delimiter);
    }

    public void validate(String delimiter) {
        if(delimiter.matches("[0-9]")) {
            throw new IllegalArgumentException("숫자를 구분자로 정의할 수 없습니다");
        }
    }

    @Override
    public String toString() {
        return delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter that = (Delimiter) o;
        return delimiter.equals(that.delimiter);
    }

    @Override
    public int hashCode() {
        return delimiter.hashCode();
    }

}
