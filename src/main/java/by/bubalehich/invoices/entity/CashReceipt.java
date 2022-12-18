package by.bubalehich.invoices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "card_receipts")
public class CashReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String cashier;

    @OneToMany(mappedBy = "cashReceipt")
    private List<Position> positions = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private Date date;

    @Column
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;
}
