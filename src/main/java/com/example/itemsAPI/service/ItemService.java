package com.example.itemsAPI.service;

import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.repository.entity.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }


    public Item save(Item item)
    {
        //TODO implement this method
        Item newItem = this.itemRepository.save(item);
        return newItem;
    }


    public void delete( Long itemId )
    {
        //TODO implement this method
        this.itemRepository.deleteById(itemId);
    }


    public List<Item> all()
    {
        //TODO implement this method
        return itemRepository.findAll();
    }


    public Item findById( Long itemId )
    {
        //TODO implement this method
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
        return item;
    }
}
