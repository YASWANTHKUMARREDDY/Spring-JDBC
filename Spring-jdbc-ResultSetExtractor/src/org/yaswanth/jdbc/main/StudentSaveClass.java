/**
 * 
 */
package org.yaswanth.jdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yaswanth.jdbc.Student;
import org.yaswanth.jdbc.DAO.StudentDAOImpl;
import org.yaswanth.jdbc.service.StudentDAOHelper;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
public class StudentSaveClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAOImpl studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);
		StudentDAOHelper helper = context.getBean("studentDaoHelper", StudentDAOHelper.class);
		
		List<Student> allStudents = studentDAO.findAllStudents();
	
		System.out.println("Fetching all Objects From Table..");
		
		helper.printAllStudents(allStudents);
		
		System.out.println("*********************************************");
		
		System.out.println("Fetching Student Data Based on Roll No.");
		
		Student student = studentDAO.findStudentByRollNo(2);
		
		System.out.println(student);
		
	}

}
