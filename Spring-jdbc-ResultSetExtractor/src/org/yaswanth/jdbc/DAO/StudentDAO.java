/**
 * 
 */
package org.yaswanth.jdbc.DAO;

import java.util.List;

import org.yaswanth.jdbc.Student;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
public interface StudentDAO {

	void insert(Student student);

	void insert(List<Student> student);

	boolean deleteRecordByRollNo(int rollNo);

	int deleteRecordByStudentNameOrStudentAddress(String name, String address);
	
	public void deleteAll();
	
	List<Student> findAllStudents();
	
	Student findStudentByRollNo(int rollNo);
}
