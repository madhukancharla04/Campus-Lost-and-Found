package com.lostfound.service;

import com.lostfound.model.Item;
import com.lostfound.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item saveItem(Item item) {
        return repository.save(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Optional<Item> getItem(Long id) {
        return repository.findById(id);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public Item getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

}