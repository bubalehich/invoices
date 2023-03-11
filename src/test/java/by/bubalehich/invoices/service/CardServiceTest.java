package by.bubalehich.invoices.service;

import by.bubalehich.invoices.objectmother.ObjectMother;
import by.bubalehich.invoices.repository.CardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {
    @InjectMocks
    private CardService service;

    @Mock
    private CardRepository repository;

    @Test
    void testGetByBarcodeSuccess() {
        var expected = ObjectMother.getCard();
        when(repository.findByBarcode(expected.getBarcode())).thenReturn(expected);

        var actual = service.getByBarcode(expected.getBarcode());

        assertNotNull(actual);
        assertEquals(expected.getBarcode(), actual.getBarcode());
        verify(repository).findByBarcode(expected.getBarcode());
    }

    @Test
    void testGetByBarcodeShouldThrowException() {
        var barcode = UUID.randomUUID().toString();
        when(repository.findByBarcode(anyString())).thenReturn(null);

        assertThrows(EntityNotFoundException.class,
                () -> service.getByBarcode(barcode));
    }
}
