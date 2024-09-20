package ru.vorobev.calculatevacationpay.service;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.math.RoundingMode;
@Slf4j
@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Validated
public class CalculateVacationPay {
    private final static BigDecimal AVERAGE_NUMBER_OF_DAYS_IN_YEAR = new BigDecimal("29.3");
    private final static BigDecimal COUNT_MONTHS_IN_YEAR = new BigDecimal("12");
    private BigDecimal amountOfVacationPayPerDay;
    private BigDecimal vacationPayAmountForVacation;
    private BigDecimal employeeIncomeForYear;
    private int numberOfVacationDays;

    public BigDecimal calculateAmountOfVacationPerDay(BigDecimal employeeIncomeForYear) {
        log.info("calculateAmountOfVacationPerDay");
        return amountOfVacationPayPerDay = new BigDecimal(String.valueOf(employeeIncomeForYear))
                .divide(COUNT_MONTHS_IN_YEAR, 2, RoundingMode.HALF_UP)
                .divide(AVERAGE_NUMBER_OF_DAYS_IN_YEAR, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateVacationPay(BigDecimal employeeIncomeForYear, int numberOfVacationDays) {
        log.info("calculateVacationPay");
        vacationPayAmountForVacation = calculateAmountOfVacationPerDay(employeeIncomeForYear)
                .multiply(BigDecimal.valueOf(numberOfVacationDays));
        return vacationPayAmountForVacation;
    }
}
