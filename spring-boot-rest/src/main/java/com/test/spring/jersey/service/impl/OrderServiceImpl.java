package com.test.spring.jersey.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.test.spring.jersey.contracts.Order;
import com.test.spring.jersey.contracts.Product;
import com.test.spring.jersey.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private static Map<Integer, Order> ordersMap = new HashMap<>();

	private static AtomicInteger orderIdGenerator = new AtomicInteger(1);

	@Override
	public Response create(Order order) {
		int generatedId = orderIdGenerator.getAndIncrement();
		order.setId(generatedId);
		ordersMap.put(order.getId(), order);
		return Response.status(Status.CREATED).entity(order).build();
	}

	@Override
	public Response getOrders() {
		List<Order> orders = new ArrayList<>(ordersMap.values());
		return Response.status(Status.OK).entity(orders).build();
	}

	@Override
	public Response update(Order order) {
		Order existingOrder = ordersMap.get(order.getId());
		Product newProduct = order.getProduct();
		if (Objects.nonNull(existingOrder) && Objects.nonNull(existingOrder.getProduct())
				&& Objects.nonNull(newProduct)) {
			existingOrder.setProduct(newProduct);
		}
		return Response.status(Status.CREATED).entity(existingOrder).build();
	}

	@Override
	public Response getById(int orderId) {
		Order existingOrder = ordersMap.get(orderId);
		if (Objects.isNull(existingOrder)) {
			existingOrder = new Order();
		}
		return Response.status(Status.OK).entity(existingOrder).build();
	}

	@Override
	public Response delete(int orderId) {
		ordersMap.remove(orderId);
		return Response.status(Status.OK).build();
	}

}
