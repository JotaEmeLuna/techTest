package com.tech.eleccomm.application.mappers;

import com.tech.eleccomm.domain.model.Brand;
import com.tech.eleccomm.domain.model.Price;
import com.tech.eleccomm.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PriceToPriceRateDtoTest {

    private ModelMapper modelMapper;

    private PriceToPriceRateDto priceToPriceRateDto;

    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
        priceToPriceRateDto = new PriceToPriceRateDto(modelMapper);
    }

    @Test
    void mapEntityToDto() {
        Price price = new Price(1L, mock(Brand.class),
                LocalDateTime.now(), LocalDateTime.now(),
                1, mock(Product.class),
                (byte) 0, BigDecimal.ONE,
                "");
        Assertions.assertNotNull(priceToPriceRateDto.entityToDto(price));
    }

    @Test
    void mapNullEntityToDto() {
        Price price = null;
        Assertions.assertNull(priceToPriceRateDto.entityToDto(price));
    }
}
