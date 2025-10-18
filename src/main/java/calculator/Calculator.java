package calculator;

import calculator.domain.CalculatorParser;
import calculator.domain.Delimiters;
import calculator.domain.InputString;
import calculator.domain.Numbers;
import calculator.domain.Parser;
import calculator.view.InputView;

public class Calculator {
    private final InputView inputView;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void calculateSum() {
        String input = inputView.inputString();
        InputString inputString = InputString.from(input);

        Delimiters delimiters = new Delimiters();
        Parser parser = new CalculatorParser();
        inputString.extractDelimiter(parser).ifPresent(delimiters::add);
        Numbers numbers = inputString.extractNumbers(delimiters, parser);

    }
}
