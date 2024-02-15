package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Department;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@PostMapping(value="/saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		
		
		
		return departmentRepository.save(department);
	}

	
}
