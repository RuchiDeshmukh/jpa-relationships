package com.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Department {
	
	@Id 
	@GeneratedValue( strategy=GenerationType.AUTO )
	Long id;
	String name;
	
	@OneToMany(targetEntity = Employee.class)
	List<Employee> employeeList = new ArrayList<>();

}
