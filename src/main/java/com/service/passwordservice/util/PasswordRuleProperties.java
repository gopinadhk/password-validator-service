package com.service.passwordservice.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Gopinadh
 *
 */
@Configuration
@ConfigurationProperties("passwordRule")
public class PasswordRuleProperties {

	private String passwordLowercaseRule;
	private String passwordLengthRule;
	private String passwordNotEmptyRule;
	private String passwordSequenceRepetitionRule;
	private String passwordAllowedCharactersRule;

	public String getPasswordLowercaseRule() {
		return passwordLowercaseRule;
	}

	public void setPasswordLowercaseRule(String passwordLowercaseRule) {
		this.passwordLowercaseRule = passwordLowercaseRule;
	}

	public String getPasswordLengthRule() {
		return passwordLengthRule;
	}

	public void setPasswordLengthRule(String passwordLengthRule) {
		this.passwordLengthRule = passwordLengthRule;
	}

	public String getPasswordNotEmptyRule() {
		return passwordNotEmptyRule;
	}

	public void setPasswordNotEmptyRule(String passwordNotEmptyRule) {
		this.passwordNotEmptyRule = passwordNotEmptyRule;
	}

	public String getPasswordSequenceRepetitionRule() {
		return passwordSequenceRepetitionRule;
	}

	public void setPasswordSequenceRepetitionRule(String passwordSequenceRepetitionRule) {
		this.passwordSequenceRepetitionRule = passwordSequenceRepetitionRule;
	}

	public String getPasswordAllowedCharactersRule() {
		return passwordAllowedCharactersRule;
	}

	public void setPasswordAllowedCharactersRule(String passwordAllowedCharactersRule) {
		this.passwordAllowedCharactersRule = passwordAllowedCharactersRule;
	}

	@Override
	public String toString() {
		return "passwordLowercaseRule: " + this.passwordLowercaseRule + "passwordLengthRule: " + this.passwordLengthRule
				+ "passwordNotEmptyRule: " + this.passwordNotEmptyRule + "passwordSequenceRepetitionRule: "
				+ this.passwordSequenceRepetitionRule + "passwordAllowedCharactersRule: "
				+ this.passwordAllowedCharactersRule + "\n";
	}

}
