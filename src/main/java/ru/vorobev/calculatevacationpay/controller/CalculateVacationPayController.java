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

//import static ru.vorobev.calculatevacationpay.controller.CalculateVacationPayController.BASE_URL;

@Validated
@Slf4j
@RequiredArgsConstructor
@RestController("/api/v1")
public class CalculateVacationPayController {
    private static final String BASE_URL = "/api/v1";
    private final CalculateVacationPay calculateVacationPay;

    @GetMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateVacationPay(@RequestParam @NotNull(message = "ghfeiehn") BigDecimal employeeIncomeForYear,
                                                           @RequestParam @NotNull(message = "int fuiewhugfhwu") int numberOfVacationDays) {
        log.debug("");
        return ResponseEntity.ok(calculateVacationPay.calculateVacationPay(employeeIncomeForYear, numberOfVacationDays));
    }
}
//TODO проверка входящих параметров