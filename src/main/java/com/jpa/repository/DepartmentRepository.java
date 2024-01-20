package com.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
