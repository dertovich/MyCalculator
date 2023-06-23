import java.awt.event.ActionListener;

public interface CalculatorView extends ActionListener {

    /**
     * Отображает результат вычисления
     */
    void printResult(double result);

    /**
     * Показывает ошибку, например деление на 0, пустые аргументы и прочее
     */
    void displayError(String message);

    void setPresenter(CalculatorPresenterImpl presenter);
    /**
     * Возвращает значение, введенное в поле первого аргументы
     */
    String getFirstArgumentAsString();

    /**
     * Возвращает значение, введенное в поле второго аргументы
     */
    String getSecondArgumentAsString();

    void clearFields();
}
