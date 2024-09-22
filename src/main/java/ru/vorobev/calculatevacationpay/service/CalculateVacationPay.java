package ru.vorobev.calculatevacationpay.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
}
