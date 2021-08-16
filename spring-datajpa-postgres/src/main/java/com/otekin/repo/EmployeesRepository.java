package com.otekin.repo;

import com.otekin.entitiy.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository  extends JpaRepository<Employees ,Long> {
}
