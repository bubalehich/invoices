package by.bubalehich.invoices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    private Integer id;

    private String description;

    private BigDecimal price;

    private boolean isOnDiscount;
}
