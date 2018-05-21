package com.systelab.inventory.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    private String description;

    @ApiModelProperty(value = "Account Number in this system")
    private String internalAccountNumber;
    @ApiModelProperty(value = "Account Number in an external system")
    private String externalAccountNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String internalComments;
    private String externalComments;
    private Date lastPrintDate;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<OrderLine> stockOrderLineList = new HashSet<OrderLine>();

}
