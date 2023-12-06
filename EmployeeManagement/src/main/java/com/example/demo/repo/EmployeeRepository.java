package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeEntity;



public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
	
	@Query(value = "SELECT * FROM EMP_INFO u WHERE u.id = ?1", nativeQuery = true )
	EmployeeEntity findById(Long id);
	
}
