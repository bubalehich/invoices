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
@Table
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

    @Column
    private BigDecimal taxableTotal;

    @Column
    private BigDecimal discount;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    public void addPosition(Position position) {
        positions.add(position);
    }
}
