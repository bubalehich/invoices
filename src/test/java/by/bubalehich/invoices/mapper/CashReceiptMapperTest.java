package by.bubalehich.invoices.mapper;

import by.bubalehich.invoices.objectmother.ObjectMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CashReceiptMapperTest {
    @InjectMocks
    private CashReceiptMapper mapper;

    @Test
    void mapToViewFromCashReceipt() {
        var cashReceipt = ObjectMother.getFullCashReceipt();

        var actual = mapper.mapToViewFromCashReceipt(cashReceipt);

        assertNotNull(actual);
        assertNotNull(actual.getAmount());
        assertEquals(cashReceipt.getAmount(), actual.getAmount());
        assertNotNull(actual.getTotalAmount());
        assertEquals(cashReceipt.getTotalAmount(), actual.getTotalAmount());
        assertNotNull(actual.getDiscount());
        assertEquals(cashReceipt.getDiscount(), actual.getDiscount());
        assertNotNull(actual.getAmount());
        assertEquals(cashReceipt.getAmount(), actual.getAmount());
        assertNotNull(actual.getCashier());
        assertNotNull(actual.getPositions());
        assertEquals(cashReceipt.getPositions().size(), actual.getPositions().size());
        assertNotNull(actual.getDate());
        assertEquals(cashReceipt.getDate(), actual.getDate());
    }
}