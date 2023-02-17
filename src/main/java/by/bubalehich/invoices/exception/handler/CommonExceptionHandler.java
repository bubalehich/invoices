package by.bubalehich.invoices.exception.handler;

import by.bubalehich.invoices.exception.ValidationException;
import jakarta.servlet.ServletException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ServletException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleServletException(ServletException exception) {
        return new ExceptionResponse(
                INTERNAL_SERVER_ERROR,
                INTERNAL_SERVER_ERROR.value(),
                "Ooops, smth went wrong:("
        );
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(BAD_REQUEST)
    public @ResponseBody ExceptionResponse handleValidationException(ValidationException exception) {
        return new ExceptionResponse(
                BAD_REQUEST,
                BAD_REQUEST.value(),
                exception.getMessage()
        );
    }
}
