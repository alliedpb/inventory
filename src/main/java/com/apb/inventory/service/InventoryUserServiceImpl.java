package com.apb.inventory.service;

import com.apb.inventory.configuration.Config;
import com.apb.inventory.model.InventoryUser;
import com.apb.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service("inventoryUserService")
public class InventoryUserServiceImpl implements InventoryUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Config config;

    @Override
    public Long addUser(String username, String password) {

        InventoryUser user = new InventoryUser();

        user.setUsername(username);
        user.setPassword(config.passwordEncoder().encode(password));
        user.setDeletedFlag("N");
        user.setCreatedDate(LocalDate.now());
        user.setModifiedDate(user.getCreatedDate());
        user.setModifiedBy(config.getCurrentUser());

        return userRepository.save(user).getId();

    }

    @Override
    public Long editUser(Long id, String username, String password) {

        InventoryUser user = userRepository.findById(id).get();

        user.setUsername(username);
        user.setPassword(config.passwordEncoder().encode(password));
        user.setModifiedBy(config.getCurrentUser());
        user.setModifiedDate(LocalDate.now());
        return userRepository.save(user).getId();

    }

    @Override
    public void deleteUser(Long id) {

        InventoryUser user = userRepository.findById(id).get();
        user.setDeletedFlag("Y");
        user.setModifiedBy(config.getCurrentUser());
        user.setModifiedDate(LocalDate.now());


    }

    @Override
    public List<InventoryUser> getAllUser() {
        return null;
    }
}
