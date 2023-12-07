package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("empmanagement")
public class EmployeeManagementController {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = "/searchbyid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getEmployeeDetailsById(@PathVariable("id") long id) throws Exception {
		Employee emp = service.findEmployeeById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addemp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) throws Exception{
		Employee emp = service.addEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateemp/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable("id") long id) throws Exception{
		Employee emp = service.updateEmployee(id, employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}


}
