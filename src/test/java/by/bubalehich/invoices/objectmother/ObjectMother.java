package by.bubalehich.invoices.objectmother;

import by.bubalehich.invoices.api.model.CashReceiptMutationModel;
import by.bubalehich.invoices.dto.PositionDto;
import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.entity.CashReceipt;
import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.entity.Position;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ObjectMother {
    //TODO add builders, remove redundant fields, single MO
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
        return new Card(1L, "1234", true, "Some Name");
    }

    public static List<Position> getPositions() {
        return List.of(Position.builder()
                .item(getItem())
                .count(2)
                .build());
    }

    public static Item getItem() {
        return new Item(1L, "2", "Some description", BigDecimal.ONE, false);
    }

    public static Item getDiscountItem() {
        return Item.builder()
                .price(BigDecimal.valueOf(10))
                .isOnDiscount(true)
                .build();
    }

//    public static List<Position> getPositionsWithDiscountItem(){
//        return List
//    }

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
}
