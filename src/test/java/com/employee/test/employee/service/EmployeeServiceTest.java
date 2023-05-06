package com.employee.test.employee.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.employee.dto.EmployeeResponse;
import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
//import com.google.common.base.Optional;
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks EmployeeService employeeService;
	@Mock EmployeeRepository employeeRepository;
	
	private Employee employee;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		employee = new Employee();
		Department department = new Department();
		employee.setEmpId(234527);
		employee.setEmpName("Shiv");
		employee.setDepartment(department);
		employee.setEmpManager("Gaytri");
	}
	@DisplayName("Junit test for save employee")
	@Test
	public void saveEmployeeTest() {
		
		given(employeeRepository.save(employee)).willReturn(employee);
		Employee savedEmployee = employeeService.saveEmployee(employee);
		assertThat(savedEmployee).isNotNull();
		
	}
	
	@Test
	public void givenEmployeeId_whenGetEmployeeByID_thenReturnEmployeeObjectTest() {
		given(employeeRepository.findByEmployee(234527)).willReturn(new EmployeeResponse());
		EmployeeResponse getEmployee = employeeService.getemployee(employee.getEmpId());
		assertThat(getEmployee).isNotNull();
	}
}
