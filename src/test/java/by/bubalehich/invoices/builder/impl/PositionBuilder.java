package by.bubalehich.invoices.builder.impl;

import by.bubalehich.invoices.builder.TestBuilder;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.entity.Position;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor(staticName = "aPosition")
@With
public class PositionBuilder implements TestBuilder<Position> {
    private int count = 1;


    @Override
    public Position build() {
        return Position.builder()
                .count(count)
                .build();
    }
}
