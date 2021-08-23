package com.otekin.repo;

import com.otekin.entitiy.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository  extends JpaRepository<Employee ,Long> {
}
