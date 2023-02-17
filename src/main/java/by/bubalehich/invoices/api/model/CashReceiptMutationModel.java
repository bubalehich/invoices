package by.bubalehich.invoices.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CashReceiptMutationModel {
    private List<String> itemQuantityList;

    private String cardNumber;
}
