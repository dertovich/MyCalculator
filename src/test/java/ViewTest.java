import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ViewTest {
    @Mock
    private CalculatorPresenterImpl presenter;

    private CalculatorView view;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        view = new View();
        view.setPresenter(presenter);
    }

    @Test
    public void testAdditionButtonClicked() {
        view.onPlusClicked(); // Нажатие на кнопку сложения
        Mockito.verify(presenter).onPlusClicked(); // Проверка вызова метода презентера
    }

    @Test
    public void testSubtractionButtonClicked() {
        view.onMinusClicked(); // Нажатие на кнопку вычитания
        Mockito.verify(presenter).onMinusClicked(); // Проверка вызова метода презентера
    }

    @Test
    public void testMultiplicationButtonClicked() {
        view.onMultiplyClicked(); // Нажатие на кнопку умножения
        Mockito.verify(presenter).onMultiplyClicked(); // Проверка вызова метода презентера
    }

    @Test
    public void testDivisionButtonClicked() {
        view.onDivideClicked(); // Нажатие на кнопку деления
        Mockito.verify(presenter).onDivideClicked(); // Проверка вызова метода презентера
    }

    @Test
    public void testEqualButtonClicked() {
        view.onEqualClicked(); // Нажатие на кнопку равно
        Mockito.verify(presenter).onEqualClicked(); // Проверка вызова метода презентера
    }
}
