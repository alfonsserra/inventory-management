package com.systelab.inventory.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Supplier extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;
    private String fax;
    @JsonProperty("company")
    private String companyID;
    private boolean active;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SupplierContactPerson> contactPersonList = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private DocumentFormat orderDocumentFormat;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private DocumentFormat orderStatusDocumentFormat;

}
