package com.tech.eleccomm.domain.repository;

import com.tech.eleccomm.domain.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandDao extends JpaRepository<Brand, Long> {

}
