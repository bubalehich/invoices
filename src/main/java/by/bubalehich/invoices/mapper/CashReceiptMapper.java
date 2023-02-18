package by.bubalehich.invoices.mapper;

import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import by.bubalehich.invoices.api.model.PositionViewModel;
import by.bubalehich.invoices.entity.CashReceipt;

import java.math.BigDecimal;
import java.util.UUID;

public final class CashReceiptMapper {

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
