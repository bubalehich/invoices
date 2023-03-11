package by.bubalehich.invoices.service;

import by.bubalehich.invoices.objectmother.ObjectMother;
import by.bubalehich.invoices.repository.ItemRepository;
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
class ItemServiceTest {
    @InjectMocks
    private ItemService service;

    @Mock
    private ItemRepository repository;

    @Test
    void testGetByBarcodeSuccess() {
        var barcode = UUID.randomUUID().toString();
        var expected = ObjectMother.getItem();
        when(repository.findByBarcode(barcode)).thenReturn(expected);

        var actual = service.getByBarcode(barcode);

        assertNotNull(actual);
        assertEquals(expected.getBarcode(), actual.getBarcode());
        verify(repository).findByBarcode(barcode);
    }

    @Test
    void testGetByBarcodeShouldThrowException() {
        var barcode = UUID.randomUUID().toString();
        when(repository.findByBarcode(anyString())).thenReturn(null);

        assertThrows(EntityNotFoundException.class,
                () -> service.getByBarcode(barcode));
    }

    @Test
    void testIsExistShouldReturnFalse() {
        when(repository.existsByBarcode(anyString())).thenReturn(false);

        var actual = service.isExist(UUID.randomUUID().toString());

        assertFalse(actual);
        verify(repository).existsByBarcode(anyString());
    }

    @Test
    void testIsExistShouldReturnTrue() {
        when(repository.existsByBarcode(anyString())).thenReturn(true);

        var actual = service.isExist(UUID.randomUUID().toString());

        assertTrue(actual);
        verify(repository).existsByBarcode(anyString());
    }
}
