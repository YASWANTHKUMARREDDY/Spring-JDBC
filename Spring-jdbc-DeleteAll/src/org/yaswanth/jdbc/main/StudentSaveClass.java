/**
 * 
 */
package org.yaswanth.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
		StudentDAOImpl bean = context.getBean("studentDAO", StudentDAOImpl.class);

		int rowsDeleted = bean.deleteRecordByStudentNameOrStudentAddress("yaswanth", "mcu");

		System.out.println("No of Rows Deleted.." + rowsDeleted);
	}

}
