package by.bubalehich.invoices.mapper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class PositionMapperTest {
    @InjectMocks
    private PositionMapper mapper;

    @ParameterizedTest
    @ValueSource(strings = {"1-2", "3-4", "5-6", "7-8"})
    void mapToPositionDtoFromString(String position) {
        var actual = mapper.mapToPositionDtoFromString(position);

        assertNotNull(actual);
        assertEquals(position.split("-")[0], actual.getItem());
        assertEquals(Integer.parseInt(position.split("-")[1]), actual.getCount());
    }
}
