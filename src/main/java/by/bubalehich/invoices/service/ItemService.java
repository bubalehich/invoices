package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemService {

    private ItemRepository repository;

    @Transactional(readOnly = true)
    public Item getByBarcode(String barcode) {
        return Optional.ofNullable(repository.findByBarcode(barcode)).orElseThrow(()
                -> new EntityNotFoundException(String.format("Item with barcode: %s not found", barcode)));
    }
}
