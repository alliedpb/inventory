package com.apb.inventory.service;

import com.apb.inventory.model.InventoryUser;
import com.apb.inventory.model.Product;

import java.util.List;

public interface InventoryUserService {

    Long addUser(final String username, final String password);
    Long editUser(final Long id, final String username, final String password);
    void deleteUser(final Long id);
    List<InventoryUser> getAllUser();
}
