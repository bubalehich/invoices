package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.repository.CardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {
    private CardRepository repository;

    @Transactional(readOnly = true)
    public Card getByBarcode(String barcode) {
        return Optional.ofNullable(repository.findByBarcode(barcode)).orElseThrow(()
                -> new EntityNotFoundException(String.format("Card with barcode: %s not found", barcode)));
    }
}
