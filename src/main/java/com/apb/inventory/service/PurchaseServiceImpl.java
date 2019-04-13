package com.apb.inventory.service;

import com.apb.inventory.model.Product;
import com.apb.inventory.model.Purchase;
import com.apb.inventory.model.Supplier;
import com.apb.inventory.repository.ProductRepository;
import com.apb.inventory.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public Long addPurchase(final LocalDate purchaseDate, final Long productId, final Long supplierId, final Long purchaseQty) {

        Product product = productRepository.findById(productId).get();

        product.setInventoryReceived(product.getInventoryReceived() + purchaseQty);

        Purchase purchase = new Purchase();

        purchase.setPurchaseQuantity(purchaseQty);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setSupplierId(supplierId);
        purchase.setProductId(productId);

        return purchaseRepository.save(purchase).getId();

    }

    @Override
    public Long editPurchase(final Long id, final LocalDateTime purchaseDate, final Long productId, final Long supplierId, final Long purchaseQty) {
        return null;
    }

    @Override
    public void deletePurchase(final Long id) {

    }

    @Override
    public List<Purchase> getPurchases(final LocalDate purchaseDate, Long supplierId, Long productId) {
        return purchaseRepository.getPurchases(purchaseDate, supplierId, productId);
    }
}

