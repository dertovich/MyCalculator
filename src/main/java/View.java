import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class View implements CalculatorView {
    private JFrame frame;
    private JTextField textField;
    private JButton buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqual, buttonClear;
    private JPanel panel;
    private CalculatorPresenterImpl presenter;
    private JButton[] numberButtons;
    public View() {
        frame = new JFrame("Калькулятор");

        textField = new JTextField(20);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("*");
        buttonDiv = new JButton("/");
        buttonEqual = new JButton("=");
        buttonClear = new JButton("C");

        buttonAdd.addActionListener(e -> presenter.onPlusClicked());
        buttonSub.addActionListener(e -> presenter.onMinusClicked());
        buttonMul.addActionListener(e -> presenter.onMultiplyClicked());
        buttonDiv.addActionListener(e -> presenter.onDivideClicked());
        buttonEqual.addActionListener(e -> presenter.onEqualClicked());
        buttonClear.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        panel.add(buttonClear);
        panel.add(buttonDiv);
        panel.add(buttonMul);
        panel.add(buttonSub);
        panel.add(buttonAdd);
        panel.add(buttonEqual);

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            String digit = String.valueOf(i);
            numberButtons[i] = new JButton(digit);
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);
        }
    }

    public void setPresenter(CalculatorPresenterImpl presenter) {
        this.presenter = presenter;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "C":
                textField.setText("");
                break;
            case "=":
                String firstArg = getFirstArgumentAsString();
                String secondArg = getSecondArgumentAsString();
                presenter.performOperation(firstArg, secondArg);
                break;
            default:
                for (int i = 0; i < 10; i++) {
                    if (e.getSource() == numberButtons[i]) {
                        String digit = String.valueOf(i);
                        textField.setText(textField.getText() + digit);
                        break;
                    }
                }
                break;
        }
    }

    @Override
    public void printResult(double result) {
        textField.setText(String.valueOf(result));
    }

    @Override
    public void displayError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String getFirstArgumentAsString() {
        return textField.getText();
    }

    @Override
    public String getSecondArgumentAsString() {
        return textField.getText();
    }

    public void clearFields() {
        textField.setText("");
    }
}
