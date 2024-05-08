package com.tech.eleccomm.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "price_id")
    private Long priceId;
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "price_list")
    private Integer priceList;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    @Column(name = "priority")
    private Byte priority;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "curr")
    private String curr;

}
