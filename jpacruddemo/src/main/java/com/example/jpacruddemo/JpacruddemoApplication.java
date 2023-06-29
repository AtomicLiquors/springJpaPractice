package com.example.jpacruddemo;

import com.example.jpacruddemo.dao.StudentDAO;
import com.example.jpacruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpacruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacruddemoApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner (String[] args){
		return runner -> {
			System.out.println("Hello world");
		};
	}*/

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			readStudent(studentDAO);
		};
	}


	private void readStudent(StudentDAO studentDAO){

		//create the student object
		System.out.println("Creating new student object ...");

		Student tempStudent = new Student("Paul", "Doe","paul@luve2code.com");

		//save the student object
		System.out.println("Saving Student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		Student createdStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("saved student : " + createdStudent);
	}
	private void createMultipleStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("Creating 3 student object ...");
		Student tempStudent1 = new Student("Thun", "Doe","paul@luve2code.com");
		Student tempStudent2 = new Student("Wal", "Doe","paul@luve2code.com");
		Student tempStudent3 = new Student("Jol", "Doe","paul@luve2code.com");

		//save the student object
		System.out.println("Saving Students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent (StudentDAO studentDAO){
		//create the student object
		System.out.println("Creating new student object ...");

		Student tempStudent = new Student("Paul", "Doe","paul@luve2code.com");

		//save the student object
		System.out.println("Saving Student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student, Generated id : " + tempStudent.getId());
	}

}
