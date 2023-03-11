package by.bubalehich.invoices.api;

import by.bubalehich.invoices.api.model.CashReceiptCreateModel;
import by.bubalehich.invoices.api.model.CashReceiptUpdateModel;
import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequestMapping("api/v1/cashreceipt")
public interface CashReceiptApi {
    @PostMapping
    ResponseEntity<CashReceiptViewModel> createCashReceipt(@RequestBody @Valid CashReceiptCreateModel model);

    @GetMapping("/{id}")
    ResponseEntity<CashReceiptViewModel> getCashReceipt(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<CashReceiptViewModel> updateCashReceipt(@PathVariable Long id, @RequestBody CashReceiptUpdateModel model);

    @PostMapping("/{id}/archived")
    ResponseEntity<CashReceiptViewModel> archive(@NotNull(message = "Id can't be null") @PathVariable Long id);
}
