package com.apb.inventory.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Empty Or Invalid Category")
public class InvalidCategory extends RuntimeException {
}
