package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PositionServiceTest {
    @InjectMocks
    private PositionService service;

    @Mock
    private PositionRepository repository;

    @Test
    void save() {
        var position = new Position(1L, new Item(1L, "1", "...", BigDecimal.ONE, false), new CashReceipt(), 1);
        var expected = new Position(new Item(1L, "1", "...", BigDecimal.ONE, false), 1, new CashReceipt());
        when(repository.save(position)).thenReturn(expected);

        var result = service.save(position);

        assertNotNull(result);
        assertEquals(expected, result);
        verify(repository).save(position);
    }
}