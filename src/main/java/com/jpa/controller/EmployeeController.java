package com.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Employee saveDepartment(@RequestBody Employee employee) {
		Optional<Department> dept = departmentRepository.findById(employee.getDepartment().getId());	
		employee.setDepartment(dept.get());
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/getEmployee/{employeeId}/{departmentId}")
	public Employee retrieveEmployee(@PathVariable Long employeeId, @PathVariable Long departmentId) {
		return employeeRepository.findByEmployeeIdAndDepartmentId(employeeId,departmentId);
	}

	
}
