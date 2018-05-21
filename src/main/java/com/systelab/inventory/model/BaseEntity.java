package com.systelab.inventory.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    //   @CreatedBy
    //   private User createBy;

    @CreatedDate
    @ApiModelProperty(value = "Creation DateTime", readOnly = true)
    private Date createdAt;

    @LastModifiedDate
    @ApiModelProperty(value = "Last Modification DateTime", readOnly = true)
    private Date lastModified;

}