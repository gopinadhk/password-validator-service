package com.service.passwordservice.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 
 * @author Gopinadh
 *
 */
public class PasswordLowercaseRule extends PasswordRule {

	private Pattern checkCasePattern = Pattern.compile("[A-Z]");

	public PasswordLowercaseRule() {
	}

	public boolean check(String password) {
		Matcher matcher = checkCasePattern.matcher(password);
		return matcher.find();
	}

	public String getError() {
		return ERROR_PASSWORD_CASE;
	}

}
