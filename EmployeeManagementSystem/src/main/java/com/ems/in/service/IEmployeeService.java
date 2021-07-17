package com.ems.in.service;

import java.util.List;

import com.ems.in.entity.Employee;

public interface IEmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getSingleEmployee(Integer eid);
	
}
