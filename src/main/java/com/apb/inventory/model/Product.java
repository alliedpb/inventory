package com.apb.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@XmlRootElement
@Table(name="Product", schema="sa")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String productName;
    private String productDesc;
    private String partNumber;
    private Long categoryId;
    private Long startingInventory;
    private Long inventoryReceived;
    private Long inventorySold;
    private Long inventoryOnHand;
    private Long minimumRequired;
    private Category category;
    private String deletedFlag;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="productname")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name="productdesc")
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Column(name="partnumber")
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    @Column(name="categoryid")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name="startinginventory")
    public Long getStartingInventory() {
        return startingInventory;
    }

    public void setStartingInventory(Long startingInventory) {
        this.startingInventory = startingInventory;
    }

    @Column(name="inventoryreceived")
    public Long getInventoryReceived() {
        return inventoryReceived;
    }

    public void setInventoryReceived(Long inventoryReceived) {
        this.inventoryReceived = inventoryReceived;
    }

    @Column(name="inventorysold")
    public Long getInventorySold() {
        return inventorySold;
    }

    public void setInventorySold(Long inventorySold) {
        this.inventorySold = inventorySold;
    }

    @Column(name="inventoryonhand")
    public Long getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(Long inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }

    @Column(name="minimumrequired")
    public Long getMinimumRequired() {
        return minimumRequired;
    }

    public void setMinimumRequired(Long minimumRequired) {
        this.minimumRequired = minimumRequired;
    }

    @Column(name="deletedflag")
    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    @ManyToOne
    @JoinColumn(name="categoryid", referencedColumnName = "id",insertable = false, updatable = false)
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
                .append(partNumber, product.partNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(productName)
                .toHashCode();
    }
}
