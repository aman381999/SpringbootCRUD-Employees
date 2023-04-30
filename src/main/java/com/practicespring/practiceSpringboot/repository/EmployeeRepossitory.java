package com.practicespring.practiceSpringboot.repository;

import com.practicespring.practiceSpringboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepossitory extends JpaRepository<Employee, Long> {
    //all CRUD database operations in Repository

}
