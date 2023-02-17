package by.bubalehich.invoices.api.validator;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CashReceiptModelValidator {

    public void validate(CashReceiptMutationModel model) {
        if (!isValidCardFormat(model.getCardNumber())) {
            throw new ValidationException("Invalid card format.");
        }

        if (!isValidItemQuantityList(model.getItemQuantityList())) {
            throw new ValidationException("Invalid item(s) format.");
        }
    }

    private boolean isValidItemQuantityList(List<String> quantityItemList) {
        return quantityItemList.stream()
                .allMatch(item -> item
                        != null && !item.isBlank()
                        && item.matches("\\d+-\\d+"));
    }

    private boolean isValidCardFormat(String card) {
        if (card != null) {
            return card.matches("\\d+");
        }

        return true;
    }
}
