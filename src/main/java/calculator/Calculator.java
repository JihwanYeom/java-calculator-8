package calculator;

import calculator.domain.CalculatorParser;
import calculator.domain.Delimiters;
import calculator.domain.InputString;
import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.domain.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;

    public Calculator() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void calculateSum() {
        String input = inputView.inputString();
        InputString inputString = InputString.from(input);

        Delimiters delimiters = new Delimiters();
        Parser parser = new CalculatorParser();
        inputString.extractDelimiter(parser).ifPresent(delimiters::add);
        Numbers numbers = inputString.extractNumbers(delimiters, parser);
        Number sum = numbers.sum();

        outputView.printResult(sum);
    }
}
