public class Main {
    public static void main(String[] args) {
        View CalculatorDisplay = new View();
        CalculatorImpl calculator = new CalculatorImpl();
        CalculatorPresenterImpl presenter = new CalculatorPresenterImpl(CalculatorDisplay, calculator);

        CalculatorDisplay.setPresenter(presenter);
    }
}