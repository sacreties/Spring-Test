package com.test.spring.jersey.application;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.test.spring.jersey.service.impl.OrderServiceImpl;

@Component
public class JerseyApplication extends ResourceConfig{

	public JerseyApplication() {
		register(OrderServiceImpl.class);
	}
}
