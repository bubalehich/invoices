package by.bubalehich.invoices.util;

import by.bubalehich.invoices.objectmother.ObjectMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CashReceiptCalculatorTest {
    @InjectMocks
    private CashReceiptCalculator calculator;

    @Test
    void testCalculateWithoutDiscount() {
        var expected = ObjectMother.getCalculatorResultWithoutDiscount();
        var cashReceipt = ObjectMother.getCashReceipt();

        var actual = calculator.calculate(cashReceipt);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateWithDiscount() {
        var expected = ObjectMother.getCalculatorResultWithDiscount();
        var cashReceipt = ObjectMother.getCashReceiptWithDiscountPositions();

        var actual = calculator.calculate(cashReceipt);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
