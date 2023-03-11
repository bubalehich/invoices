package by.bubalehich.invoices.entity;

import by.bubalehich.invoices.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table
public class Position extends BaseEntity {
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
