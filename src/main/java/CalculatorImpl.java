public class CalculatorImpl {
    public double sum(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (Math.abs(b) < 1e-8) {
            throw new ArithmeticException("Division by zero or very small number");
        }
        return a / b;
    }
}
