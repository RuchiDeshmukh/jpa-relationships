package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Project;
import com.jpa.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@PostMapping("/saveProject")
	public Project saveProject(@RequestBody Project Project){
		
		return projectRepository.save(Project);
	}

	@GetMapping("/getProjects")
	public List<Project> getProjects(){
		
		return projectRepository.findAll();
	}
	
	@GetMapping("/getProject/{projectId}")
	public Project getProject(@PathVariable(required = false) Long projectId){
		
		return projectRepository.findById(projectId).get();
	}
	
	@DeleteMapping("/deleteProject/{projectId}")
	public ResponseEntity removeEmpoyee(@PathVariable Long projectId) {
		projectRepository.deleteById(projectId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
