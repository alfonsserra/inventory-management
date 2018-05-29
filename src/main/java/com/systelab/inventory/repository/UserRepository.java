package com.systelab.inventory.repository;

import com.systelab.inventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(@Param("username") String username);
}