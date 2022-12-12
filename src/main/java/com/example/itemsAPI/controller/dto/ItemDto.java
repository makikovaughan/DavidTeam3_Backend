package com.example.itemsAPI.controller.dto;

public class ItemDto {

    //Instances
    private String description;
    private String itemName;
    private String productUrl;

    //Constructor
    public ItemDto(Double price, String itemName, String description, String productUrl) {
        this.itemName = itemName;
        this.description = description;
        this.productUrl = productUrl;
    }

    //getter and setter

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getDescription() {
        return this.description;
    }
}

