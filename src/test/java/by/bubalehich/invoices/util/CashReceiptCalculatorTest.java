package by.bubalehich.invoices.util;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.objectmother.ObjectMother;
import by.bubalehich.invoices.util.mapper.CalculatorResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CashReceiptCalculatorTest {
    @InjectMocks
    private CashReceiptCalculator calculator;

    @Test
    void testCalculateWithoutDiscount() {
        var expected = new CalculatorResult(BigDecimal.valueOf(2), BigDecimal.ZERO, BigDecimal.valueOf(2));
        var cashReceipt = ObjectMother.getCashReceipt();

        var actual = calculator.calculate(cashReceipt);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateWithDiscount() {
        var expected = new CalculatorResult(BigDecimal.valueOf(100), BigDecimal.valueOf(10.0), BigDecimal.valueOf(90.0));
        var cashReceipt = CashReceipt.builder()
                .card(new Card())
                .positions(List.of(
                        Position.builder()
                                .item(ObjectMother.getDiscountItem())
                                .count(10)
                                .build()))
                .build();

        var actual = calculator.calculate(cashReceipt);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void calculateCountOfDiscountPositions() {
    }
}