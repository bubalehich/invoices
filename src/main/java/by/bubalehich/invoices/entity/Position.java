package by.bubalehich.invoices.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "cashReceiptId", nullable = false)
    private CashReceipt cashReceipt;

    @Column(nullable = false)
    private int count;

    public Position(Item item, int count, CashReceipt cashReceipt) {
        this.item = item;
        this.count = count;
        this.cashReceipt = cashReceipt;
    }
}
