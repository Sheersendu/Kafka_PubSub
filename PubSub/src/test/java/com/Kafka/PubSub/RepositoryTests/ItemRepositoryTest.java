package com.Kafka.PubSub.RepositoryTests;

import com.Kafka.PubSub.Enums.ItemType;
import com.Kafka.PubSub.Models.Item;
import com.Kafka.PubSub.Repositories.ItemRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ItemRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ItemRepository itemRepository;

    @Before
    public void setUp() {
        String item1 = "INSERT INTO Item (ITEMNAME, ITEMDESCRIPTION, ITEMTYPE, ITEMPRICE) VALUES ('Shirt', 'Blue Cotton Shirt', 'APPAREL', 1019.57);";
        jdbcTemplate.update(item1);
        String item2 = "INSERT INTO Item (ITEMNAME, ITEMDESCRIPTION, ITEMTYPE, ITEMPRICE) VALUES ('Loafers', 'Brown loafers', 'FOOTWEAR', 1486.29);";
        this.jdbcTemplate.update(item2);
    }

    @After
    public void tearDown() {
        jdbcTemplate.update("DELETE FROM Item;");
    }

    @Test
    public void Test_getAllItems_ReturnsCorrectResult() {

        ArrayList<Item> itemList = itemRepository.getAllItems();
        int itemListLength = itemList.size();
        assertEquals(2, itemListLength);

        Item firstItem = itemList.get(0);
        assertEquals("Shirt", firstItem.getItemName());
        assertEquals("Blue Cotton Shirt", firstItem.getItemDescription());
        assertEquals("APPAREL", firstItem.getItemType());
        assertEquals(1019.57, firstItem.getItemPrice());

        Item secondItem = itemList.get(1);
        assertEquals("Loafers", secondItem.getItemName());
        assertEquals("Brown loafers", secondItem.getItemDescription());
        assertEquals("FOOTWEAR", secondItem.getItemType());
        assertEquals(1486.29, secondItem.getItemPrice());
    }

    @Test
    public void Test_insertItems_IsSuccessful() {
        // Sample Item
        Item item = new Item();
        item.setItemName("SweatShirt");
        item.setItemDescription("Red SweatShirt");
        item.setItemType(ItemType.APPAREL.toString());
        item.setItemPrice(1499.00);

        itemRepository.insertItem(item);
        ArrayList<Item> itemList = itemRepository.getAllItems();
        int itemListLength = itemList.size();
        assertEquals(3, itemListLength);
    }

}
