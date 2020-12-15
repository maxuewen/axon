package com.example.axon.event;

import lombok.Data;

@Data
public class OrderShippedEvent {

    private final String orderId; 

    // default constructor, getters, equals/hashCode and toString 
}