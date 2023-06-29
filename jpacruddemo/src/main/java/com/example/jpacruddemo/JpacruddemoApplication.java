package com.example.jpacruddemo;

import com.example.jpacruddemo.dao.StudentDAO;
import com.example.jpacruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO );
		};
	}


	private void deleteStudent(StudentDAO studentDAO){
		int studentId = 5;
		System.out.println("Deleting student id : " + studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO){
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating Student...");
		myStudent.setFirstName("Taylor");
		studentDAO.update(myStudent);
		System.out.println("Updated student : " + myStudent);


	}
	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
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
