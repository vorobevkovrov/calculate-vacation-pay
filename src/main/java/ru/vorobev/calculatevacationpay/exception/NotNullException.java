package ru.vorobev.calculatevacationpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NotNullException extends AppException{
    public NotNullException(String message) {
        super(message);
    }
}
