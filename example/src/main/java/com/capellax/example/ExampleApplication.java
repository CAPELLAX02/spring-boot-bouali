package com.capellax.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(ExampleApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
		var ctx = app.run(args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);

		System.out.println(myFirstService.getMyCustomProperty());
		System.out.println(myFirstService.getMyCustomInteger());
		System.out.println(myFirstService.tellAStory());
	}

}
