package com.service.passwordservice.rule;



/**
 * 
 * @author Gopinadh
 *
 */
public interface IPasswordRule {

	String ERROR_PASSWORD_LENGTH = "Password must be between 5 and 12 characters in length.";
	String ERROR_PASSWORD_CASE = "Password must only contain lowercase letters.";
	String ERROR_LETTER_AND_DIGIT = "Password must contain both a letter and a digit.";
	String ERROR_PASSWORD_SEQUENCE_REPEATED = "Password must not contain any sequence of characters immediately followed by the same sequence.";
	String EMPTY_PASSWORD = "Password Should not be empty.";
	String NO_ERRORS = "NO ERRORS FOUND.";

	String getError();
}
