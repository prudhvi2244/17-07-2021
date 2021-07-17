package com.ems.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.in.entity.Employee;
import com.ems.in.exception.EmployeeNotFoundException;
import com.ems.in.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository erepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee e = erepo.save(employee);
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = erepo.findAll();
		return allEmployees;
	}

	@Override
	public Employee getSingleEmployee(Integer eid) {
		Optional<Employee> opt = erepo.findById(eid);
		
		return opt.orElseThrow(()->new EmployeeNotFoundException("Employee With Given Id: "+eid+" Not Available"));
		
	}

}
