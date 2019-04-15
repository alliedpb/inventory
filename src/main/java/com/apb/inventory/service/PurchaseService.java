package com.apb.inventory.service;

import com.apb.inventory.model.Purchase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseService {

    Long addPurchase(final LocalDate purchaseDate, final Long productId, final Long supplierId, final Long purchaseQty);
    Long editPurchase(final Long id, final LocalDate purchaseDate, final Long productId, final Long supplierId, final Long purchaseQty);
    void deletePurchase(final Long id);
    List<Purchase> getPurchases(final LocalDate purchaseDate, Long productId, Long supplierId);



}
