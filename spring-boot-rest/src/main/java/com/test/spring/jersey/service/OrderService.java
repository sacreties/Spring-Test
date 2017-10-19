package com.test.spring.jersey.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.test.spring.jersey.contracts.Order;

@Path("order")
public interface OrderService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Order order);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrders();
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Order order);
	
	@GET
	@Path("{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("orderId") int orderId);
	
	@DELETE
	@Path("{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("orderId") int orderId);
}
