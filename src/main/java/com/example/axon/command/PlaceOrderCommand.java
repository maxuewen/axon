package com.example.axon.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class PlaceOrderCommand {
 
    @TargetAggregateIdentifier
    private final String orderId;
    private final String product;
 
    // constructor, getters, equals/hashCode and toString 
}