package by.bubalehich.invoices.entity;

import by.bubalehich.invoices.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table
@EqualsAndHashCode
public class Item extends BaseEntity {
    @Column(unique = true, nullable = false, length = 45)
    private String barcode;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column
    private boolean isOnDiscount;
}
