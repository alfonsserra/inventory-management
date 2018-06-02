package com.systelab.inventory.controller;


import com.systelab.inventory.model.Supplier;
import com.systelab.inventory.repository.SupplierRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Api(tags = {"Supplier Entity"})
@CrossOrigin(origins = "*", allowedHeaders="*", exposedHeaders = "Authorization", allowCredentials = "true")
@RestController
@RequestMapping("/api/suppliers")
@PreAuthorize("hasAuthority('USER')")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options() {
        return ResponseEntity.ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.HEAD, HttpMethod.OPTIONS, HttpMethod.PUT, HttpMethod.DELETE)
                .build();
    }

    @ApiOperation(value = "Get all the suppliers", authorizations = {@Authorization(value = "Bearer")})
    @GetMapping
    ResponseEntity<Page<Supplier>> findAllSupplier(Pageable pageable) {
        return ResponseEntity.ok(this.supplierRepository.findAll(pageable));
    }

    @ApiOperation(value = "Get one supplier", authorizations = {@Authorization(value = "Bearer")})
    @GetMapping(value = "/{id}")
    ResponseEntity<Supplier> findOneSupplier(@PathVariable Long id) {
        return this.supplierRepository.findById(id).map(ResponseEntity::ok).orElseThrow(() -> new SupplierNotFoundException(id));
    }

    @ApiOperation(value = "Create a new supplier", authorizations = {@Authorization(value = "Bearer")})
    @PostMapping
    ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier s) {

        Supplier supplier = this.supplierRepository.save(s);

        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(supplier.getId()).toUri();
        return ResponseEntity.created(uri).body(supplier);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Delete a supplier", authorizations = {@Authorization(value = "Bearer")})
    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        return this.supplierRepository.findById(id)
                .map(c -> {
                    supplierRepository.delete(c);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new SupplierNotFoundException(id));
    }

    @ApiOperation(value = "Check if the supplier exists", authorizations = {@Authorization(value = "Bearer")})
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    ResponseEntity<?> existSupplier(@PathVariable Long id) {
        return this.supplierRepository.findById(id)
                .map(exists -> ResponseEntity.noContent().build())
                .orElseThrow(() -> new SupplierNotFoundException(id));
    }

    @ApiOperation(value = "Update a supplier", authorizations = {@Authorization(value = "Bearer")})
    @PutMapping(value = "/{id}")
    ResponseEntity<Supplier> saveSupplier(@PathVariable Long id, @RequestBody Supplier s) {
        return this.supplierRepository
                .findById(id)
                .map(existing -> {
                    s.setId(id);
                    Supplier supplier = this.supplierRepository.save(s);
                    URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
                    return ResponseEntity.created(selfLink).body(supplier);
                }).orElseThrow(() -> new SupplierNotFoundException(id));
    }
}