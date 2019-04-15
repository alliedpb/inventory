package com.apb.inventory.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apb.inventory.model.Order;

@Repository("inventoryOrderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query( "SELECT ord FROM Order ord " +
            "WHERE  ord.deletedFlag = 'N' " +
            "AND   (ord.orderDate = :orderDate OR :orderDate IS NULL) " +
            "ORDER BY ord.orderDate ")
    public List<Order> getOrders(@Param("orderDate") LocalDate orderDate);
}
