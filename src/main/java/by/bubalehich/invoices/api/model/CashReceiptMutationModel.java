package by.bubalehich.invoices.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CashReceiptMutationModel {
    @NotNull
    private List<String> itemQuantityList;

    private String cardNumber;
}
