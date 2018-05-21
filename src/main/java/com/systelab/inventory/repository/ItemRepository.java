package com.systelab.inventory.repository;

import com.systelab.inventory.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {


}