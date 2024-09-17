package ru.vorobev.calculatevacationpay.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CalculateVacationPay {
    private BigDecimal amountOfVacationPayPerDay;
    private BigDecimal vacationPayAmountForVacation;
    private BigDecimal employeeIncomeForYear;
    private int numberOfVacationDays;

    public BigDecimal calculateAmountOfVacationPerDay(BigDecimal employeeIncomeForYear) {
        return amountOfVacationPayPerDay = new BigDecimal(String.valueOf(employeeIncomeForYear))
                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(29.3), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateVacationPay(BigDecimal employeeIncomeForYear, int numberOfVacationDays) {
//        BigDecimal amountOfVacationPayPerDay = BigDecimal.ZERO;
//        BigDecimal vacationPayAmountForVacation = BigDecimal.ZERO;
//        amountOfVacationPayPerDay = new BigDecimal(String.valueOf(employeeIncomeForYear))
//                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP)
//                .divide(BigDecimal.valueOf(29.3), 2, RoundingMode.HALF_UP);
        vacationPayAmountForVacation = calculateAmountOfVacationPerDay(employeeIncomeForYear)
                .multiply(BigDecimal.valueOf(numberOfVacationDays));
        return vacationPayAmountForVacation;
    }
}
