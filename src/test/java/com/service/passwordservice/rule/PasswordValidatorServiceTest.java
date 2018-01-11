package com.service.passwordservice.rule;

import static com.service.passwordservice.rule.IPasswordRule.ERROR_LETTER_AND_DIGIT;
import static com.service.passwordservice.rule.IPasswordRule.ERROR_PASSWORD_CASE;
import static com.service.passwordservice.rule.IPasswordRule.ERROR_PASSWORD_LENGTH;
import static com.service.passwordservice.rule.IPasswordRule.ERROR_PASSWORD_SEQUENCE_REPEATED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.service.passqword.config.AppConfig;


public class PasswordValidatorServiceTest {
	private PasswordValidatorService passwordValidatorService;

	@Before
	public void getServiceFromIOC() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);
		passwordValidatorService = ctx.getBean(PasswordValidatorService.class);
	}

	@Test
	public void testContainsOnlyLowercaseLetters() {
		// act
		List<String> result = passwordValidatorService.validate("abcde");

		// verify
		assertFalse(result.contains(ERROR_PASSWORD_CASE));
	}

	@Test
	public void testContainsUppercaseLetters() {
		// act
		List<String> result = passwordValidatorService.validate("Abcde");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_CASE));
	}

	@Test
	public void testContainsBothLetterAndDigit() {
		// act
		List<String> result = passwordValidatorService.validate("a0");

		// verify
		assertFalse(result.contains(ERROR_LETTER_AND_DIGIT));
	}

	@Test
	public void testContainsBothDigitAndLetter() {
		// act
		List<String> result = passwordValidatorService.validate("0a");

		// verify
		assertFalse(result.contains(ERROR_LETTER_AND_DIGIT));
	}

	@Test
	public void testContainsOnlyLetters() {
		// act
		List<String> result = passwordValidatorService.validate("a");

		// verify
		assertThat(result, hasItem(ERROR_LETTER_AND_DIGIT));
	}

	@Test
	public void testContainsOnlyDigits() {
		// act
		List<String> result = passwordValidatorService.validate("0");

		// verify
		assertThat(result, hasItem(ERROR_LETTER_AND_DIGIT));
	}

	@Test
	public void testSize5orMore() {

		// act
		List<String> result = passwordValidatorService.validate("12345");

		// verify
		assertFalse(result.contains(ERROR_PASSWORD_LENGTH));
	}

	@Test
	public void testSizeLessThan5() {

		// act
		List<String> result = passwordValidatorService.validate("1234");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_LENGTH));
	}

	@Test
	public void testSize12orLess() {

		// act
		List<String> result = passwordValidatorService.validate("123456789112");

		// verify
		assertFalse(result.contains(ERROR_PASSWORD_LENGTH));
	}

	@Test
	public void testSizeMoreThan12() {

		// act
		List<String> result = passwordValidatorService.validate("1234567891123");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_LENGTH));
	}

	@Test
	public void testSequenceNotViolated() {

		// act
		List<String> result = passwordValidatorService.validate("abcde12345");

		// verify
		assertFalse(result.contains(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testSequenceRepeatLetters() {

		// act
		List<String> result = passwordValidatorService.validate("abab");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testSequenceRepeatSingleLetter() {

		// act
		List<String> result = passwordValidatorService.validate("aa");

		// verify
		assertFalse(result.contains(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testSequenceRepeatLettersAndDigits() {

		// act
		List<String> result = passwordValidatorService.validate("ab1ab1");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testSequenceRepeatLettersNotAtFront() {

		// act
		List<String> result = passwordValidatorService.validate("prefixabab");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

	@Test
	public void testSequenceRepeatLettersNotAtBack() {

		// act
		List<String> result = passwordValidatorService.validate("ababpostfix");

		// verify
		assertThat(result, hasItem(ERROR_PASSWORD_SEQUENCE_REPEATED));
	}

}
