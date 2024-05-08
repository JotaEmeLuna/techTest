package com.tech.eleccomm.application.service;

import com.tech.eleccomm.application.find.FindPricesUseCase;
import com.tech.eleccomm.application.dto.PriceRateDto;
import com.tech.eleccomm.application.mappers.PriceToPriceRateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PriceService {

    private final FindPricesUseCase findPricesUseCase;
    private final PriceToPriceRateDto priceToPriceRateDto;


    public PriceRateDto findPrice(LocalDateTime date, Long product, Long brand) {
        return priceToPriceRateDto.entityToDto(this.findPricesUseCase.findByDateAndProducAndBrand(date, product, brand));
    }

}
