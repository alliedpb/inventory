package com.apb.inventory.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.apb.inventory.model.Order;
import com.apb.inventory.model.Product;
import com.apb.inventory.repository.OrderRepository;
import com.apb.inventory.repository.ProductRepository;

public class OrderServiceImpl implements OrderService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;

    @Override
    @Transactional
	public Long addOrder(String orderNumber, 
			             LocalDate orderDate, 
			             String customerName, 
			             Long productId, 
			             Long orderQty) {
		
        Product product = productRepository.findById(productId).get();
        product.setInventorySold(product.getInventorySold() + orderQty);
        product.setInventoryOnHand( product.getInventoryOnHand() - orderQty );
        
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setOrderDate(orderDate);
        order.setCustomerName(customerName);
        order.setProductId(productId);
        order.setOrderQty(orderQty);
        
    	return orderRepository.save(order).getId();
	}

	@Override
	@Transactional
	public Long editOrder(Long id, 
			              String orderNumber, 
			              LocalDate orderDate, 
			              String customerName, 
			              Long productId,
			              Long orderQty) {

        Order orderFromDB = orderRepository.findById(id).get();
        orderFromDB.setOrderNumber(orderNumber);
        orderFromDB.setOrderDate(orderDate);
        orderFromDB.setCustomerName(customerName);
        orderFromDB.setProductId(productId);
        orderFromDB.setOrderQty(orderQty);	
		
		long orderQtyDiff = 0;
		if ( !orderFromDB.getOrderQty().equals(orderQty) )
			orderQtyDiff = (-1 * (orderFromDB.getOrderQty() - orderQty));	
		
		//Calculate & update inventory on-hand.
		Product product = productRepository.findById(productId).get();
		product.setInventorySold(product.getInventorySold() + orderQtyDiff );
		product.setInventoryOnHand( product.getInventoryOnHand() - orderQtyDiff );
		productRepository.save(product);		
		
		return orderRepository.save(orderFromDB).getId();
	}

	@Override
	@Transactional
	public void deleteOrder(Long id) {
		Order order = orderRepository.findById(id).get();
		orderRepository.delete(order);
		
		//Calculate & update inventory on-hand.
		Product product = productRepository.findById(order.getProductId()).get();
		product.setInventorySold(product.getInventorySold() - order.getOrderQty() );
		product.setInventoryOnHand( product.getInventoryOnHand() - order.getOrderQty() );
		productRepository.save(product);
	}

	@Override
	public List<Order> getOrders(LocalDate orderDate) {
		return orderRepository.getOrders(orderDate);
	}

}
