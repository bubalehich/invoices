package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.repository.CashReceiptRepository;
import by.bubalehich.invoices.service.mapper.CashReceiptMapper;
import by.bubalehich.invoices.service.validator.ArgumentValidator;
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

    private CashReceiptCalculator calculator;

    @Transactional
    public CashReceipt create(String[] args) {
        var validationResult = ArgumentValidator.validate(args);

        if (!validationResult.isSucceed()) {
            System.out.println("FAIL: " + validationResult.getErrors());
            //TODO add logger
        }

        CashReceipt cashReceipt = new CashReceipt();

        var cashReceiptDto = CashReceiptMapper.mapToDtoFromArray(args);

        if (cashReceiptDto.hasCard()) {
            Card card = cardService.getByBarcode(cashReceiptDto.getCardNumber());
            cashReceipt.setCard(card);
        }

        cashReceiptDto.getPositions().forEach(dto -> {
            Item item = itemService.getByBarcode(dto.getItem());
            cashReceipt.addPosition(new Position(item, dto.getCount(), cashReceipt));
        });

        cashReceipt.setDate(new Date());
        cashReceipt.setCashier("Random Name");
        cashReceipt.setBarcode(UUID.randomUUID().toString());

        var totalSumWithoutDiscount = calculator.calculateTotalSumWithoutDiscount(cashReceipt);
        int countOfDiscountPositions = calculator.calculateCountOfDiscountPositions(cashReceipt);
        var discount = calculator.calculateDiscount(totalSumWithoutDiscount, countOfDiscountPositions);

        cashReceipt.setDiscount(discount);
        cashReceipt.setTotal(totalSumWithoutDiscount);
        cashReceipt.setTaxableTotal(totalSumWithoutDiscount.subtract(discount));

        return cashReceipt;
    }

    @Transactional
    public CashReceipt save(CashReceipt cashReceipt) {
        return repository.save(cashReceipt);
    }
}
