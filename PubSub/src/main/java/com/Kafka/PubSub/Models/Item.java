package com.Kafka.PubSub.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    @JsonIgnore
    private Long id;

    private String itemName;

    private String itemDescription;

    private String itemType;

    private Double itemPrice;
}
