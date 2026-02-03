package com.lostfound.controller;

import com.lostfound.model.Item;
import com.lostfound.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Item addItem(@RequestParam("type") String type,
                        @RequestParam("itemName") String itemName,
                        @RequestParam("description") String description,
                        @RequestParam("contact") String contact,
                        @RequestParam("image") MultipartFile image) throws IOException {

        Item item = new Item();
        item.setType(type);
        item.setItemName(itemName);
        item.setDescription(description);
        item.setContact(contact);
        item.setImage(image.getBytes());
        return service.saveItem(item);
    }

    @GetMapping
    public List<Item> getItems() {
        return service.getAllItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        Item existing = service.getItemById(id);
        existing.setType(updatedItem.getType());
        existing.setItemName(updatedItem.getItemName());
        existing.setDescription(updatedItem.getDescription());
        existing.setContact(updatedItem.getContact());
        return service.saveItem(existing);
    }


}