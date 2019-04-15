package com.apb.inventory.controller;

import com.apb.inventory.model.Purchase;
import com.apb.inventory.repository.PurchaseRepository;
import com.apb.inventory.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @RequestMapping("/purchase/list/{purchaseDate}/{productId}/{supplierId}")
    public List<Purchase> getPurchases(@PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate purchaseDate, @PathVariable Long productId, @PathVariable Long supplierId) {
        return purchaseService.getPurchases(purchaseDate, productId, supplierId);
    }

    @RequestMapping("/purchase/}/{id}")
    public Purchase getPurchases(@PathVariable Long id) {
        return purchaseRepository.findById(id).get();
    }

    @RequestMapping("/purchase/add/{purchaseDate}/{productId}/{supplierId}/{purchaseQty}")
    public Long addPurchase(@PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate purchaseDate, @PathVariable Long productId, @PathVariable Long supplierId, @PathVariable Long purchaseQty ) {
        return purchaseService.addPurchase(purchaseDate,productId, supplierId, purchaseQty);
    }

    @RequestMapping("/purchase/edit/{id}/{purchaseDate}/{productId}/{supplierId}/{purchaseQty}")
    public Long editPurchase(@PathVariable Long id, @PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate purchaseDate, @PathVariable Long productId, @PathVariable Long supplierId, @PathVariable Long purchaseQty ) {
        return purchaseService.editPurchase(id, purchaseDate,productId, supplierId, purchaseQty);
    }

    @RequestMapping("/purchase/delete/{id}/")
    public void deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
    }

}
