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
public class StudentSaveClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAOImpl bean = context.getBean("studentDAOImpl", StudentDAOImpl.class);

		Student student = new Student();
		student.setRollNo(3);
		student.setName("VANI");
		student.setAddress("KADIRI");

//		StudentDAO studentDAO = new StudentDAOImpl();
//		studentDAO.insert(student);
		bean.insert(student);

	}

}
