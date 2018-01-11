package com.service.passwordservice.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.passwordservice.rest.data.ServiceResponse;
import com.service.passwordservice.rule.PasswordAllowedCharactersRule;
import com.service.passwordservice.rule.PasswordLength;
import com.service.passwordservice.rule.PasswordLowercaseRule;
import com.service.passwordservice.rule.PasswordNotEmptyRule;
import com.service.passwordservice.rule.PasswordRule;
import com.service.passwordservice.rule.PasswordSequenceRepetitionRule;
import com.service.passwordservice.rule.PasswordValidatorService;
import com.service.passwordservice.util.PasswordRuleProperties;

/**
 * 
 * @author Gopinadh
 *
 */

@RestController
@RequestMapping("/passwordService")
public class PasswordRestController {
	private static final Logger logger = LoggerFactory.getLogger(PasswordRestController.class);

	@Autowired
	PasswordRuleProperties passwordRuleProperties;

	@Autowired
	PasswordValidatorService passwordValidatorService;

	@GetMapping(value = "/{password}")
	public List<String> validateGet(@PathVariable final String password) {

		List<String> errors = passwordValidatorService.validate(password);
		return errors;
	}

	@Deprecated
	@PostMapping(value = "/validatePasswordError")
	public List<String> validatePasswordError(@RequestBody final String password) {
		List<String> errors = passwordValidatorService.validate(password);
		return errors;

	}

	@PostMapping(value = "/validatePassword")
	public ServiceResponse<Map<Object, Object>> validatePassword(@RequestBody String password) {

		ServiceResponse<Map<Object, Object>> serviceResponse = constructResponse();
		// List<String> errors = passwordValidatorService.validate(password);

		List<String> errors = passwordValidatorService.validate(password,
				getPasswordValidatorRules(passwordRuleProperties));
		serviceResponse.getPayload().put("data", errors);
		serviceResponse.getPayload().put("systime", System.currentTimeMillis());

		return serviceResponse;
	}

	private ServiceResponse<Map<Object, Object>> constructResponse() {
		ServiceResponse<Map<Object, Object>> serviceResponse = new ServiceResponse<Map<Object, Object>>();
		serviceResponse.setPayload(new HashMap<Object, Object>());
		serviceResponse.setIn(System.currentTimeMillis());
		return serviceResponse;
	}

	private Set<PasswordRule> getPasswordValidatorRules(PasswordRuleProperties passwordRuleProperties) {
		Set<PasswordRule> rules = null;
		if (passwordRuleProperties != null) {
			rules = new HashSet<PasswordRule>();
			if (passwordRuleProperties.getPasswordLowercaseRule().equals("true"))
				rules.add(new PasswordLowercaseRule());
			if (passwordRuleProperties.getPasswordLengthRule().equals("true"))
				rules.add(new PasswordLength());
			if (passwordRuleProperties.getPasswordNotEmptyRule().equals("true"))
				rules.add(new PasswordNotEmptyRule());
			if (passwordRuleProperties.getPasswordSequenceRepetitionRule().equals("true"))
				rules.add(new PasswordSequenceRepetitionRule());
			if (passwordRuleProperties.getPasswordAllowedCharactersRule().equals("true"))
				rules.add(new PasswordAllowedCharactersRule());
		}
		return rules;
	}

	@PostConstruct
	public void init() {
		logger.info("{Setting PasswordRules} :: " + passwordRuleProperties.toString());
	}

}
