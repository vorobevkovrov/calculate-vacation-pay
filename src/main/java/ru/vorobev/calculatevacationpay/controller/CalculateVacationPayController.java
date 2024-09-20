package ru.vorobev.calculatevacationpay.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vorobev.calculatevacationpay.service.CalculateVacationPay;

import java.math.BigDecimal;
@Slf4j
@AllArgsConstructor
@RestController("/api/v1")
@Validated
public class CalculateVacationPayController {
    private final CalculateVacationPay calculateVacationPay;

    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateVacationPay(@RequestParam BigDecimal employeeIncomeForYear,
                                               @RequestParam int numberOfVacationDays) {
        log.info("CalculateVacationPayController /calculate");
       // return calculateVacationPay.calculateVacationPay(employeeIncomeForYear, numberOfVacationDays);
        return ResponseEntity.ok(calculateVacationPay.calculateVacationPay(employeeIncomeForYear, numberOfVacationDays));
    }
}
//TODO проверка входящих параметров