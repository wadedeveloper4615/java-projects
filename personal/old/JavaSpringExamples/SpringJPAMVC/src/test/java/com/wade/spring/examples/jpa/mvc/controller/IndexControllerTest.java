package com.wade.spring.examples.jpa.mvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.wade.spring.examples.jpa.mvc.model.Employee;
import com.wade.spring.examples.jpa.mvc.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {
	@InjectMocks
	private IndexController controller;
	@Mock
	Model model;
	@Mock
	Employee employee;
	@Mock
	EmployeeService service;
	Optional<Long> id = Optional.of(1L);
	Optional<Long> idNull = Optional.empty();

	@Test
	void testCreateOrUpdateEmployee() {
		String result = controller.createOrUpdateEmployee(employee);
		assertEquals("redirect:/", result);
		verify(service).createOrUpdateEmployee(employee);
	}

	@Test
	void testDeleteEmployeeById() throws Exception {
		String result = controller.deleteEmployeeById(model, 1L);
		assertEquals("redirect:/", result);
		verify(service).deleteEmployeeById(1L);
	}

	@Test
	void testEditEmployeeById_NotPresent() throws Exception {
		String result = controller.editEmployeeById(model, idNull);
		assertEquals("add-edit-employee", result);
		verify(service, times(0)).getEmployeeById(1L);
		verify(model).addAttribute("employee", new Employee());
	}

	@Test
	void testEditEmployeeById_Present() throws Exception {
		Employee value = new Employee();
		when(service.getEmployeeById(id.get())).thenReturn(value);
		String result = controller.editEmployeeById(model, id);
		assertEquals("add-edit-employee", result);
		verify(service, times(1)).getEmployeeById(1L);
		verify(model).addAttribute("employee", value);
	}

	@Test
	void testHandler() {
		assertNotNull(controller.handleAllExceptions(new RuntimeException()));
	}

	@Test
	void testHome() {
		List<Employee> value = new ArrayList<>();
		when(service.getAllEmployees()).thenReturn(value);
		assertEquals("index", controller.home(model));
		verify(model).addAttribute("employees", value);
	}
}
