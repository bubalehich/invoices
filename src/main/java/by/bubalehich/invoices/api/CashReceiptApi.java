package by.bubalehich.invoices.api;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/cashreceipt")
public interface CashReceiptApi {

    @PostMapping
    ResponseEntity<CashReceiptViewModel> createCashReceipt(@RequestBody @Valid CashReceiptMutationModel model);
}
