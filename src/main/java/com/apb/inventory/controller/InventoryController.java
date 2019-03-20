package com.apb.inventory.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @RequestMapping("/test/{name}")
    public String getUnsecuredEndPoint(@PathVariable final String name) {
        return String.format("You entered :%s", name);
    }
}
