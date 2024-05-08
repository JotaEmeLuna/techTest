package com.tech.eleccomm.application.find;


import com.tech.eleccomm.domain.model.Price;
import com.tech.eleccomm.domain.repository.IPriceDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FindPricesUseCase {

    final IPriceDao priceDao;

    public Price findByDateAndProducAndBrand(LocalDateTime date, Long product, Long brand) {
        return this.priceDao.findByDateAndProductAndBrand(date, product, brand);
    }
}
