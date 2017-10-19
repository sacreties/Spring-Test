package com.test.spring.jersey.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.test.spring.jersey"})
public class Main extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new Main().configure(new SpringApplicationBuilder(Main.class)).run(args);
	}
}
