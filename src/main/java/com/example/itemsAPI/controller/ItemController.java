package com.example.itemsAPI.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import com.example.itemsAPI.controller.dto.ItemDto;
import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.repository.entity.ItemRepository;
import com.example.itemsAPI.service.ItemService;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    //For HATEOAS
    private final ItemModelAssembler assembler;


    public ItemController(ItemRepository itemRepository, ItemService itemService, ItemModelAssembler assembler )
    {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
        this.assembler = assembler;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Item> all(){

        return itemService.all();

//HATEOAS Format
//        List<EntityModel<Item>> items = itemService.all().stream()
//                .map(assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(items, linkTo(methodOn(ItemController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public Item one( @PathVariable Long id ){
       return itemService.findById(id);

    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> save( @RequestBody ItemDto itemDto )
    {
        EntityModel<Item> entityModel = assembler.toModel(itemService.save(new Item(itemDto)));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    //Delete an item by id
    @DeleteMapping( "/{id}" )
    public ResponseEntity<?> delete(@PathVariable Long id )
    {
        itemService.delete( id );
        return ResponseEntity.noContent().build();
    }

    //Update item information
    @PutMapping( "/{id}" )
    public ResponseEntity<?> update( @RequestBody ItemDto itemDto, @PathVariable Long id )
    {

        Item newItem = new Item(itemDto);

        Item updatedItem = itemRepository.findById(id)
                .map(item -> {
                    item.setId(id);
                    item.setItemName(newItem.getItemName());
                    item.setProductUrl(newItem.getProductUrl());
                    item.setDescription(newItem.getDescription());
                    return itemService.save(item);
                }).orElseGet(() -> {
                    newItem.setId(id);
                    return itemRepository.save(newItem);
                });

        EntityModel<Item> entityModel = assembler.toModel(updatedItem);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

}

