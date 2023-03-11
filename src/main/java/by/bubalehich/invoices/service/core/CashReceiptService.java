package by.bubalehich.invoices.service.core;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.mapper.PositionMapper;
import by.bubalehich.invoices.repository.CashReceiptRepository;
import by.bubalehich.invoices.service.CashReceiptServiceInterface;
import by.bubalehich.invoices.util.CashReceiptCalculator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CashReceiptService implements CashReceiptServiceInterface {
    private CashReceiptRepository repository;

    private ItemService itemService;

    private CardService cardService;

    private PositionService positionService;

    private CashReceiptCalculator calculator;

    private PositionMapper mapper;

    @Transactional
    public CashReceipt create(CashReceiptMutationModel model) {
        CashReceipt cashReceipt = new CashReceipt();

        model.getItemQuantityList().stream()
                .map(mapper::mapToPositionDtoFromString)
                .filter(p -> itemService.isExist(p.getItem()))
                .map(p -> new Position(itemService.getByBarcode(p.getItem()), p.getCount(), cashReceipt))
                .forEach(cashReceipt::addPosition);

        var card = cardService.getByBarcode(model.getCardNumber());

        cashReceipt.setCard(card);
        cashReceipt.setDate(new Date());
        cashReceipt.setCashier("Dummy Name");
        cashReceipt.setBarcode(UUID.randomUUID().toString());

        var calculations = calculator.calculate(cashReceipt);

        cashReceipt.setAmount(calculations.amount());
        cashReceipt.setDiscount(calculations.discount());
        cashReceipt.setTotalAmount(calculations.totalAmount());

        repository.save(cashReceipt);
        cashReceipt.getPositions().forEach(positionService::save);

        return cashReceipt;
    }

    public CashReceipt get(Long id) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public CashReceipt create(CashReceipt entity) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public void delete(Long id) {
        //TODO will be implemented in another feature
    }

    @Override
    public CashReceipt update(CashReceipt entity) {
        //TODO will be implemented in another feature
        return null;
    }
}
