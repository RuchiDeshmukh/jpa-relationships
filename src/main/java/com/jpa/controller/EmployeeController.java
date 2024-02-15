package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Department;
import com.jpa.entity.Employee;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired 
	private DepartmentRepository departmentRepository;
	
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee){
		Department department = employee.getDepartment();
		departmentRepository.save(department);
		return employeeRepository.save(employee);
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		
		return employeeRepository.findAll();
	}
	
}
