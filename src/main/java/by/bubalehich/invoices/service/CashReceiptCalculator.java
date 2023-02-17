package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Position;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CashReceiptCalculator {
    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0.1);

    public BigDecimal calculateTotalSumWithoutDiscount(CashReceipt cashReceipt) {
        var positionSumList = cashReceipt.getPositions().stream()
                .map(p -> p.getItem().getPrice().multiply(new BigDecimal(p.getCount())))
                .toList();

        return positionSumList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateDiscount(BigDecimal totalSum, int countOfDiscountPositions) {
        return countOfDiscountPositions > 5
                ? totalSum.multiply(DISCOUNT)
                : BigDecimal.ZERO;
    }

    public int calculateCountOfDiscountPositions(CashReceipt cashReceipt) {
        return cashReceipt.getPositions().stream()
                .filter(p -> p.getItem().isOnDiscount())
                .map(Position::getCount)
                .reduce(0, Integer::sum);
    }
}
