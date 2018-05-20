package com.systelab.stock.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseEntity {

    public static final String MODE_ONE_LABEL_PER_ENTRY = "E";
    public static final String MODE_ONE_LABEL_PER_PURCHASE_UNIT = "P";
    public static final String MODE_ONE_LABEL_PER_CONSUMPTION_UNIT = "C";


    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String reportDescription;

    @Size(max = 16)
    private String code;

    @Size(max = 16)
    private String supplierProductCode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private Warehouse warehouse;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private Section section;

    @Enumerated(EnumType.STRING)
    private LabelPrintingMode labelPrintingMode;

    private Integer minimumExpiry;
    private Integer consumptionPurchaseRatio;
    private Integer minStock;
    private Integer maxStock;
    private Integer orderPoint;
    private Integer fillingPoint;
    private String preservation;
    private String purchaseUnits;
    private String consumptionUnits;
    private String defaultLocation;

    private Integer testsProductRatio;
    private boolean active;
    private Double pricePerUnit;
    private Double vatPercentage;
    private String comments;
    private String productBarcode;
    private String productHostCode;
    private String productMask;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    private ProductGroup productGroup;

    private Integer totalRemainingUnits;
    private Double totalCost;
    private String productField1;
    private String productField2;
    private String productField3;
    private String productField4;
    private Integer totalRemainingUnitsExpired;
    private Integer totalRemainingUnitsInQuarantine;
    private String quarantineControl;
    private boolean mandatoryExpiry;
    private Integer minDaysToExpire;
}
