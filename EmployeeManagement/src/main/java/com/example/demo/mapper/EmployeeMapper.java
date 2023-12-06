package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.Employee;

@Component
public class EmployeeMapper {

	public EmployeeEntity getEmployeeEntity(Employee employee) {
		EmployeeEntity emp = new EmployeeEntity();
		emp.setFname(employee.getFname());
		emp.setLname(employee.getLname());
		emp.setDeptname(employee.getDeptname());
		emp.setDeptdivision(employee.getDeptdivision());
		return emp;
	}

	public Employee getEmployee(EmployeeEntity employee) {
		Employee emp = new Employee();
		emp.setFname(employee.getFname());
		emp.setLname(employee.getLname());
		emp.setDeptname(employee.getDeptname());
		emp.setDeptdivision(employee.getDeptdivision());
		emp.setId(employee.getId());
		return emp;
	}

	public EmployeeEntity updateEmployee(EmployeeEntity emp, Employee employee) {
		emp.setFname(employee.getFname());
		emp.setLname(employee.getLname());
		emp.setDeptname(employee.getDeptname());
		emp.setDeptdivision(employee.getDeptdivision());
		return emp;
	}

}
