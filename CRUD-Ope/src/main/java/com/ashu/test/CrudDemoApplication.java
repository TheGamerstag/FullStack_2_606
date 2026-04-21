package com.ashu.test;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDDAO studentDDAO) {
		return runner -> {
			// 1. Create (Insert)
			insertData(studentDDAO);
			
			// 2. Read All
			readAll(studentDDAO);
			
			// 3. Update
			// updateData(studentDDAO); 
			
			// 4. Delete
			// deleteData(studentDDAO);
		};
	}
	
	private void deleteData(StudentDDAO studentDDAO) {
		int stuId = 2002;
		studentDDAO.deleteById(stuId);
		System.out.println("Deleted student with ID: " + stuId);
	}
	
	private void updateData(StudentDDAO studentDDAO) {
		int stuId = 2002;
		Student s = studentDDAO.findById(stuId).orElse(null);
		if(s != null) {
			s.setName("Updated Shashank");
			studentDDAO.save(s);
			System.out.println("Updated student with ID: " + stuId);
		} else {
			System.out.println("Student not found");
		}
	}
	
	private void readAll(StudentDDAO studentDDAO) {
		List<Student> students = studentDDAO.findAll();
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	private void insertData(StudentDDAO studentDDAO) {
		Student obj = new Student(2002, "Shashank");
		Student obj1 = new Student(2001, "Tanu");
		studentDDAO.save(obj);
		studentDDAO.save(obj1);
		System.out.println("Data inserted");
	}
}
