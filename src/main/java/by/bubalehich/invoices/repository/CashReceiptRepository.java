package by.bubalehich.invoices.repository;

import by.bubalehich.invoices.entity.CashReceipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashReceiptRepository extends CrudRepository<CashReceipt, Long> {
}
