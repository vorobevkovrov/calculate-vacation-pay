package ru.vorobev.calculatevacationpay.exception;

public class AppException extends Exception{
    private String message;

    public AppException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
