package com.systelab.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    // TODO: Refactor
    private Long orderLineID;

    private Date realEntryDate;
    private Date expiryDate;
    private String label;
    private Integer labelsToPrint;
    private String location;
    private String invoiceOrDeliveryNote;
    private String comments;
    private Double finalPrice;
    private Integer purchaseUnits;
    private Integer initialConsumUnits;
    private Integer remainingUnits;
    private String lotNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private boolean quarantine;
    private Date quarantineStartDate;
    private Date quarantineEndDate;

    // TODO: Refactor
    public void fillQuarantineLotInfo(Date ts, Item item) {

        if (this.getLotNumber() == null) {
            this.setQuarantine(false);
            this.setQuarantineStartDate(null);
            this.setQuarantineEndDate(null);
        } else {
            if (item == null) {
                this.setQuarantineStartDate(this.quarantine ? this.getCreatedAt() : null);
                this.setQuarantineEndDate(null);
            } else {
                if (this.quarantine) {

                    this.setQuarantineStartDate(findMinimumDate(item.getCreatedAt(), this.getCreatedAt()));
                    this.setQuarantineEndDate(null);
                } else {
                    if (item.getQuarantineStartDate() != null) {
                        this.setQuarantineStartDate(findMinimumDate(item.getCreatedAt(), this.getCreatedAt()));
                        this.setQuarantineEndDate(item.getQuarantineEndDate() != null ? item.getQuarantineEndDate() : ts);
                    } else {
                        this.setQuarantineStartDate(null);
                        this.setQuarantineEndDate(null);
                    }
                }
            }
        }
    }

    private Date findMinimumDate(Date aDate, Date bDate) {
        return aDate.before(bDate) ? aDate : bDate;
    }
}
