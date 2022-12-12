package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.dto.EmployeeResponse;
import com.employee.model.Employee;
@Repository("employeeRepository")
//@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//@EntityGraph(type = EntityGraphType.FETCH,attributePaths = {"department"})
	
	public Employee findByempId(Integer empid);
	
	//@EntityGraph(type = EntityGraphType.FETCH, attributePaths =  {"department"})
	@Query("SELECT new com.employee.dto.EmployeeResponse(emp.empId,emp.empName,emp.empJob,emp.empManager,emp.salary, dept.departmentId, dept.departmentName) FROM Employee emp JOIN emp.department dept")
	public List<EmployeeResponse> findEmployeeAll();

	//public Employee createEmployee(Employee emp);
	
	public List<Employee> findAll();
	
	//public Employee saveEmployee(Employee emp);

	//public Employee createEmployee(Employee emp);

}
