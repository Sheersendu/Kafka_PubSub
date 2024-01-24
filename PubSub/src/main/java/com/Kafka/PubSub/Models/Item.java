package com.Kafka.PubSub.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Item")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ITEMNAME")
    private String itemName;

    @Column(name = "ITEMDESCRIPTION")
    private String itemDescription;

    @Column(name = "ITEMTYPE")
    private String itemType;

    @Column(name = "ITEMPRICE")
    private Double itemPrice;
}
