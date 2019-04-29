package com.apb.inventory.controller;

import com.apb.inventory.service.InventoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private InventoryUserService userService;

    @RequestMapping(value = "/user/add/{username}/{password}", produces = "application/json")
    public Long addUser (@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.addUser(username, password);
    }

    @RequestMapping(value = "/user/edit/{id}/{username}/{password}", produces = "application/json")
    public Long editUser (@PathVariable("id") Long id, @PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.editUser(id, username, password);
    }

    @RequestMapping(value = "/user/delete/{id}", produces = "application/json")
    public void deleteUser (@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
