package com.nvn.curdoperations.service;

import java.util.List;

import com.nvn.curdoperations.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmloyees();

	Employee save(Employee employee);

	Employee findById(Long id);

	Employee update(Employee employee);

	void delete(Long id);
	
	
}
