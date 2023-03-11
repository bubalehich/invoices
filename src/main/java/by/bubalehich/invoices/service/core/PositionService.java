package by.bubalehich.invoices.service.core;

import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.repository.PositionRepository;
import by.bubalehich.invoices.service.PositionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PositionService implements PositionServiceInterface {
    private PositionRepository repository;

    public Position save(Position position) {
        return repository.save(position);
    }

    @Override
    public Position create(Position entity) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public void delete(Long entityId) {
        //TODO will be implemented in another feature
    }

    @Override
    public Position update(Position entity) {
        //TODO will be implemented in another feature
        return null;
    }

    @Override
    public Position get(Long entityId) {
        //TODO will be implemented in another feature
        return null;
    }
}
