package com.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id 
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long eId;
	private String eName;

	@ManyToMany
	@JoinTable(name = "employee_project",
			   joinColumns = @JoinColumn(name = "employee_id"),
			   inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<Project> assignedProjects = new HashSet<>();
	
	
}
