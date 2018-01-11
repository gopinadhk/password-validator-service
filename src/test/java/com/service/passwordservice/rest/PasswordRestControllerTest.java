package com.service.passwordservice.rest;

import static com.service.passwordservice.rule.IPasswordRule.EMPTY_PASSWORD;
import static com.service.passwordservice.rule.IPasswordRule.ERROR_PASSWORD_CASE;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.service.passwordservice.rule.PasswordValidatorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordRestControllerTest {

	private MockMvc passwordRestControllerMock;

	@Mock
	private PasswordValidatorService passwordValidatorService;

	@InjectMocks
	private PasswordRestController passwordRestController;

	@Before
	public void setUp() throws Exception {
		passwordRestControllerMock = MockMvcBuilders.standaloneSetup(passwordRestController).build();
	}

	@Test
	public void testValidatePassword_CASE_PASSWORD() throws Exception {
		String input = "{\"test\"}";

		List<String> output = new ArrayList<String>();
		output.add(ERROR_PASSWORD_CASE);

		when(passwordValidatorService.validate(input, null)).thenReturn(output);

		passwordRestControllerMock
				.perform(post("/passwordService/validatePassword").contentType(MediaType.APPLICATION_JSON)
						.content(input))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.payload.data[0]", Matchers.containsString(ERROR_PASSWORD_CASE)));
	}

	@Test
	public void testValidatePassword_EMPTY_PASSWORD() throws Exception {
		String json = "{\"\"}";

		List<String> output = new ArrayList<String>();
		output.add(EMPTY_PASSWORD);
		when(passwordValidatorService.validate(json, null)).thenReturn(output);

		passwordRestControllerMock
				.perform(
						post("/passwordService/validatePassword").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.payload.data[0]", Matchers.containsString(EMPTY_PASSWORD)));
	}

}