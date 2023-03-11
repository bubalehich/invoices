package by.bubalehich.invoices.mapper;

import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import by.bubalehich.invoices.api.model.PositionViewModel;
import by.bubalehich.invoices.entity.CashReceipt;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CashReceiptMapper {

    public CashReceiptViewModel mapToViewFromCashReceipt(CashReceipt receipt) {
        var cashReceiptViewModel = CashReceiptViewModel.builder()
                .cashier(receipt.getCashier())
                .date(receipt.getDate())
                .positions(receipt.getPositions().stream()
                        .map(p -> new PositionViewModel(
                                p.getItem().getDescription(),
                                p.getCount(),
                                p.getItem().getPrice().multiply(BigDecimal.valueOf(p.getCount())))).
                        toList())
                .totalAmount(receipt.getTotalAmount())
                .amount(receipt.getAmount())
                .discount(receipt.getDiscount())
                .build();

        cashReceiptViewModel.setId(UUID.randomUUID());

        return cashReceiptViewModel;
    }
}
