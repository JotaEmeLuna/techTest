package com.tech.eleccomm.infrastucture.controllers;

import com.tech.eleccomm.application.dto.PriceRateDto;
import com.tech.eleccomm.application.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class ProductController {

    private final PriceService priceService;

    public ProductController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/products")
    public @ResponseBody ResponseEntity<PriceRateDto> getProduct(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
            @RequestParam("product") Long product,
            @RequestParam("brand") Long brand) {
        return ResponseEntity.ok(priceService.findPrice(dateTime, product, brand));
    }
}
