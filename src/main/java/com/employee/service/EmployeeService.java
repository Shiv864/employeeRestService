package com.employee.service;

import java.util.List;

import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;

@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeResponse getemployee(Integer empId) {
		return employeeRepository.findByEmployee(empId);
	}
	
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public List<EmployeeResponse> getAllEmployeeResponse(){
		return employeeRepository.findEmployeeAll();
	}
	public List<Employee> getHighestSalary(int limit){
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"salary"));
	}
}
