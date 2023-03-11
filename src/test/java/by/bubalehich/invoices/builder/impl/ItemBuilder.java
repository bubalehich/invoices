package by.bubalehich.invoices.builder.impl;

import by.bubalehich.invoices.builder.TestBuilder;
import by.bubalehich.invoices.entity.Item;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor(staticName = "anItem")
@With
public class ItemBuilder implements TestBuilder<Item> {
    private String barcode = "1";

    private BigDecimal price = BigDecimal.ONE;


    @Override
    public Item build() {
        return Item.builder()
                .barcode(barcode)
                .price(price)
                .build();
    }
}
