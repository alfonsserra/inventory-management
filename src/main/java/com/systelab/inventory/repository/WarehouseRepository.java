package com.systelab.inventory.repository;

import com.systelab.inventory.model.Warehouse;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    List findByName(@Param("name") String name);

    @ApiOperation(value = "Find the warehouses with a name containing certain keywords", notes = "Here I have some notes")
    List findByNameContains(@Param("keyword") String keyword);

    @Override
    @RestResource(exported = false)
    void delete(Warehouse entity);

}
