package com.service.passqword.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.passwordservice.rule.PasswordValidatorService;


/**
 * 
 * @author Gopinadh
 *
 */
@Configuration
public class AppConfig {

	public @Bean
	PasswordValidatorService passwordValidatorService() {
		return new PasswordValidatorService();
	}


}