package com.apb.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@XmlRootElement
@Table(name="product_tbl", schema="sa")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String productNumber;
    private String productName;
    private String productDesc;
    private Long categoryId;
    private Long minInventory;
    private Long maxInventory;
    private Long startingInventory;
    private Long inventoryReceived;
    private Long inventorySold;
    private Long inventoryOnHand;

    private Category category;
    private String deletedFlag;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String modifiedBy;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="product_number")
    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    @Column(name="product_desc")
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Column(name="product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Column(name="category_id")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name="min_inv")
    public Long getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(Long minInventory) {
        this.minInventory = minInventory;
    }

    @Column(name="max_inv")
    public Long getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Long minimumRequired) {
        this.maxInventory = maxInventory;
    }

    @Column(name="start_inv")
    public Long getStartingInventory() {
        return startingInventory;
    }

    public void setStartingInventory(Long startingInventory) {
        this.startingInventory = startingInventory;
    }


    @Column(name="received_inv")
    public Long getInventoryReceived() {
        return inventoryReceived;
    }

    public void setInventoryReceived(Long inventoryReceived) {
        this.inventoryReceived = inventoryReceived;
    }

    @Column(name="sold_inv")
    public Long getInventorySold() {
        return inventorySold;
    }

    public void setInventorySold(Long inventorySold) {
        this.inventorySold = inventorySold;
    }


    @Column(name="onhand_inv")
    public Long getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(Long inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }


    @Column(name="deleted_flag")
    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    @Column(name="created_datetime")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="modified_datetime")
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name="modified_by")
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id",insertable = false, updatable = false)
    @JsonIgnore
    public Category getCategory() { return this.category; }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Transient
    public String getProductLabel() { return  (category != null) ? this.category.getCategoryName() : null; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(productNumber, product.productNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(productName)
                .toHashCode();
    }
}
