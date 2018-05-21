package com.systelab.inventory.repository;

import com.systelab.inventory.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface OrderRepository extends JpaRepository<Order, Long> {


}