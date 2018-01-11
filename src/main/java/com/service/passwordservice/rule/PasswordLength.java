package com.service.passwordservice.rule;



/**
 * 
 * @author Gopinadh
 *
 */
public class PasswordLength extends PasswordRule {

	public PasswordLength() {
	}

	public boolean check(String p) {
		if (p.length() < 5 || p.length() > 12) {
			return true;
		}
		return false;
	}

	public String getError() {
		return ERROR_PASSWORD_LENGTH;
	}

}
