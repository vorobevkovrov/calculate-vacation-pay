package ru.vorobev.calculatevacationpay.controller;


import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vorobev.calculatevacationpay.service.CalculateVacationPay;

import java.math.BigDecimal;

import static ru.vorobev.calculatevacationpay.controller.CalculateVacationPayController.BASE_URL;

@Validated
@Slf4j
@RequiredArgsConstructor
@RestController(BASE_URL)
public class CalculateVacationPayController {
    /**
     * Base controller url.
     */
    public static final String BASE_URL = "/api/v1";
    private final CalculateVacationPay calculateVacationPay;

    /**
     * Get method to calculate vacation pay.
     *
     * @param employeeIncomeForYear total income.
     * @param numberOfVacationDays  total vacation days.
     * @return response.
     */
    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateVacationPay(@RequestParam @NotNull BigDecimal employeeIncomeForYear,
                                                           @RequestParam @NotNull int numberOfVacationDays) {
        log.debug("calculateVacationPay() - start. employeeIncomeForYear = {} numberOfVacationDays = {}",
                employeeIncomeForYear,
                numberOfVacationDays);
        return ResponseEntity.ok(calculateVacationPay
                .calculateVacationPay(employeeIncomeForYear, numberOfVacationDays));
    }
}
