package com.systelab.inventory.repository;

import com.systelab.inventory.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {


}