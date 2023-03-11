package by.bubalehich.invoices.entity;

import by.bubalehich.invoices.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
@EqualsAndHashCode
public class Card extends BaseEntity {
    @Column(unique = true, nullable = false, length = 45)
    private String barcode;

    @Column
    private String holderName;

    public Card(String barcode) {
        this.barcode = barcode;
    }
}
