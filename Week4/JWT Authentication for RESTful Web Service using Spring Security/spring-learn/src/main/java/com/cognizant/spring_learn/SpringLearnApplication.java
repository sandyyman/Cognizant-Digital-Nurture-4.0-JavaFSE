package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Starting application...");
		SpringApplication.run(SpringLearnApplication.class, args);

		displayCountry();

		LOGGER.info("Application started.");
	}

	public static void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		com.cognizant.spring_learn.Country country = context.getBean("country", com.cognizant.spring_learn.Country.class);

		LOGGER.debug("Country : {}", country.toString());

		LOGGER.info("END");
	}
}
