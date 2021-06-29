package com.easytocourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytocourse.dao.EmployeeRepository;
import com.easytocourse.exception.Employeenotfound;
import com.easytocourse.model.Employee;

@Service
public class Employeeservice {
	
	@Autowired
	EmployeeRepository emprepo;

	public Employee saveemp(Employee emp) {
	
		 return emprepo.save(emp);
		 
	}

	public List<Employee> getallemloyees() {
		return emprepo.findAll();
	}

	public Employee getempbyid(int id) throws Exception {
		Optional<Employee> emp=emprepo.findById(id);
		if(!emp.isPresent())
			throw new Employeenotfound("Employee not found with id: "+id);
		return emp.get();
		
		
	}
	
}
