package by.bubalehich.invoices.repository;

import by.bubalehich.invoices.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Item findByBarcode(String barcode);
}
