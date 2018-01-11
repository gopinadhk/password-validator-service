package com.service.passwordservice.rule;

import org.springframework.util.StringUtils;



/**
 * 
 * @author Gopinadh
 *
 */
public class PasswordNotEmptyRule extends PasswordRule {

	public PasswordNotEmptyRule() {
	}

	public boolean check(String password) {
		return StringUtils.isEmpty(password);
	}

	public String getError() {
		return EMPTY_PASSWORD;
	}

}
