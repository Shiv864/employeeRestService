package com.employee.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * @author Dinesh Rajput
 *
 */
@Entity
@Table(name="Employee")

public class Employee{

	//private static final long serialVersionUID = -723583058586873479L;
	
	public Employee() {
		
	}
	
	public Employee(int empId, String empName, String empAddress){
		this.empId = empId;
		this.empName = empName;
		//this.empAddress = empAddress;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "empno")
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	
	@Column(name="job")
	private String empJob;
	
	@Column(name="mgr")
	private String empManager;
	
	@Column(name ="hiredate")
	private Date empHireDate;
	
		
	@Column(name="sal")
	private Long salary;
	
	@Column(name="comm")
	private Integer comm;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	
	//(targetEntity = Department.class)
	
	//https://stackoverflow.com/questions/24210478/hibernate-more-than-one-row-with-the-given-identifier-was-found-error
	//@ManyToOne(fetch = FetchType.LAZY)
	 // @OneToOne(fetch= FetchType.LAZY)
	  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinColumn(name = "deptno", nullable = false) 
	  private Department department;
	 

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public String getEmpManager() {
		return empManager;
	}

	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}

	public Date getEmpHireDate() {
		return empHireDate;
	}

	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
