package com.tech.eleccomm.domain.repository;

import com.tech.eleccomm.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface IPriceDao extends JpaRepository<Price, Long> {

    @Query("SELECT P FROM Price P WHERE :dateTime BETWEEN startDate AND endDate AND productId.product_id = :product AND brandId.brandId = :brand ORDER BY priority DESC LIMIT 1")
    Price findByDateAndProductAndBrand(LocalDateTime dateTime, Long product, Long brand);
}
