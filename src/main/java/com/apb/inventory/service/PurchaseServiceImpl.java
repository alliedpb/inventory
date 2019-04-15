package com.apb.inventory.service;

import com.apb.inventory.configuration.Config;
import com.apb.inventory.model.Product;
import com.apb.inventory.model.Purchase;
import com.apb.inventory.model.Supplier;
import com.apb.inventory.repository.ProductRepository;
import com.apb.inventory.repository.PurchaseRepository;
import com.apb.inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service("inventoryPurchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    private Config config;

    @Override
    @Transactional
    public Long addPurchase(final LocalDate purchaseDate, final Long productId, final Long supplierId, final Long purchaseQty) {

        Product product = productRepository.findById(productId).get();
        Supplier supplier = supplierRepository.findById(supplierId).get();


        Long currentInventory = product.getInventoryReceived() == null ? 0 : product.getInventoryReceived();
        product.setInventoryReceived(currentInventory + purchaseQty);

        Purchase purchase = new Purchase();

        purchase.setPurchaseQuantity(purchaseQty);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setSupplierId(supplier.getId());
        purchase.setProductId(product.getId());
        purchase.setDeletedFlag("N");
        purchase.setCreatedDate(LocalDateTime.now());
        purchase.setModifiedDate(product.getCreatedDate());
        purchase.setModifiedBy(config.getCurrentUser());

        return purchaseRepository.save(purchase).getId();

    }

    @Override
    public Long editPurchase(final Long id, final LocalDate purchaseDate, final Long productId, final Long supplierId, final Long purchaseQty) {

        Purchase purchase = purchaseRepository.findById(id).get();
        purchase.setPurchaseDate(purchaseDate);
        purchase.setProductId(productId);
        purchase.setSupplierId(supplierId);
        purchase.setPurchaseQuantity(purchaseQty);

        return purchaseRepository.save(purchase).getId();

    }

    @Override
    public void deletePurchase(final Long id) {

    }

    @Override
    public List<Purchase> getPurchases(final LocalDate purchaseDate, Long supplierId, Long productId) {
        return purchaseRepository.getPurchases(purchaseDate, supplierId, productId);
    }
}

