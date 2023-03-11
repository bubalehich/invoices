package by.bubalehich.invoices.service.core;

import by.bubalehich.invoices.entity.Item;
import by.bubalehich.invoices.repository.ItemRepository;
import by.bubalehich.invoices.service.ItemServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ItemService implements ItemServiceInterface {
    private ItemRepository repository;

    @Transactional(readOnly = true)
    public Item getByBarcode(String barcode) {
        return Optional.ofNullable(repository.findByBarcode(barcode)).orElseThrow(()
                -> new EntityNotFoundException(String.format("Item with barcode: %s not found", barcode)));
    }

    public boolean isExist(String barcode) {
        return repository.existsByBarcode(barcode);
    }

    @Override
    public Item create(Item entity) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public void delete(Long entityId) {
        //TODO will be implemented in another feature
    }

    @Override
    public Item update(Item entity) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public Item get(Long entityId) {
        //TODO will be implemented in another feature
        return null;
    }
}
