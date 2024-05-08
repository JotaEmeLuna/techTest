package com.tech.eleccomm.application.find;

import com.tech.eleccomm.domain.model.Brand;
import com.tech.eleccomm.domain.repository.IBrandDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FindBrandsUseCase {

    final IBrandDao brandDao;

    public List<Brand> findAllBrand() {
        return this.brandDao.findAll();
    }



}
