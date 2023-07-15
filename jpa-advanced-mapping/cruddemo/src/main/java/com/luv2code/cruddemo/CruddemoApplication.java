package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter;
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
			//createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
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
		int theId = 12;
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
