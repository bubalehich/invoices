package by.bubalehich.invoices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class CashReceipt {
    private Integer id;

    private String cashier;

    private Map<Item, Integer> items;

    private BigDecimal total;

    private Date date;

    private BigDecimal discount;
}
