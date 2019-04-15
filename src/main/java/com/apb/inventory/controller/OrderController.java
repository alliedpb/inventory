package com.apb.inventory.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apb.inventory.model.Order;
import com.apb.inventory.repository.OrderRepository;
import com.apb.inventory.service.OrderService;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;
    
    @RequestMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") final Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @RequestMapping("/order/all")
    public List<Order> getAllOrders() {
    	LocalDate todayDate = LocalDate.now();
        return orderService.getOrders(todayDate);
    }

    @RequestMapping("/order/add/{orderNumber}/{orderDate}/{customerName}/{productId}/{orderQty}")
    public Long addOrder(@PathVariable final String orderNumber,
                         @PathVariable final LocalDate orderDate,
                         @PathVariable final String customerName,
                         @PathVariable final Long productId,
                         @PathVariable final Long orderQty) {

        return orderService.addOrder(orderNumber, orderDate, customerName, productId, orderQty);
    }
    
    @RequestMapping("/order/edit/{id}/{orderNumber}/{orderDate}/{customerName}/{productId}/{orderQty}")
    public Long editProduct(@PathVariable final Long id,
    		                @PathVariable final String orderNumber,
                            @PathVariable final LocalDate orderDate,
                            @PathVariable final String customerName,
                            @PathVariable final Long productId,
                            @PathVariable final Long orderQty) {

    	return orderService.editOrder(id, orderNumber, orderDate, customerName, productId, orderQty);
    }    
    
    @RequestMapping("/order/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
    }    
}
