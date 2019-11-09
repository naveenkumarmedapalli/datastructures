package com.nvn.curdoperations.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nvn.curdoperations.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
