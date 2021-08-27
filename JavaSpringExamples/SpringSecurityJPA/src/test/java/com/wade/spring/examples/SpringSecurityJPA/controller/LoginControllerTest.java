package com.wade.spring.examples.SpringSecurityJPA.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.wade.spring.examples.SpringSecurityJPA.model.User;
import com.wade.spring.examples.SpringSecurityJPA.service.UserService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class LoginControllerTest {
	@InjectMocks
	private LoginController controller;
	@Mock
	private UserService service;
	@Mock
	private BindingResult bindingResult;

	@Test
	public void testCreateNewUser_UserDoesNotExists() {
		User user = User.builder().id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com")
				.build();
		when(service.findUserByUserName(anyString())).thenReturn(null);
		when(bindingResult.hasErrors()).thenReturn(true);
		ModelAndView result = controller.createNewUser(user, bindingResult);
		assertNotNull(result);
		assertEquals("registration", result.getViewName());
		verify(service, times(0)).saveUser(user);
	}

	@Test
	public void testCreateNewUser_UserExists() {
		User user = User.builder().id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com")
				.build();
		when(service.findUserByUserName(anyString())).thenReturn(user);
		when(bindingResult.hasErrors()).thenReturn(false);
		ModelAndView result = controller.createNewUser(user, bindingResult);
		assertNotNull(result);
		assertEquals("registration", result.getViewName());
		verify(service, times(1)).saveUser(user);
	}

	@Test
	public void testHome() {
		Authentication authentication = mock(Authentication.class);
		SecurityContext securityContext = mock(SecurityContext.class);
		User user = User.builder().id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com")
				.build();

		when(service.findUserByUserName(anyString())).thenReturn(user);
		when(authentication.getName()).thenReturn("GPonce");
		when(securityContext.getAuthentication()).thenReturn(authentication);

		SecurityContextHolder.setContext(securityContext);

		ModelAndView result = controller.home();

		assertNotNull(result);
	}

	@Test
	void testLogin() {
		ModelAndView result = controller.login();
		assertNotNull(result);
		assertEquals("login", result.getViewName());
	}

	@Test
	public void testRegistration() {
		ModelAndView result = controller.registration();
		assertNotNull(result);
		assertEquals("registration", result.getViewName());
	}
}
