package com.tech.eleccomm.application.find;

import com.tech.eleccomm.domain.model.Brand;
import com.tech.eleccomm.domain.model.Price;
import com.tech.eleccomm.domain.model.Product;
import com.tech.eleccomm.domain.repository.IPriceDao;
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
class FindPricesUseCaseTest {

    @Mock
    private IPriceDao priceDaoMock;

    private FindPricesUseCase findPricesUseCase;

    @BeforeEach
    void setUp() {
        findPricesUseCase = new FindPricesUseCase(priceDaoMock);
    }

    @Test
    void findByDateAndProducAndBrand() {
        Price price = new Price(1L, new Brand(1L, "::name::"),
                LocalDateTime.now(), LocalDateTime.now(), 1,
                new Product(1L, "::product::", "::desc::",
                        true, "::color::"), (byte) 0, BigDecimal.ONE, "EUR");
        when(priceDaoMock.findByDateAndProductAndBrand(LocalDateTime.of(2024, 05, 1, 10, 1), 1L, 1L)).thenReturn(price);
        Price result = findPricesUseCase.findByDateAndProducAndBrand(LocalDateTime.of(2024, 05, 1, 10, 1), 1L, 1L);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("EUR", result.getCurr());
    }
}
