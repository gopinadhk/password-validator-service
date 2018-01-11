package com.service.passwordservice.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 
 * @author Gopinadh
 *
 */
public class PasswordAllowedCharactersRule extends PasswordRule {
	private Pattern checkLetterAndDigit = Pattern
			.compile("[a-z]+\\d+|\\d+[a-z]+");

	public PasswordAllowedCharactersRule() {
	}

	public boolean check(String password) {

		Matcher matcher = checkLetterAndDigit.matcher(password);
		return !matcher.find();
	}

	public String getError() {
		return ERROR_LETTER_AND_DIGIT;
	}

}
