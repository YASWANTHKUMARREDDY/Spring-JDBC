/**
 * 
 */
package org.yaswanth.jdbc.main;

import org.yaswanth.jdbc.Student;
import org.yaswanth.jdbc.DAO.StudentDAO;
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
		
		
		Student student = new Student ();
		student.setRollNo(2);
		student.setName("Pavan");
		student.setAddress("Mulakalacheruvu");
		
		StudentDAO studentDAO = new StudentDAOImpl();
		studentDAO.insert(student);

	}

}
