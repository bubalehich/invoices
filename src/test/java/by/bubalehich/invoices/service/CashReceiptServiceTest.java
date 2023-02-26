package by.bubalehich.invoices.service;

import by.bubalehich.invoices.dto.PositionDto;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.mapper.PositionMapper;
import by.bubalehich.invoices.objectmother.ObjectMother;
import by.bubalehich.invoices.repository.CashReceiptRepository;
import by.bubalehich.invoices.util.CashReceiptCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CashReceiptServiceTest {
    @InjectMocks
    private CashReceiptService cashReceiptService;

    @Spy
    private CashReceiptCalculator calculator;

    @Spy
    private PositionMapper mapper;

    @Mock
    private PositionService positionService;

    @Mock
    private CashReceiptRepository repository;

    @Mock
    private ItemService itemService;

    @Mock
    private CardService cardService;

    @Test
    void testCreate() {
        var card = ObjectMother.getCard();
        var model = ObjectMother.getCashReceiptMutationModel();
        var item = ObjectMother.getItem();
        var cashReceipt = ObjectMother.getCashReceipt();
        when(itemService.isExist(item.getBarcode())).thenReturn(true);
        when(itemService.getByBarcode(item.getBarcode())).thenReturn(item);
        when(cardService.getByBarcode(card.getBarcode())).thenReturn(card);
        when(repository.save(any(CashReceipt.class))).thenReturn(cashReceipt);
        when(positionService.save(any(Position.class))).thenReturn(new Position());
        when(mapper.mapToPositionDtoFromString(model.getItemQuantityList().get(0)))
                .thenReturn(new PositionDto("2",2));

        var actual = cashReceiptService.create(model);

        assertNotNull(actual);
        assertNotNull(actual.getCard());
        assertNotNull(actual.getCard().getBarcode());
        assertEquals(card.getBarcode(), actual.getCard().getBarcode());
        assertNotNull(actual.getDate());
        assertNotNull(actual.getCashier());
        assertNotNull(actual.getBarcode());
        assertNotNull(actual.getPositions());
        assertEquals(model.getItemQuantityList().size(), actual.getPositions().size());
        assertNotNull(actual.getTotalAmount());
        assertEquals(BigDecimal.valueOf(2), actual.getTotalAmount());
        assertNotNull(actual.getDiscount());
        assertEquals(BigDecimal.ZERO, actual.getDiscount());
        assertNotNull(actual.getAmount());
        assertEquals(BigDecimal.valueOf(2), actual.getAmount());
        verify(repository).save(any(CashReceipt.class));
    }
}
