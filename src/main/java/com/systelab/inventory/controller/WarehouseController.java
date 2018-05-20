package com.systelab.inventory.controller;

import com.systelab.inventory.model.Warehouse;
import com.systelab.inventory.repository.WarehouseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = {"Warehouse Entity"})
@RestController()
@CrossOrigin()
@RequestMapping(value = "/warehouses", produces = MediaType.APPLICATION_JSON_VALUE)
public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @ApiOperation(value = "Generate a report for all the warehouses", notes = "")
    @GetMapping("report")
    public List<Warehouse> generateWarehousesReport() {
        return warehouseRepository.findAll();
    }

    @ApiOperation(value = "Get all Warehouses", notes = "")
    @GetMapping("subst")
    public Page<Warehouse> substition(Pageable pageable) {
        return warehouseRepository.findAll(pageable);
    }
}