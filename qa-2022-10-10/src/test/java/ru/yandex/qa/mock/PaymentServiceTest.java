package ru.yandex.qa.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.qa.mock.rest.CbrRestHttpService;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

class PaymentServiceTest {

    private CbrRestHttpService cbrRestHttpServiceMock = mock(CbrRestHttpService.class);

    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        paymentService = new PaymentService(cbrRestHttpServiceMock);
    }

    /**
     * 1) Данные, по которым вы хотите проверить работу вашего сервиса
     * 2) Моки нужных сервисов внутри вашего так, как вам надо
     * 3) Вызов важего сервиса и получение результата
     * 4) Все нужные вам проверки
     */

    @Test
    void processDollarsInRubTest() {
        BigDecimal dollars = new BigDecimal(100);

        when(cbrRestHttpServiceMock.rateDollarInRub()).thenReturn(new BigDecimal(75));

        BigDecimal rub = paymentService.processDollarsInRub(dollars);

        Assertions.assertAll(
                () -> Assertions.assertEquals(new BigDecimal(7500), rub),
                () -> verify(cbrRestHttpServiceMock, times(1)).rateDollarInRub()
        );
    }
}