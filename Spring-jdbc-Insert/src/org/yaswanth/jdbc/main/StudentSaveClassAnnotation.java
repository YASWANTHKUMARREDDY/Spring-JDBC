/**
 * 
 */
package org.yaswanth.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yaswanth.jdbc.Student;
import org.yaswanth.jdbc.DAO.StudentDAOImpl;
import org.yaswanth.jdbc.DAO.StudentDAOImplAnnotation;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
public class StudentSaveClassAnnotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		StudentDAOImplAnnotation bean = context.getBean("studentDAOAnnotation", StudentDAOImplAnnotation.class);

		Student student = new Student();
		student.setRollNo(7);
		student.setName("Chintu");
		student.setAddress("TPT");

//		StudentDAO studentDAO = new StudentDAOImpl();
//		studentDAO.insert(student);
		bean.insert(student);

	}

}
