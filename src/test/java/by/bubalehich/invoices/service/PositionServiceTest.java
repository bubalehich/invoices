package by.bubalehich.invoices.service;

import by.bubalehich.invoices.objectmother.ObjectMother;
import by.bubalehich.invoices.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        var expected = ObjectMother.getPosition();
        when(repository.save(expected)).thenReturn(expected);

        var actual = service.save(expected);

        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(repository).save(expected);
    }
}
