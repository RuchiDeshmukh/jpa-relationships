package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("from Employee e where e.id = :employeeId and e.department.id = :departmentId")
	Employee findByEmployeeIdAndDepartmentId(Long employeeId, Long departmentId);

}
