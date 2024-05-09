package com.tech.eleccomm.infrastucture.controllers;

import com.tech.eleccomm.application.dto.PriceRateDto;
import com.tech.eleccomm.application.service.PriceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@Tag(name = "PriceRateController", description = "Service to obtain the price list for a product, brand and date")
public class PriceRateController {

    private final PriceService priceService;

    public PriceRateController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/priceRate")
    public ResponseEntity<PriceRateDto> getPriceRate(
            @Parameter(description = "Price rate request date", required = true)  @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @Parameter(description = "Product ID for price list", required = true) @RequestParam("product") Long product,
            @Parameter(description = "Brand ID for price list", required = true) @RequestParam("brand") Long brand) {
        PriceRateDto priceRate = priceService.findPrice(dateTime, product, brand);
        if(priceRate == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(priceRate);
    }
}
