package com.example.itemsAPI.service;

public class ItemNotFoundException extends RuntimeException {

    ItemNotFoundException(Long id) {
        super("Could not find item " + id);
    }
}
