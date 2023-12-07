package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Value("${itemnot.found}")
	private String notFound;


	@Autowired
	private EmployeeMapper empMapper;

	public Employee addEmployee(Employee employee) throws Exception {
		EmployeeEntity empEntity = empMapper.getEmployeeEntity(employee);
		EmployeeEntity employeeSavedToDB = employeeRepository.save(empEntity);
		Employee emp = empMapper.getEmployee(employeeSavedToDB);
		return emp;
	}
	
	public Employee findEmployeeById(long empId)throws ItemNotFoundException  {
		EmployeeEntity empEntity = employeeRepository.findById(empId);
		if(Objects.isNull(empEntity)) {
			throw new ItemNotFoundException(notFound);
		}
		Employee emp = empMapper.getEmployee(empEntity);
		return emp;
	}
	
	public Employee updateEmployee(long empId, Employee employee) throws ItemNotFoundException {
		EmployeeEntity empDb = employeeRepository.findById(empId);
		if (Objects.isNull(empDb)) {
			throw new ItemNotFoundException(notFound);
		}
		EmployeeEntity empEntity = empMapper.updateEmployee(empDb, employee);
		EmployeeEntity employeeSavedToDB = employeeRepository.save(empEntity);
		Employee emp = empMapper.getEmployee(employeeSavedToDB);
		return emp;
	}
}
