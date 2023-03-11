package by.bubalehich.invoices.api.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CashReceiptUpdateModel {
    @NotNull
    private List<String> itemQuantityList;

    @Pattern(regexp = "\\d+", message = "Only digits.")
    private String cardNumber;

    @NotNull
    @Pattern(regexp = "[A-Za-z ,.'-]+", message = "Only letters.")
    private String cashier;

    @NotNull
    private List<PositionViewModel> positions;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal amount;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal discount;

    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal totalAmount;
}
