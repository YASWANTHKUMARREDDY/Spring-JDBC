/**
 * 
 */
package org.yaswanth.jdbc.main;

import java.util.List;
import java.util.Map;

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

		System.out.println("Getting Address name Map......");

		Map<String, List<String>> result = studentDAO.groupStudentsByAddress();

		System.out.println(result);
	}

}
