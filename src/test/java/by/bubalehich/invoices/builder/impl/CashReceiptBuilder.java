package by.bubalehich.invoices.builder.impl;

import by.bubalehich.invoices.builder.TestBuilder;
import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Position;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(staticName = "aCashReceipt")
@With
public class CashReceiptBuilder implements TestBuilder<CashReceipt> {
    private String barcode = "1234";

    private String name = "Some Name";

    private Date date = new Date();

    private Card card = new Card();

    private Position position = new Position();

    private BigDecimal amount = BigDecimal.valueOf(100);

    private BigDecimal discount = BigDecimal.valueOf(0);

    private BigDecimal totalAmount = BigDecimal.valueOf(100);

    @Override
    public CashReceipt build() {
        return CashReceipt.builder()
                .barcode(barcode)
                .date(date)
                .cashier(name)
                .card(card)
                .positions(List.of(position))
                .amount(amount)
                .discount(discount)
                .totalAmount(amount)
                .build();
    }
}
