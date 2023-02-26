package by.bubalehich.invoices.util.mapper;

import java.math.BigDecimal;

public record CalculatorResult(BigDecimal amount, BigDecimal discount, BigDecimal totalAmount) {
}
