package ru.vorobev.calculatevacationpay.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vorobev.calculatevacationpay.dto.ErrorMessage;
import ru.vorobev.calculatevacationpay.exception.NotNullException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 * Class for calculate vacation pay
 *
 * @author Maxim Vorobev-Kovrov
 */
@Slf4j
@Service
public class CalculateVacationPay {
    private final static BigDecimal AVERAGE_NUMBER_OF_DAYS_IN_YEAR = new BigDecimal("29.3");
    private final static BigDecimal COUNT_MONTHS_IN_YEAR = new BigDecimal("12");

    /**
     * @param employeeIncomeForYear total income
     * @param numberOfVacationDays  total vacation days
     * @return total payments
     */

    public BigDecimal calculateVacationPay(BigDecimal employeeIncomeForYear,
                                           int numberOfVacationDays) {
        log.debug("calculateVacationPay()-start. employeeIncomeForYear = {} numberOfVacationDay {}",
                employeeIncomeForYear,
                numberOfVacationDays);

        return employeeIncomeForYear
                .divide(COUNT_MONTHS_IN_YEAR, 2, RoundingMode.HALF_UP)
                .divide(AVERAGE_NUMBER_OF_DAYS_IN_YEAR, 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(numberOfVacationDays));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> exceptionHandler(NotNullException notNullException) {
        log.error("Тут логгируешь ошибку.");
        //формируешь дто ответа. Типа ErrorResponse (создай ее с полем, например message)
        //тут в боди запихнешь свою ErrorResponse и в поле message положешь ex.getMessage()
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("Not ", notNullException.getMessage(), LocalDateTime.now()));
    }
}
