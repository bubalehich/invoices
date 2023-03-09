package by.bubalehich.invoices.builder.impl;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.builder.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(staticName = "aCashReceiptMutationModel")
@With
public class CashReceiptMutationModelBuilder implements TestBuilder<CashReceiptMutationModel> {
    private String cardNumber = "1234";

    private List<String> itemQuantityList = List.of("2-2");

    @Override
    public CashReceiptMutationModel build() {
        return CashReceiptMutationModel.builder()
                .cardNumber(cardNumber)
                .itemQuantityList(itemQuantityList)
                .build();
    }
}
