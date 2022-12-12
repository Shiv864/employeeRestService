package com.employee.dto;

import java.sql.Date;

import javax.persistence.Column;

import com.employee.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeResponse {
	//private Employee employee;
	private int empId;
	private String empName;
	private String empJob;
	private String empManager;
	private Date empHireDate;
	private Long salary;
	//private Integer comm;
	private int deptNo;
	private String deptName;

	
	  public EmployeeResponse(int empId,String empName,String empJob, String empManager, Long salary,int deptNo, String deptName) {
		  //SELECT new com.employee.dto.EmployeeResponse(emp.empId,emp.empName,emp.empJob,emp.empManager,emp.empHireDate,emp.salary, dept.departmentId, dept.departmentName) FROM Employee emp JOIN emp.department dept
		  //super();
		  this.empId = empId;
		  this.empName = empName;
		  this.empJob = empJob;
		  this.empManager = empManager;
		  this.empHireDate = empHireDate;
		  this.salary = salary;
		  //this.comm = comm;
		  this.deptNo = deptNo; 
		  this.deptName = deptName; 
	 }
	 
	/*
	 * public EmployeeResponse( Employee employee, int deptNo, String deptName) {
	 * //super(); this.employee = employee; this.deptNo = deptNo; this.deptName =
	 * deptName; }
	 */
}
