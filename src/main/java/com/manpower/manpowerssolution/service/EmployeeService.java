package com.manpower.manpowerssolution.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manpower.manpowerssolution.entity.Employee;
import com.manpower.manpowerssolution.exception.EmployeeNotFoundException;
import com.manpower.manpowerssolution.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found With This Id " + id));
	}

	public Employee createEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee empexistingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with this id" + id));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(updatedEmployee, empexistingEmployee);
		return employeeRepository.save(empexistingEmployee);
	}

	public void deleteEmployeeByid(Long id) {
		employeeRepository.deleteById(id);
	}
}
