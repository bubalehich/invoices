package by.bubalehich.invoices.api.model;

import by.bubalehich.invoices.common.model.ResourceModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CashReceiptViewModel extends ResourceModel {

    private String cashier;

    private Date date;

    private List<PositionViewModel> positions;

    private BigDecimal taxableTotal;

    private BigDecimal discount;

    private BigDecimal total;
}
