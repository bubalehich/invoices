package by.bubalehich.invoices.api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CashReceiptCreateModel {
    @NotNull
    private List<String> itemQuantityList;

    @Pattern(regexp = "\\d+", message = "Only digits.")
    private String cardNumber;
}
