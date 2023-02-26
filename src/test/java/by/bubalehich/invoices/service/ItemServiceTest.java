package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
    @InjectMocks
    private ItemService service;

    @Mock
    private ItemRepository repository;

    @Test
    void testGetByBarcodeSuccess() {
        String barcode = UUID.randomUUID().toString();
        Item item = new Item(1L, barcode, "Kolbasa",new BigDecimal(1), false );
        when(repository.findByBarcode(barcode)).thenReturn(item);

        Item result = service.getByBarcode(barcode);

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

    @Test
    void testIsExistShouldReturnFalse() {
        when(repository.existsByBarcode(anyString())).thenReturn(false);

        var result = service.isExist(UUID.randomUUID().toString());

        assertFalse(result);
        verify(repository).existsByBarcode(anyString());
    }

    @Test
    void testIsExistShouldReturnTrue() {
        when(repository.existsByBarcode(anyString())).thenReturn(true);

        var result = service.isExist(UUID.randomUUID().toString());

        assertTrue(result);
        verify(repository).existsByBarcode(anyString());
    }
}