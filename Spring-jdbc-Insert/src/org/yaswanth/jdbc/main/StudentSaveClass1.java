/**
 * 
 */
package org.yaswanth.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yaswanth.jdbc.Student;
import org.yaswanth.jdbc.DAO.StudentDAOImpl;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
public class StudentSaveClass1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		StudentDAOImpl bean = context.getBean("studentDAOImpl", StudentDAOImpl.class);

		Student student = new Student();
		student.setRollNo(6);
		student.setName("Chinna");
		student.setAddress("Vijayawada");

//		StudentDAO studentDAO = new StudentDAOImpl();
//		studentDAO.insert(student);
		bean.insert(student);

	}

}
