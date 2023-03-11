package by.bubalehich.invoices.service;

import org.springframework.stereotype.Service;

public interface ServiceInterface<Id, Type> {

    Type create(Type entity);

    void delete(Id entityId);

    Type update(Type entity);

    Type get(Id entityId);
}
