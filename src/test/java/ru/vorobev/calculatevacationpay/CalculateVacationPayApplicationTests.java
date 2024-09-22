package ru.vorobev.calculatevacationpay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vorobev.calculatevacationpay.service.CalculateVacationPay;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculateVacationPayApplicationTests {
    private CalculateVacationPay calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculateVacationPay();
    }

    @Test
    public void test_calculate_vacation_pay_should_match_expected_value() {
        BigDecimal employeeIncomeForYear = new BigDecimal(120000);
        int numberOfVacationDays = 28;
        BigDecimal expectedVacationPay = new BigDecimal("9556.40");
        BigDecimal actualVacationPay = calculator.calculateVacationPay(employeeIncomeForYear, numberOfVacationDays);
        assertEquals(expectedVacationPay, actualVacationPay, "The calculated vacation pay should match the expected value.");
    }
}


