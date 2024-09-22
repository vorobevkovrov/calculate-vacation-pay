package ru.vorobev.calculatevacationpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.vorobev.calculatevacationpay.dto.ErrorMessage;

import java.time.LocalDateTime;

public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotNullException.class)
    public ResponseEntity<ErrorMessage> notNull(NotNullException notNullException) {
        ErrorMessage errorMessage = new ErrorMessage("Value must be not null",
                notNullException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorMessage, HttpStatus.NO_CONTENT);
    }
}
