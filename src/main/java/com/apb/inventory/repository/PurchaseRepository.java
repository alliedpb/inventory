package com.apb.inventory.repository;

import com.apb.inventory.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("inventoryPurchaseRepository")
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query( "SELECT pur FROM Purchase pur " +
            "LEFT JOIN FETCH pur.product " +
            "LEFT JOIN pur.supplier " +
            "WHERE  pur.deletedFlag = 'N' " +
            "AND   (pur.purchaseDate = :purchaseDate OR :purchaseDate IS NULL) " +
            "AND   (pur.supplierId = :supplierId OR :supplierId IS NULL) " +
            "AND   (pur.productId = :productId OR :productId IS NULL) " +
            "ORDER BY pur.purchaseDate ")
    public List<Purchase> getPurchases(@Param("purchaseDate") LocalDate purchaseDate, @Param("supplierId") Long supplierId, @Param("productId") Long productId);


}

