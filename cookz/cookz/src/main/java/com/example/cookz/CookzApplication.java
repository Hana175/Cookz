package com.example.cookz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//we have a tomcat server running, we have a spring application running on top of it.
//MVC model view controller, we have a controller that handles requests, a model that handles data, and a view that handles the UI.
//2 ways to structure code: 
//1. bpackage by layers: MVC app has controller, model, service, config, repo, etc.. 
//2. package by feature: all classes related to a feature are in the same package.
//this project will be built using package by feature.
//dev tools: auto restart server when changes are made, kind of like nodemon for node
//dev tools sets defaults, like in memory h2 database it enables it for us.
@SpringBootApplication
public class CookzApplication {
	private static final Logger log = LoggerFactory.getLogger(CookzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CookzApplication.class, args);
		log.info("Smth changed!");
		// types of loggers.

		// debug, warning, error, etc...
		// log.debug("Debugging log");
		// log.warn("Warning log");
		// log.error("Error log");
		// log.trace("Trace log");
		// log.info("Info log");
	}

	// command line runner: run code when the application starts.
//	 @Bean
//	 //bean annotation creates a bean in application context
//	 //functional interface: an interface which has a single abstract method
//	 CommandLineRunner cook(CookRepository cookRepository) {
//	 return args -> {
//	 Cook cook = new Cook(1, "Pasta", "Italian pasta", "pasta, tomato sauce, cheese", "boil pasta, add sauce, add cheese", "Italian", "pasta.jpg");
//	 log.info("Cook:" + cook);
//	 //cookRepository.create(cook);
//	 };
//	 }

}
