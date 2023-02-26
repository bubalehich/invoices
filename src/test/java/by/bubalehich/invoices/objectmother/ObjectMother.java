package by.bubalehich.invoices.objectmother;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.dto.PositionDto;
import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.util.mapper.CalculatorResult;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ObjectMother {
    public static CashReceiptMutationModel getCashReceiptMutationModel() {
        return CashReceiptMutationModel.builder()
                .cardNumber("1234")
                .itemQuantityList(List.of("2-2"))
                .build();
    }

    public static CashReceiptMutationModel getCashReceiptMutationModelWithInvalidCard() {
        return CashReceiptMutationModel.builder()
                .cardNumber("123f4")
                .itemQuantityList(List.of("2-2"))
                .build();
    }

    public static CashReceiptMutationModel getCashReceiptMutationModelWithInvalidItem() {
        return CashReceiptMutationModel.builder()
                .cardNumber("1234")
                .itemQuantityList(List.of("22"))
                .build();
    }

    public static Card getCard() {
        return Card.builder()
                .barcode("1234")
                .build();
    }

    public static List<Position> getPositions() {
        return List.of(Position.builder()
                .item(getItem())
                .count(2)
                .build());
    }

    public static Item getItem() {
        return Item.builder()
                .barcode("2")
                .price(BigDecimal.ONE)
                .build();
    }

    public static Item getDiscountItem() {
        return Item.builder()
                .price(BigDecimal.valueOf(10))
                .isOnDiscount(true)
                .build();
    }

    public static PositionDto getPositionDto() {
        return new PositionDto("2", 2);
    }

    public static CashReceipt getCashReceipt() {
        return CashReceipt.builder()
                .card(getCard())
                .positions(getPositions())
                .build();
    }

    public static CashReceipt getFullCashReceipt() {
        return CashReceipt.builder()
                .barcode(UUID.randomUUID().toString())
                .date(new Date())
                .cashier("Some Name")
                .card(getCard())
                .positions(getPositions())
                .amount(BigDecimal.valueOf(100))
                .discount(BigDecimal.valueOf(50))
                .totalAmount(BigDecimal.valueOf(50))
                .build();
    }

    public static Position getPosition() {
        return Position.builder()
                .item(getItem())
                .count(1)
                .cashReceipt(new CashReceipt())
                .build();
    }

    public static CalculatorResult getCalculatorResultWithoutDiscount() {
        return new CalculatorResult(BigDecimal.valueOf(2), BigDecimal.ZERO, BigDecimal.valueOf(2));
    }

    public static CalculatorResult getCalculatorResultWithDiscount() {
        return new CalculatorResult(BigDecimal.valueOf(100), BigDecimal.valueOf(10.0), BigDecimal.valueOf(90.0));
    }

    public static CashReceipt getCashReceiptWithDiscountPositions() {
        return CashReceipt.builder()
                .card(new Card())
                .positions(List.of(
                        Position.builder()
                                .item(ObjectMother.getDiscountItem())
                                .count(10)
                                .build()))
                .build();
    }
}
