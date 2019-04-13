package com.apb.inventory.repository;

import com.apb.inventory.model.InventoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("inventoryUserRepository")
public interface UserRepository extends JpaRepository<InventoryUser, Long> {

    @Query("SELECT a FROM InventoryUser a WHERE a.username = :username")
    public InventoryUser findByUserName(@Param("username") String username);

}
