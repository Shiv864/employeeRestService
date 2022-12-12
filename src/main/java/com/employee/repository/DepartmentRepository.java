package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.employee.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	//@Override
	//@EntityGraph(type = EntityGraphType.FETCH, attributePaths =  {"employees"})
 	Optional<Department> findByDepartmentId(Integer departmentId);
}
