package by.bubalehich.invoices.repository;

import by.bubalehich.invoices.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    Card findByBarcode(String barcode);
}
