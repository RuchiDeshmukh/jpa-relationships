package com.jpa.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Employee;
import com.jpa.entity.Project;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.ProjectRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee){
		
		return employeeRepository.save(employee);
	}

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees(){
		
		return employeeRepository.findAll();
	}
	
	@GetMapping("/getEmployee/{empId}")
	public Employee getEmployee(@PathVariable(required = false) Long empId){
		
		return employeeRepository.findById(empId).get();
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public ResponseEntity removeEmpoyee(@PathVariable Long empId) {
		employeeRepository.deleteById(empId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping("{empId}/project/{projectId}")
	public Employee assignProjectsToEmployee(@PathVariable Long empId, @PathVariable Long projectId) {
		Set<Project> projects = null;
		Employee emp = employeeRepository.findById(empId).get();
		Project project = projectRepository.findById(projectId).get();
		projects = emp.getAssignedProjects();
		projects.add(project);
		emp.setAssignedProjects(projects);
		return employeeRepository.save(emp);
	}
	
}
