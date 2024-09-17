package ru.vorobev.calculatevacationpay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateVacationPayController {
    @GetMapping("/calculate")
    public void calculateVacationPay(){
    }
}
