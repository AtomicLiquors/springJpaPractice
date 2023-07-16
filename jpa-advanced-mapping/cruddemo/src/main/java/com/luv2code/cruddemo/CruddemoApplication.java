package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
  	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
			//addMoreCoursesForStudents(appDAO);
			//deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO){
		int theId = 1;
		System.out.println("Deleting Student By Id : " + theId);

		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudents(AppDAO appDAO){
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("Rubik's Cube Speedrun Quick Guide");
		Course tempCourse2 = new Course("Unity 3D Game Development");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student : " + tempStudent);
		System.out.println("Courses : " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Updated!!");
	}

	private void findStudentAndCourses(AppDAO appDAO){
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loaded Student : " + tempStudent);
		System.out.println("Loaded Courses : " + tempStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO){
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Loaded Course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());
		System.out.println("Done!");
	};

	private void createCourseAndStudents(AppDAO appDAO) {
			Course tempCourse = new Course("Batman Origins and Anthology");
			Student tempStudent1 = new Student("John", "Nash","delusional@harvard.ac");
			Student tempStudent2 = new Student("Amadeus", "Joe", "totallyawesome@amazon.com");

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			System.out.println("Saving course : " + tempCourse);
			System.out.println("Students Enrolled : " + tempCourse.getStudents());
			appDAO.save(tempCourse);
			System.out.println("Done!!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO){
		int theId = 10;
		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId); //cascadeType.ALL에 의해 연관 레코드 연쇄 삭제
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}


	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Super Mario 3 - Unlimited Coins Trick");
		tempCourse.addReview(new Review("this is a complete clickbait lmao"));
		tempCourse.addReview(new Review("damn this is legit"));
		tempCourse.addReview(new Review("only a dumb find this difficult, quit complaining you pps"));

		System.out.println("saving...");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);
		System.out.println("saved!");

	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Deleting course id : " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO){
		int theId = 12;
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

	}

	private void updateInstructor(AppDAO appDAO){
		int theId = 4;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating inst. id : " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);
		System.out.println("Done!");

	}
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO){
		int theId = 4;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Finding courses for instructor id : " + theId);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO){
		int theId = 4;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding courses for instructor id : " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO){
		int theId = 4;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}
	private void createInstructorWithCourses(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("Demian", "Brenks", "gyqls@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.hacker.com/youtube","Hakcer for fun!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1 = new Course("Air Guitar - The ultimate guide");
		Course tempCourse2 = new Course("Seth Riggs Vocal Training");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor:" + tempInstructor);
		System.out.println("Courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Complete!");
	}

	private void deleteInstructorDetail(AppDAO appDAO){
		int theId = 3;
		System.out.println("Deleting detail : " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Success!");
	};

	private void findInstructorDetail(AppDAO appDAO){
		int theId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetail(theId);
		Instructor tempInstructor = tempInstructorDetail.getInstructor();

		System.out.println("associated instructor : " + tempInstructor);
	}

	private void deleteInstructor(AppDAO appDAO)	{
		int theId = 4;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructor(theId);
		System.out.println("Deleted!");
	}
	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id : " + theId);
	Instructor tempInstructor = appDAO.findInstructorById(theId);
	System.out.println("tempInstructor: " + tempInstructor);
	System.out.println("the associate instructorDetail only : " + tempInstructor.getInstructorDetail());

}
	private void createInstructor(AppDAO appDAO){
		Instructor tempInstructor = new Instructor("Morith", "Vega", "gyqls234@gmail.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.fixer.com/youtube","Guns for hire!!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor:" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Complete!");
	}
}
