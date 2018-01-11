package com.service.passwordservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * @author Gopinadh
 *
 */
@SpringBootApplication
public class PasswordServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(PasswordServiceApplication.class);

	/**
	 * SPring Boot application entry point
	 * @param args - -Dspring.profiles.active=dev, -Dspring.profiles.active=prod
	 */
	public static void main(String[] args) {
		SpringApplication.run(PasswordServiceApplication.class, args);
		logger.debug("--Application Started--");
	}


}
