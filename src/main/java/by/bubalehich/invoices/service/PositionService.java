package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.Position;
import by.bubalehich.invoices.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PositionService {
    private PositionRepository repository;

    public Position save(Position position) {
        return repository.save(position);
    }
}
