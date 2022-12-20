package by.bubalehich.invoices.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.util.Pair;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
public class CashReceiptDto {
    private List<PositionDto> positions = new LinkedList<>();

    private String cardNumber;

    public void addPosition(String item, int count ){
        positions.add(new PositionDto(item, count));
    }
}
