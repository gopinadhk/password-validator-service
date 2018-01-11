package com.service.passwordservice.rule;



/**
 * 
 * @author Gopinadh
 *
 */
public abstract class PasswordRule implements IPasswordRule {

	private String error;

	abstract public boolean check(String password);

	public String getError() {
		return error;
	}
}
