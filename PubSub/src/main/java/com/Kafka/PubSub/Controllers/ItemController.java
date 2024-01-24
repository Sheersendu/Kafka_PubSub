package com.Kafka.PubSub.Controllers;

import com.Kafka.PubSub.Models.Item;
import com.Kafka.PubSub.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Item> getItems() {
        return this.itemRepository.getAllItems();
    }

    @PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveItems(@RequestBody Item item) {
        try {
            this.itemRepository.insertItems(item);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item has been successfully inserted");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
