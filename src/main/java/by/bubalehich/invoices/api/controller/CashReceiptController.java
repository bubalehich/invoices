package by.bubalehich.invoices.api.controller;

import by.bubalehich.invoices.api.CashReceiptApi;
import by.bubalehich.invoices.api.model.CashReceiptCreateModel;
import by.bubalehich.invoices.api.model.CashReceiptUpdateModel;
import by.bubalehich.invoices.api.model.CashReceiptViewModel;
import by.bubalehich.invoices.api.validator.CashReceiptModelValidator;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.mapper.CashReceiptMapper;
import by.bubalehich.invoices.service.core.CashReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@AllArgsConstructor
public class CashReceiptController implements CashReceiptApi {
    private CashReceiptService service;
    private CashReceiptModelValidator validator;
    private CashReceiptMapper mapper;

    @Override
    public ResponseEntity<CashReceiptViewModel> createCashReceipt(CashReceiptCreateModel model) {
        validator.validate(model);

        CashReceipt cashReceipt = service.create(model);
        CashReceiptViewModel viewModel = mapper.mapToViewFromCashReceipt(cashReceipt);

        var uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(viewModel.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(viewModel);
    }

    @Override
    public ResponseEntity<CashReceiptViewModel> getCashReceipt(Long id) {
        var cashReceipt = service.get(id);
        var viewModel = mapper.mapToViewFromCashReceipt(cashReceipt);

        return ResponseEntity.ok(viewModel);
    }

    @Override
    public ResponseEntity<CashReceiptViewModel> updateCashReceipt(Long id, CashReceiptUpdateModel model) {
        var cashReceipt = service.update(mapper.mapFromView(model));
        var viewModel = mapper.mapToViewFromCashReceipt(cashReceipt);

        return ResponseEntity.ok(viewModel);
    }

    @Override
    public ResponseEntity<CashReceiptViewModel> archive(Long id) {
        service.delete(id);
        var cashReceipt = service.get(id);
        var viewModel = mapper.mapToViewFromCashReceipt(cashReceipt);

        return ResponseEntity.ok(viewModel);
    }
}
