package com.example.axon.aggregate;

import com.example.axon.command.PlaceOrderCommand;
import com.example.axon.command.ShipOrderCommand;
import com.example.axon.event.OrderConfirmedEvent;
import com.example.axon.event.OrderPlacedEvent;
import com.example.axon.event.OrderShippedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;


public class OrderAggregateTest {

	private FixtureConfiguration<OrderAggregate> fixture;

	@Before
	public void setUp() {
		fixture = new AggregateTestFixture<>(OrderAggregate.class);
	}

	@Test
	public void t1() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.givenNoPriorActivity()
						.when(new PlaceOrderCommand(orderId, product))
						.expectEvents(new OrderPlacedEvent(orderId, product));

	}

	@Test
	public void t2() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.given(new OrderPlacedEvent(orderId, product))
						.when(new ShipOrderCommand(orderId))
						.expectException(IllegalStateException.class);

	}

	@Test
	public void t3() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.given(new OrderPlacedEvent(orderId, product), new OrderConfirmedEvent(orderId))
						.when(new ShipOrderCommand(orderId))
						.expectEvents(new OrderShippedEvent(orderId));

	}

}