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

		boolean isDeleted = bean.deleteRecordByRollNo(2);

		if (isDeleted)
			System.out.println("Data Deleted Succesfully..");
	}

}
