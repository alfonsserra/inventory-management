package com.systelab.inventory.controller;

import com.systelab.inventory.model.Product;
import com.systelab.inventory.model.ProductGroup;
import com.systelab.inventory.model.Supplier;
import com.systelab.inventory.model.Warehouse;
import com.systelab.inventory.repository.ProductGroupRepository;
import com.systelab.inventory.repository.ProductRepository;
import com.systelab.inventory.repository.SupplierRepository;
import com.systelab.inventory.repository.WarehouseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = {"Application Entity"})
@RestController()
@CrossOrigin()
@RequestMapping(value = "application", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "Init some data", notes = "")
    @PostMapping("init")
    public boolean initSomeData() {
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("Rotterdam");
        warehouseRepository.save(warehouse1);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setName("Hong Kong");
        Warehouse hk = warehouseRepository.save(warehouse2);

        Supplier supplier1 = new Supplier();
        supplier1.setName("Amazon");
        supplierRepository.save(supplier1);

        Supplier supplier2 = new Supplier();
        supplier2.setName("Microsoft");
        supplierRepository.save(supplier2);

        Supplier supplier3 = new Supplier();
        supplier3.setName("Apple");
        Supplier apple = supplierRepository.save(supplier3);

        ProductGroup productgroup1 = new ProductGroup();
        productgroup1.setName("Books");
        productGroupRepository.save(productgroup1);

        ProductGroup productgroup2 = new ProductGroup();
        productgroup2.setName("Computers");
        ProductGroup computers = productGroupRepository.save(productgroup2);

        Product product1 = new Product();
        product1.setName("MacBook Pro");
        product1.setReportDescription("MacBook Pro");
        product1.setCode("435242342");
        product1.setSupplierProductCode("345323423432");
        product1.setSupplier(apple);
        product1.setWarehouse(hk);
        product1.setProductGroup(computers);
        Product macbook = productRepository.save(product1);

        return true;
    }

}