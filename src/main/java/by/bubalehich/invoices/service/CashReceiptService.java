package by.bubalehich.invoices.service;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.repository.CashReceiptRepository;
import by.bubalehich.invoices.mapper.PositionMapper;
import by.bubalehich.invoices.util.CashReceiptCalculator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CashReceiptService {

    private CashReceiptRepository repository;

    private ItemService itemService;

    private CardService cardService;

    private PositionService positionService;

    private CashReceiptCalculator calculator;

    @Transactional
    public CashReceipt create(CashReceiptMutationModel model) {
        CashReceipt cashReceipt = new CashReceipt();

        model.getItemQuantityList().stream()
                .map(PositionMapper::mapToPositionDtoFromString)
                .filter(p -> itemService.isExist(p.getItem()))
                .map(p -> new Position(itemService.getByBarcode(p.getItem()), p.getCount(), cashReceipt))
                .forEach(cashReceipt::addPosition);

        var card = cardService.getByBarcode(model.getCardNumber());

        cashReceipt.setCard(card);
        cashReceipt.setDate(new Date());
        cashReceipt.setCashier("Dummy Name");
        cashReceipt.setBarcode(UUID.randomUUID().toString());

        closeCashReceipt(cashReceipt);

        repository.save(cashReceipt);
        cashReceipt.getPositions().forEach(positionService::save);

        return cashReceipt;
    }

    private CashReceipt closeCashReceipt(CashReceipt cashReceipt) {
        var totalSumWithoutDiscount = calculator.calculateTotalSumWithoutDiscount(cashReceipt);
        int countOfDiscountPositions = calculator.calculateCountOfDiscountPositions(cashReceipt);
        var discount = calculator.calculateDiscount(totalSumWithoutDiscount, countOfDiscountPositions);

        cashReceipt.setDiscount(discount);
        cashReceipt.setTotal(totalSumWithoutDiscount);
        cashReceipt.setTaxableTotal(totalSumWithoutDiscount.subtract(discount));

        return cashReceipt;
    }
}
