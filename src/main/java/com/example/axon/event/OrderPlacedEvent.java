package com.example.axon.event;

import lombok.Data;

@Data
public class OrderPlacedEvent {
 
    private final String orderId;
    private final String product;
 
    // default constructor, getters, equals/hashCode and toString
}