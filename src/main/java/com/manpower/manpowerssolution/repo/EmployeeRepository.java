package com.manpower.manpowerssolution.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manpower.manpowerssolution.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
