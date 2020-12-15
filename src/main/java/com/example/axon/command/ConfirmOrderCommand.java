package com.example.axon.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ConfirmOrderCommand {
 
    @TargetAggregateIdentifier
    private final String orderId;
    
    // constructor, getters, equals/hashCode and toString
}