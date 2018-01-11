package com.service.passwordservice.rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Gopinadh
 *
 */
@Service
public class PasswordValidatorService {

	private Set<PasswordRule> rules = new HashSet<PasswordRule>();

	public PasswordValidatorService(PasswordRule... args) {
		for (PasswordRule r : args)
			this.rules.add(r);
	}

	public PasswordValidatorService() {
		this.rules.add(new PasswordLowercaseRule());
		this.rules.add(new PasswordLength());
		this.rules.add(new PasswordNotEmptyRule());
		this.rules.add(new PasswordSequenceRepetitionRule());
		this.rules.add(new PasswordAllowedCharactersRule());
	}

	public void addPolicy(PasswordRule rule) {
		this.rules.add(rule);
	}

	public List<String> validate(String password) {

		return parseErrors(password);
	}

	public List<String> validate(String password, Set<PasswordRule> rules) {
		if (rules != null)
			this.rules = rules;

		return parseErrors(password);
	}

	private List<String> parseErrors(String password) {
		List<String> errors = new ArrayList<String>();
		for (PasswordRule r : this.rules) {
			if (r.check(password))
				errors.add(r.getError());
		}

		if (errors.size() == 0) {
			errors.add(IPasswordRule.NO_ERRORS);
		}
		return errors;
	}
}
