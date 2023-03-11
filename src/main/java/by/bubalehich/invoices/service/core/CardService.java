package by.bubalehich.invoices.service.core;

import by.bubalehich.invoices.entity.Card;
import by.bubalehich.invoices.repository.CardRepository;
import by.bubalehich.invoices.service.CardServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService implements CardServiceInterface {
    private CardRepository repository;

    @Transactional(readOnly = true)
    public Card getByBarcode(String barcode) {
        return Optional.ofNullable(repository.findByBarcode(barcode)).orElseThrow(()
                -> new EntityNotFoundException(String.format("Card with barcode: %s not found", barcode)));
    }

    @Override
    public CardService create(CardService entity) {

        return null;
    }

    @Override
    public void delete(Long entityId) {
        //TODO will be implemented in another feature
    }

    @Override
    public CardService update(CardService entity) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public CardService get(Long entityId) {
        //TODO will be implemented in another feature
        return null;
    }
}
