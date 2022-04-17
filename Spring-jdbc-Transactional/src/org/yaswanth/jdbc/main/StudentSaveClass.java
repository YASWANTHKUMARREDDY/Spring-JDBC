/**
 * 
 */
package org.yaswanth.jdbc.main;

import java.util.ArrayList;
import java.util.List;

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
		StudentDAOImpl studentDAO = context.getBean("studentDAO", StudentDAOImpl.class);

		System.out.println("Updating Student Record...");

//		Student student = new Student();
//		
//		student.setAddress("P MCU");
//		student.setRollNo(1);
//		
//		int updatedRecords = studentDAO.updateStudent(student);
//		
//		System.out.println(updatedRecords + " Records Updated..");

		Student student1 = new Student();
		student1.setAddress("P MCU");
		student1.setRollNo(1);

		Student student2 = new Student();
		student2.setAddress("MCU");
		student2.setRollNo(2);

		List<Student> studentList = new ArrayList<Student>();

		studentList.add(student2);
		studentList.add(student1);

		int updatedStudentsCount = studentDAO.updateStudentsList(studentList);

		System.out.println(updatedStudentsCount);
	}

}
