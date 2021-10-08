package com.wade.spring.examples.SpringSecurityJPA.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import javax.persistence.Id;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import com.wade.spring.examples.SpringSecurityJPA.model.Role;
import com.wade.spring.examples.SpringSecurityJPA.model.Role.RoleBuilder;
import com.wade.spring.examples.SpringSecurityJPA.model.User;
import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class MyUserDetailsServiceTest {
	@Mock
	private UserService mockUserService;
	@InjectMocks
	private MyUserDetailsService service;

	@Test
	void testLoadUserByUsername1() {
		RoleBuilder builder = Role.builder();
		Role role = builder.id(1).role("role").build();
		HashSet<Role> roles = new HashSet<>();
		roles.add(role);
		User user = User.builder().id(1).userName("GPonce").email("test@test.com").name("Gustavo").lastName("Ponce")
				.password("pasword").active(true).roles(roles).build();
		String userName = "GPonce";
		when(mockUserService.findUserByUserName(userName)).thenReturn(user);
		UserDetails result = service.loadUserByUsername(userName);
		assertNotNull(result);
		assertNotNull(result.getUsername());
		assertNotNull(result.getPassword());
		assertNotNull(result.getAuthorities());
		assertNotNull(role.toString());
		assertNotNull(builder.toString());
        EqualsVerifier.forClass(role.getClass()).withIgnoredAnnotations(Id.class).verify();
	}
	
	@Test
	void testLoadUserByUsername2() {
		Role role = new Role(1,"role");
		HashSet<Role> roles = new HashSet<>();
		roles.add(role);
		User user = User.builder().id(1).userName("GPonce").email("test@test.com").name("Gustavo").lastName("Ponce")
				.password("pasword").active(true).roles(roles).build();
		String userName = "GPonce";
		when(mockUserService.findUserByUserName(userName)).thenReturn(user);
		UserDetails result = service.loadUserByUsername(userName);
		assertNotNull(result);
		assertNotNull(result.getUsername());
		assertNotNull(result.getPassword());
		assertNotNull(result.getAuthorities());
		assertNotNull(result.hashCode());
        EqualsVerifier.forClass(role.getClass()).withIgnoredAnnotations(Id.class).verify();
	}
	
	@Test
	void testLoadUserByUsername3() {
		Role role = new Role();
		role.setId(1);
		role.setRole("role");
		HashSet<Role> roles = new HashSet<>();
		roles.add(role);
		User user = User.builder().id(1).userName("GPonce").email("test@test.com").name("Gustavo").lastName("Ponce")
				.password("pasword").active(true).roles(roles).build();
		String userName = "GPonce";
		when(mockUserService.findUserByUserName(userName)).thenReturn(user);
		UserDetails result = service.loadUserByUsername(userName);
		assertNotNull(result);
		assertNotNull(result.getUsername());
		assertNotNull(result.getPassword());
		assertNotNull(result.getAuthorities());
	}
}