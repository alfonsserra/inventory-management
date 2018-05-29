package com.systelab.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by nydiarra on 06/05/17.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="app_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name", unique = true)
    private String roleName;

    @Column(name="description")
    private String description;


}