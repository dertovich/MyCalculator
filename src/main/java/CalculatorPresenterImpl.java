public class CalculatorPresenterImpl {
    private CalculatorView view;
    private CalculatorImpl calculator;
    private double firstArgument;
    private double secondArgument;
    private String operation;

    public CalculatorPresenterImpl(CalculatorView view, CalculatorImpl calculator) {
        this.view = view;
        this.calculator = calculator; // Инициализация экземпляра CalculatorImpl
    }

    public void performOperation(String firstArg, String secondArg) {
        // Преобразование строковых аргументов в числа, если необходимо
        double a = Double.parseDouble(firstArg);
        double b = Double.parseDouble(secondArg);

        try {
            double result = calculator.sum(a, b); // Пример выполнения операции (сложение)
            view.printResult(result); // Отображение результата в представлении
        } catch (ArithmeticException e) {
            view.displayError(e.getMessage()); // Отображение ошибки в представлении
        }
    }

    public void onPlusClicked() {
        saveFirstArgument();
        operation = "+";
        clearView();
    }

    public void onMinusClicked() {
        saveFirstArgument();
        operation = "-";
        clearView();
    }

    public void onMultiplyClicked() {
        saveFirstArgument();
        operation = "*";
        clearView();
    }

    public void onDivideClicked() {
        saveFirstArgument();
        operation = "/";
        clearView();
    }

    public void onEqualClicked() {
        if (operation != null && !operation.isEmpty()) {
            try {
                double result = switch (operation) {
                    case "+" -> calculator.sum(firstArgument, getSecondArgument());
                    case "-" -> calculator.subtract(firstArgument, getSecondArgument());
                    case "*" -> calculator.multiply(firstArgument, getSecondArgument());
                    case "/" -> calculator.divide(firstArgument, getSecondArgument());
                    default -> throw new UnsupportedOperationException("Unsupported operation: " + operation);
                };
                view.printResult(result);
            } catch (ArithmeticException e) {
                view.displayError("Error: " + e.getMessage());
            }
        }
    }

    private double getSecondArgument() {
        String secondArgStr = view.getSecondArgumentAsString();
        if (!secondArgStr.isEmpty()) {
            return Double.parseDouble(secondArgStr);
        } else {
            return 0.0;
        }
    }

    private void saveFirstArgument() {
        String firstArgStr = view.getFirstArgumentAsString();
        if (!firstArgStr.isEmpty()) {
            firstArgument = Double.parseDouble(firstArgStr);
        }
    }

    private void clearView() {
        view.clearFields();
    }
}
