public interface CalculatorPresenter {
    void performOperation(String firstArg, String secondArg);
    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '+'
     */
    void onPlusClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '-'
     */
    void onMinusClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '/'
     */
    void onDivideClicked();

    /**
     * Вызывается формой в тот момент, когда пользователь нажал на кнопку '*'
     */
    void onMultiplyClicked();
}
