package com.Kafka.PubSub.Models;

import com.Kafka.PubSub.Enums.ItemTypes;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Items")
public class Items {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ITEMNAME")
    private String itemName;

    @Column(name = "ITEMDESCRIPTION")
    private String itemDescription;

    @Column(name = "ITEMTYPE")
    private ItemTypes itemType;

    @Column(name = "ITEMPRICE")
    private Double itemPrice;

//    public Items(String itemName, String itemDescription, ItemTypes itemType, Double itemPrice) {
//        this.itemName = itemName;
//        this.itemDescription = itemDescription;
//        this.itemType = itemType;
//        this.itemPrice = itemPrice;
//    }
}
