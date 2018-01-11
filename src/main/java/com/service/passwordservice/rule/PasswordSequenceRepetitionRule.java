package com.service.passwordservice.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 
 * @author Gopinadh
 *
 */
public class PasswordSequenceRepetitionRule extends PasswordRule {

	private Pattern checkSequenceRepetition = Pattern.compile("(\\w{2,})\\1");

	public PasswordSequenceRepetitionRule() {
	}

	public boolean check(String password) {
		Matcher matcher = checkSequenceRepetition.matcher(password);
		return matcher.find();
	}

	public String getError() {
		return ERROR_PASSWORD_SEQUENCE_REPEATED;
	}

}
