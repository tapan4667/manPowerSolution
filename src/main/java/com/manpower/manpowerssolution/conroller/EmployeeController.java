package com.manpower.manpowerssolution.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manpower.manpowerssolution.entity.Employee;
import com.manpower.manpowerssolution.exception.EmployeeNotFoundException;
import com.manpower.manpowerssolution.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		try {
			Employee employeeById = employeeService.getEmployeeById(id);
			return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
		Employee employee = employeeService.createEmployee(emp);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable long id) {
		Employee empl = employeeService.updateEmployee(id, emp);
		return new ResponseEntity<>(empl, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeByid(@PathVariable long id) {
		employeeService.deleteEmployeeByid(id);
		return ResponseEntity.noContent().build();
	}
}