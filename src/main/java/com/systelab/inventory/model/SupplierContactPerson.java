package com.systelab.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierContactPerson extends BaseEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private String fullName;
    private String email;
    private String phone;
    private String comments;

}
