package calculator;

import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputView());
        calculator.calculateSum();
    }
}
