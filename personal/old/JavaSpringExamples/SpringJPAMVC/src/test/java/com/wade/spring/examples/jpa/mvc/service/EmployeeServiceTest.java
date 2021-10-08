package com.wade.spring.examples.jpa.mvc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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

import com.wade.spring.examples.jpa.mvc.exception.RecordNotFoundException;
import com.wade.spring.examples.jpa.mvc.model.Employee;
import com.wade.spring.examples.jpa.mvc.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	@InjectMocks
	EmployeeService service;
	@Mock
	EmployeeRepository repository;

	@Test
	void testCreateOrUpdateEmployee_Save() {
		Employee value = new Employee();
		when(repository.save(value)).thenReturn(value);
		Employee result = service.createOrUpdateEmployee(value);
		assertEquals(value, result);
	}

	@Test
	void testCreateOrUpdateEmployee_Update_IsNotPresent() {
		Employee value = new Employee("a", "b", "c", "d");
		value.setId(1L);
		Optional<Employee> value2 = Optional.empty();
		when(repository.findById(any(Long.class))).thenReturn(value2);
		when(repository.save(any(Employee.class))).thenReturn(value);
		Employee result = service.createOrUpdateEmployee(value);
		assertEquals(value, result);
		verify(repository).save(value);
	}

	@Test
	void testCreateOrUpdateEmployee_Update_IsPresent() {
		Employee value = new Employee("a", "b", "c", "d");
		value.setId(1L);
		Employee value2 = new Employee();
		value.setId(1L);
		when(repository.findById(any(Long.class))).thenReturn(Optional.of(value2));
		when(repository.save(any(Employee.class))).thenReturn(value);
		Employee result = service.createOrUpdateEmployee(value);
		assertEquals(value, result);
		verify(repository).save(value2);
	}

	@Test
	void testDeleteEmployeeById1() throws Exception {
		Employee value = new Employee("a", "b", "c", "d");
		value.setId(1L);
		when(repository.findById(any(Long.class))).thenReturn(Optional.of(value));
		service.deleteEmployeeById(1L);
		verify(repository).deleteById(1L);
	}

	@Test
	void testDeleteEmployeeById2() throws Exception {
		Employee value = new Employee("a", "b", "c", "d");
		value.setId(1L);
		when(repository.findById(any(Long.class))).thenReturn(Optional.empty());
		assertThrows(RecordNotFoundException.class, () -> {
			service.deleteEmployeeById(1L);
		});
	}

	@Test
	void testGetAllEmployees_Employees() {
		Employee entry = new Employee("a", "b", "c", "d");
		entry.setId(1L);
		List<Employee> value = new ArrayList<>();
		value.add(entry);
		when(repository.findAll()).thenReturn(value);
		List<Employee> result = service.getAllEmployees();
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(entry, result.get(0));
	}

	@Test
	void testGetAllEmployees_NoEmployees() {
		List<Employee> value = new ArrayList<>();
		when(repository.findAll()).thenReturn(value);
		List<Employee> result = service.getAllEmployees();
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	void testGetEmployeeById1() throws Exception {
		Employee value = new Employee("a", "b", "c", "d");
		value.setId(1L);
		when(repository.findById(any(Long.class))).thenReturn(Optional.of(value));
		Employee result = service.getEmployeeById(1L);
		assertNotNull(result);
	}

	@Test
	void testGetEmployeeById2() throws Exception {
		Employee value = new Employee("a", "b", "c", "d");
		value.setId(1L);
		when(repository.findById(any(Long.class))).thenReturn(Optional.empty());
		assertThrows(RecordNotFoundException.class, () -> {
			service.getEmployeeById(1L);
		});
	}
}
