package com.tech.eleccomm.application.mappers;

import com.tech.eleccomm.application.dto.PriceRateDto;
import com.tech.eleccomm.domain.model.Price;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceToPriceRateDto {

    private ModelMapper modelMapper;

    public PriceRateDto entityToDto(Price price) {
        PriceRateDto dto = modelMapper.map(price, PriceRateDto.class);
        return dto;
    }
}
