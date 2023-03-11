package by.bubalehich.invoices.entity;

import by.bubalehich.invoices.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Card extends BaseEntity {
    @Column(unique = true, nullable = false, length = 45)
    private String barcode;

    @Column
    private String holderName;

    public Card(String barcode) {
        this.barcode = barcode;
    }
}
