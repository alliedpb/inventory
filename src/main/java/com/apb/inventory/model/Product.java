package com.apb.inventory.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@Entity
@XmlRootElement
@Table(name="Product", schema="sa")
public class Product {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String productName;
    private String productDesc;
    private String partNumber;
    private String productLabel;
    private BigInteger startingInventory;
    private BigInteger inventoryReceived;
    private BigInteger inventorySold;
    private BigInteger inventoryOnHand;
    private BigInteger minimumRequired;

    @Id
    @Column(name="id")
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

    @Column(name="productlabel")
    public String getProductLabel() {
        return productLabel;
    }

    public void setProductLabel(String productLabel) {
        this.productLabel = productLabel;
    }

    @Column(name="startinginventory")
    public BigInteger getStartingInventory() {
        return startingInventory;
    }

    public void setStartingInventory(BigInteger startingInventory) {
        this.startingInventory = startingInventory;
    }

    @Column(name="inventoryreceived")
    public BigInteger getInventoryReceived() {
        return inventoryReceived;
    }

    public void setInventoryReceived(BigInteger inventoryReceived) {
        this.inventoryReceived = inventoryReceived;
    }

    @Column(name="inventorysold")
    public BigInteger getInventorySold() {
        return inventorySold;
    }

    public void setInventorySold(BigInteger inventorySold) {
        this.inventorySold = inventorySold;
    }

    @Column(name="inventoryonhand")
    public BigInteger getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(BigInteger inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }

    @Column(name="minimumrequired")
    public BigInteger getMinimumRequired() {
        return minimumRequired;
    }

    public void setMinimumRequired(BigInteger minimumRequired) {
        this.minimumRequired = minimumRequired;
    }

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
