package by.bubalehich.invoices.exception.handler;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(HttpStatus status, Integer code, String message) {
}
