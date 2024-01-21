package com.Kafka.PubSub.Controllers;

import com.Kafka.PubSub.Models.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ItemController {
    @Autowired private JdbcTemplate jdbcTemplate;
    @RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Items> getItems() {
        return (ArrayList<Items>) jdbcTemplate.query("SELECT * FROM ITEMS;", new BeanPropertyRowMapper<>(Items.class));
    }

    @PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setItems(Items item) {
        String query = "INSERT INTO Items (ITEMNAME, ITEMDESCRIPTION, ITEMTYPE, ITEMPRICE) VALUES ('" + item.getItemName() + "', '" + item.getItemDescription() + "', " + "'FOOTWEAR', " + 1000 +");";
        jdbcTemplate.update(query);
    }
}
