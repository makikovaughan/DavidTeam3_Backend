package com.example.itemsAPI.repository.entity;

import com.example.itemsAPI.controller.dto.ItemDto;
import jakarta.persistence.*;

@Entity
public class Item {

    //Instance field
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    private Long id;

    private String description;
    private String itemName;
    private String productUrl;


    //Constructor
    public Item() {
    }

    public Item(Long id, String itemName, String description, String productUrl) {

        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.productUrl = productUrl;
    }

    public Item(ItemDto itemDto) {
        this.itemName = itemDto.getItemName();
        this.productUrl = itemDto.getProductUrl();
        this.description = itemDto.getDescription();
    }

    //Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //toString

}
