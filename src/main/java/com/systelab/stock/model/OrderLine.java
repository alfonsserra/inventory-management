package com.systelab.stock.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Integer requestedQuantity;
    private Integer receivedQuantity;
    private Integer pendingQuantity;  // attribute used in automatic order generation. Describes the quantity of product requested in other orders and not yet received.

    private Double price;
    private String internalComments;
    private String externalComments;
    private String lotNumber;
    private Date estimatedArrivalTime;
    private Date arrivalTime;
    private String orderDescription;

}
