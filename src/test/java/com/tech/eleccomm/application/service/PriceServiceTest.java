package com.tech.eleccomm.application.service;

import com.tech.eleccomm.application.dto.PriceRateDto;
import com.tech.eleccomm.application.find.FindPricesUseCase;
import com.tech.eleccomm.application.mappers.PriceToPriceRateDto;
import com.tech.eleccomm.domain.model.Brand;
import com.tech.eleccomm.domain.model.Price;
import com.tech.eleccomm.domain.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private FindPricesUseCase findPricesUseCase;
    @Mock
    private PriceToPriceRateDto priceToPriceRateDto;
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        priceService = new PriceService(findPricesUseCase, priceToPriceRateDto);
    }

    @Test
    void findPrice() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 05, 1, 10, 1);
        Price price = new Price(1L, new Brand(1L, "::name::"),
                dateTime, dateTime, 1,
                new Product(1L, "::product::", "::desc::",
                        true, "::color::"), (byte) 0, BigDecimal.ONE, "EUR");
        PriceRateDto priceRate = new PriceRateDto(1L, 1L, dateTime, dateTime, BigDecimal.ONE);

        when(findPricesUseCase.findByDateAndProducAndBrand(dateTime, 1L, 1L)).thenReturn(price);
        when(priceToPriceRateDto.entityToDto(price)).thenReturn(priceRate);
        PriceRateDto result = this.priceService.findPrice(dateTime, 1L, 1L);
        Assertions.assertEquals(priceRate, result);
    }
}
