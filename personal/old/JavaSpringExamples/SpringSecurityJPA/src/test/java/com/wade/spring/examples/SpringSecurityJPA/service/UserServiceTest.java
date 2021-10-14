package com.wade.spring.examples.SpringSecurityJPA.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import javax.persistence.Id;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import com.wade.spring.examples.SpringSecurityJPA.model.User;
import com.wade.spring.examples.SpringSecurityJPA.model.User.UserBuilder;
import com.wade.spring.examples.SpringSecurityJPA.repository.RoleRepository;
import com.wade.spring.examples.SpringSecurityJPA.repository.UserRepository;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserServiceTest {
	@Mock
	private UserRepository mockUserRepository;
	@Mock
	private RoleRepository mockRoleRepository;
	@Mock
	private BCryptPasswordEncoder mockBCryptPasswordEncoder;
	@InjectMocks
	private UserService userServiceUnderTest;

	@Test
	public void testFindByUserName() {
		UserBuilder builder = User.builder();
		User user = builder.id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com")
				.build();
		String userName = "GPonce";
		when(mockUserRepository.findByUserName(userName)).thenReturn(user);
		User result = userServiceUnderTest.findUserByUserName(userName);
		assertNotNull(result);
		assertEquals(userName, result.getUserName());
		assertNotNull(user.toString());
		assertNotNull(builder.toString());
        EqualsVerifier.forClass(user.getClass()).withIgnoredAnnotations(Id.class).verify();
	}

	@Test
	public void testFindUserByEmail() {
		User user = User.builder().id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com")
				.build();
		when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
		final String email = "test@test.com";
		final User result = userServiceUnderTest.findUserByEmail(email);
		assertEquals(email, result.getEmail());
	}

	@Test
	public void testSaveUser() {
		User user = User.builder().id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com")
				.build();
		when(mockUserRepository.save(any())).thenReturn(user);
		final String email = "test@test.com";
		User result = userServiceUnderTest.saveUser(User.builder().build());
		assertEquals(email, result.getEmail());
	}
}
