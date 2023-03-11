package by.bubalehich.invoices.builder.impl;

import by.bubalehich.invoices.builder.TestBuilder;
import by.bubalehich.invoices.entity.Card;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "aCard")
@With
public class CardBuilder implements TestBuilder<Card> {
    private String barcode = "1234";

    @Override
    public Card build() {
        return Card.builder()
                .barcode(barcode)
                .build();
    }
}
