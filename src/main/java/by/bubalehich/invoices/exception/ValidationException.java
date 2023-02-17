package by.bubalehich.invoices.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
