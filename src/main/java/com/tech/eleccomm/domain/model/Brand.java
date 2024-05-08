package com.tech.eleccomm.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "name")
    private String name;

}
