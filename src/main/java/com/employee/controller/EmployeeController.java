package com.employee.controller;

import java.util.ArrayList;
import java.util.List;

import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	
	
	@PostMapping(value="/addemployee",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Employee createEmployee(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);
	}
	
	//@RequestMapping(method = RequestMethod.GET, value = "employee/allemployee")
	//@RequestMapping(method = RequestMethod.GET, value = "employee/allemployee")
	@GetMapping(path = "/allemployee")
	@ResponseBody
	public List<EmployeeResponse> getAllEmployee() {
		List<EmployeeResponse> empList = new ArrayList<EmployeeResponse>();
		System.out.println("call from order service........");
			//employeeService.getemployee(null)
			empList = employeeService.getAllEmployeeResponse();
			return empList;
		
	}

	/*
	 * @GetMapping(path="/{empId}") public Optional<Employee>
	 * getEmployee(@PathVariable String empId) { return
	 * employeeService.getemployee(Integer.parseInt(empId)); },MediaType.APPLICATION_XML_VALUE
	 */
	@GetMapping(path="/{empId}",
			produces= {MediaType.APPLICATION_JSON_VALUE
					})
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable String empId) {
		EmployeeResponse employee =employeeService.getemployee(Integer.parseInt(empId));
		
		return new ResponseEntity<EmployeeResponse>(employee,HttpStatus.OK);
	}
	@GetMapping
	public List<Employee> getHighestSalary(@RequestParam(value ="limit") int limit){
		return employeeService.getHighestSalary(limit);
	}
}
