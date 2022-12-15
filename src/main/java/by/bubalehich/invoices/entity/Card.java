package by.bubalehich.invoices.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {

    private Long id;

    private String number;

    private boolean isActive;
}
