package com.systelab.inventory.service;

import com.systelab.inventory.model.*;
import com.systelab.inventory.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ApplicationService {

    private final Logger log = LoggerFactory.getLogger(ApplicationService.class);


    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public boolean initSomeData() {
        log.debug("Initializing Data Base");

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
