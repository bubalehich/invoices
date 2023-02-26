package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.repository.CardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {
    @InjectMocks
    private CardService service;

    @Mock
    private CardRepository repository;

    @Test
    void testGetByBarcodeSuccess() {
        String barcode = UUID.randomUUID().toString();
        Card card = new Card(1L, barcode, true, "Pupa The Cat");
        when(repository.findByBarcode(barcode)).thenReturn(card);

        Card result = service.getByBarcode(barcode);

        assertNotNull(result);
        assertEquals(result.getBarcode(), barcode);
        Mockito.verify(repository).findByBarcode(barcode);
    }

    @Test
    void testGetByBarcodeShouldThrowException() {
        String barcode = UUID.randomUUID().toString();
        when(repository.findByBarcode(anyString())).thenReturn(null);

        assertThrows(EntityNotFoundException.class,
                () -> service.getByBarcode(barcode));
    }
}