package by.bubalehich.invoices.api.controller;

import by.bubalehich.invoices.api.CashReceiptApi;
import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import by.bubalehich.invoices.api.validator.CashReceiptModelValidator;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.mapper.CashReceiptMapper;
import by.bubalehich.invoices.service.CashReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@AllArgsConstructor
public class CashReceiptController implements CashReceiptApi {
    private CashReceiptService service;
    private CashReceiptModelValidator validator;

    @Override
    public ResponseEntity<CashReceiptViewModel> createCashReceipt(CashReceiptMutationModel model) {
        validator.validate(model);

        CashReceipt cashReceipt = service.create(model);
        CashReceiptViewModel viewModel = CashReceiptMapper.mapToViewFromCashReceipt(cashReceipt);

        var uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(viewModel.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(viewModel);
    }
}
