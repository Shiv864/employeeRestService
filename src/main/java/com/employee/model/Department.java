package com.employee.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Department")
//@Table(name="Department")
//@PrimaryKeyJoinColumn(name="EMPID")
public class Department{

	
	/**
	 * 
	 */
	//private static final long serialVersionUID = -3316188360621766663L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="DEPTNO")
	
	private int departmentId;
	
	@Column(name="DNAME")
	
	private String departmentName;
	
	@Column(name="loc")
	private String location;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
  	private List<Employee> employees;
	
	@OneToOne(mappedBy = "department")
	private Employee employee;
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() { return employees; }
	  
	public void setEmployees(List<Employee> employees) { this.employees = employees;
	  }
	
	public Employee getEmployee() { return employee; }
	  
	public void setEmployee(Employee employee) { this.employee = employee;
	  }
	
	
	 
	
	
}
