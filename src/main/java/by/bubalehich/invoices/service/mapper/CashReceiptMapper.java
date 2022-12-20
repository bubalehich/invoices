package by.bubalehich.invoices.service.mapper;

import by.bubalehich.invoices.dto.CashReceiptDto;

import java.util.Arrays;

public class CashReceiptMapper {
    private static final String SEPARATOR = "-";
    private static final String CARD = "card";

    public static CashReceiptDto mapToDtoFromArray(String[] args) {
        var card = Arrays.stream(args).filter(a -> a.split(SEPARATOR)[0].equalsIgnoreCase(CARD)).findFirst();
        var itemsArray = Arrays.stream(args)
                .filter(a -> !a.split(SEPARATOR)[0].equalsIgnoreCase(CARD)).toArray(String[]::new);

        var dto = new CashReceiptDto();

        Arrays.stream(itemsArray).forEach(item -> dto.addPosition(
                item.split(SEPARATOR)[0],
                Integer.parseInt(item.split(SEPARATOR)[1])));

        card.ifPresent(dto::setCardNumber);

        return dto;
    }
}
