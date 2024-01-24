package com.Kafka.PubSub.Repositories;

import com.Kafka.PubSub.Enums.ItemType;
import com.Kafka.PubSub.Models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public class ItemRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<Item> getAllItems() {
        return (ArrayList<Item>) this.jdbcTemplate.query("SELECT * FROM ITEM;", new BeanPropertyRowMapper<>(Item.class));
    }

    public void insertItems(Item item) {
        if (isValidItem(item)) {
            String query = "INSERT INTO Item (ITEMNAME, ITEMDESCRIPTION, ITEMTYPE, ITEMPRICE) VALUES ('" + item.getItemName() + "', '" + item.getItemDescription() + "', '" + item.getItemType() + "', " + item.getItemPrice() +");";
            this.jdbcTemplate.update(query);
        }
    }

    private boolean isValidItem(Item item) {
        String itemName = item.getItemName();
        String itemDescription = item.getItemDescription();
        String itemType = item.getItemType();
        Double itemPrice = item.getItemPrice();

        if (itemName == (null) || itemName.equals(""))
        {
            throw new IllegalArgumentException("Item Name cannot be empty");
        }
        if (itemDescription == (null) || itemDescription.equals(""))
        {
            throw new IllegalArgumentException("Item Description cannot be empty");
        }
        try
        {
            ItemType.valueOf(itemType);
        }
        catch (Exception ex) {
            throw new IllegalArgumentException("Item Type is invalid");
        }
        if (itemPrice == (null) || itemPrice <= 0) {
            throw new IllegalArgumentException("Item Price should be greater than 0");
        }
        return true;
    }
}
