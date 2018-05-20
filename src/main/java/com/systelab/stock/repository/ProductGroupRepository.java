package com.systelab.stock.repository;

import com.systelab.stock.model.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "productgroups", path = "productgroups")
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {


}