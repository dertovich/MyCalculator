import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitTest {
    private CalculatorImpl calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorImpl();
    }

    @Test
    public void testSum() {
        double result = calculator.sum(2.0, 3.0);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testSubtract() {
        double result = calculator.subtract(5.0, 2.0);
        Assertions.assertEquals(3.0, result);
    }

    @Test
    public void testMultiply() {
        double result = calculator.multiply(2.0, 3.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(10.0, 2.0);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10.0, 0.0);
        });
    }
}
