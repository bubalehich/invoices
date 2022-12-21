package by.bubalehich.invoices.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "card_receipts")
public class CashReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 45)
    private String barcode;

    @Column(nullable = false)
    private String cashier;

    @OneToMany(mappedBy = "cashReceipt")
    private List<Position> positions = new LinkedList<>();

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private Date date;

    @Column
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    public void addPosition(Position position) {
        positions.add(position);
    }
}
