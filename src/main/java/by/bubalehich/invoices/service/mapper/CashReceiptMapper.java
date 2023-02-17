package by.bubalehich.invoices.service.mapper;

import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import by.bubalehich.invoices.api.model.PositionViewModel;
import by.bubalehich.invoices.dto.CashReceiptDto;
import by.bubalehich.invoices.entity.CashReceipt;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

public final class CashReceiptMapper {
    private static final String SEPARATOR = "-";

    private static final String CARD = "card";

    public static CashReceiptDto mapToDtoFromArray(String[] args) {
        var card = Arrays.stream(args).filter(a -> a.split(SEPARATOR)[0].equalsIgnoreCase(CARD)).findFirst();
        var cardId = card.get().split("-")[1];

        var itemsArray = Arrays.stream(args)
                .filter(a -> !a.split(SEPARATOR)[0].equalsIgnoreCase(CARD))
                .toArray(String[]::new);

        var dto = new CashReceiptDto();

        Arrays.stream(itemsArray).forEach(item -> dto.addPosition(
                item.split(SEPARATOR)[0],
                Integer.parseInt(item.split(SEPARATOR)[1])));

        dto.setCardNumber(cardId);

        return dto;
    }

    public static CashReceiptViewModel mapToViewFromCashReceipt(CashReceipt receipt) {
        var cashReceiptViewModel = CashReceiptViewModel.builder()
                .cashier(receipt.getCashier())
                .date(receipt.getDate())
                .positions(receipt.getPositions().stream()
                        .map(p -> new PositionViewModel(
                                p.getItem().getDescription(),
                                p.getCount(),
                                p.getItem().getPrice().multiply(BigDecimal.valueOf(p.getCount())))).
                        toList())
                .total(receipt.getTotal())
                .taxableTotal(receipt.getTaxableTotal())
                .discount(receipt.getDiscount())
                .build();

        cashReceiptViewModel.setId(UUID.randomUUID());

        return cashReceiptViewModel;
    }
}
