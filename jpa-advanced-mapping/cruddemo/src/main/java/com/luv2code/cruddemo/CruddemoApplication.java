package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.hibernate.boot.jaxb.hbm.internal.GenerationTimingConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
  	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		//Executed after the Spring Beans have been loaded.
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			deleteInstructorDetail(appDAO);
			//findInstructorDetail(appDAO);
		};
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
		int theId = 2;
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
