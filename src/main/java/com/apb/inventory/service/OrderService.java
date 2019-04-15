package com.apb.inventory.service;

import java.time.LocalDate;
import java.util.List;

import com.apb.inventory.model.Order;

public interface OrderService {

    Long addOrder(final String orderNumber, 
    		     final LocalDate orderDate,
    		     final String customerName,
    		     final Long productId,  
    		     final Long orderQty);
    Long editOrder(final Long id, 
		         final String orderNumber,
    		     final LocalDate orderDate,
		         final String customerName,
		         final Long productId,  
		         final Long orderQty);
    void deleteOrder(final Long id);
    List<Order> getOrders(final LocalDate orderDate);
}
