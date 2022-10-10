package ru.yandex.qa.mock;

import ru.yandex.qa.mock.rest.CbrRestHttpService;

import java.math.BigDecimal;

public class PaymentService {

    private final CbrRestHttpService cbrRestHttpService;

    public PaymentService(CbrRestHttpService cbrRestHttpService) {
        this.cbrRestHttpService = cbrRestHttpService;
    }

    public BigDecimal processDollarsInRub(BigDecimal dollars) {
        BigDecimal rate = cbrRestHttpService.rateDollarInRub();
        return dollars.multiply(rate);
    }
}
