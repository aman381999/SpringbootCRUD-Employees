package com.practicespring.practiceSpringboot;

import com.practicespring.practiceSpringboot.model.Employee;
import com.practicespring.practiceSpringboot.repository.EmployeeRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticeSpringbootApplication.class, args);
	}

	@Autowired
	private EmployeeRepossitory employeeRepossitory;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Ramesh");
//		employee1.setLastName("kumar");
//		employee1.setEmailId("ramshkumar@mail.com");
//		employeeRepossitory.save(employee1);
//
//		Employee employee2 = new Employee();
//		employee2.setFirstName("Suresh");
//		employee2.setLastName("Singh");
//		employee2.setEmailId("sureshsingh@mail.com");
//		employeeRepossitory.save(employee2);
	}
}
