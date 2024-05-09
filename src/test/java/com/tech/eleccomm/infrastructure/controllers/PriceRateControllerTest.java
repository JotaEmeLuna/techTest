package com.tech.eleccomm.infrastructure.controllers;

import com.tech.eleccomm.application.dto.PriceRateDto;
import com.tech.eleccomm.application.exceptions.NotFoundException;
import com.tech.eleccomm.application.service.PriceService;
import com.tech.eleccomm.infrastucture.controllers.PriceRateController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PriceRateControllerTest {

    @Mock
    private PriceService priceService;

    private PriceRateController priceRateController;

    @BeforeEach
    void setUp() {
        priceRateController = new PriceRateController(priceService);
    }

    @Test
    void getPriceRateOK() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2024, 05, 1, 10, 1);
        PriceRateDto priceRate = new PriceRateDto(1L, 1L, dateTime, dateTime, BigDecimal.ONE);
        when(priceService.findPrice(dateTime, 1L, 1L)).thenReturn(priceRate);
        ResponseEntity<PriceRateDto> result = priceRateController.getPriceRate(dateTime, 1L, 1L);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(BigDecimal.ONE, result.getBody().getPrice());
    }

    @Test
    void getPriceRateNotFound() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2024, 05, 1, 10, 1);
        when(priceService.findPrice(dateTime, 1L, 1L)).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> priceRateController.getPriceRate(dateTime, 1L, 1L));
    }
}
