package com.nvn.curdoperations.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nvn.curdoperations.model.Employee;
import com.nvn.curdoperations.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmloyees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> optionalemp = employeeRepository.findById(id);
		if (optionalemp.isPresent()) {
			return optionalemp.get();
		}
		return null;
	}

	@Override
	public Employee update(Employee employee) {
		employee.setUpdatedDate(LocalDateTime.now());
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

}
