package com.ems.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.in.entity.Employee;
import com.ems.in.service.IEmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService eservice;
	
	/*
	 * http://localhost:8080/employee/saveEmployee
	   
	   {
	     "eid":1,
	     "ename":"Prudhvi",
	     "ecity":"Goa"
	   }
	   
	 */
	
	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		eservice.saveEmployee(employee);
		
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	/*
	 * http://localhost:8080/employee/allEmployees
	 */
	@GetMapping(value = "/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> allEmployees=eservice.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.OK);
	}
	
	/*http://localhost:8080/employee/1
	 * 
	 */
	@GetMapping(value = "/{eid}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable Integer eid)
	{
		Employee employee=eservice.getSingleEmployee(eid);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
}
