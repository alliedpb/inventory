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
@Table(name="purchase_tbl", schema="sa")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long supplierId;
    private Long productId;
    private LocalDate purchaseDate;
    private Long purchaseQty;
    private Product product;
    private Supplier supplier;
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


    @Column(name="supplier_id")
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Column(name="product_id")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name="purchase_date")
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Column(name="purchase_qty")
    public Long getPurchaseQuantity() {
        return purchaseQty;
    }

    public void setPurchaseQuantity(Long purchaseQty) {
        this.purchaseQty = purchaseQty;
    }

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id",insertable = false, updatable = false)
    @JsonIgnore
    public Product getProduct() { return this.product; }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Transient
    public String getProductNumber() {
        return this.product != null ? this.product.getProductNumber() : null;
    }

    @Transient
    public String getProductName() {
        return this.product != null ? this.product.getProductName() : null;
    }

    @ManyToOne
    @JoinColumn(name="supplier_id", referencedColumnName = "id",insertable = false, updatable = false)
    @JsonIgnore
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Transient
    public String getSupplierName() {
        return this.supplier != null ? this.supplier.getSupplierName() : null;
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
}
