package com.tech.eleccomm.domain.repository;

import com.tech.eleccomm.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Long> {
}
