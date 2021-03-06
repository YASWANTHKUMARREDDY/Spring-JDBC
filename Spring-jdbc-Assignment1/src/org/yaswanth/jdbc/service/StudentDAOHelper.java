package org.yaswanth.jdbc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaswanth.jdbc.Student;
import org.yaswanth.jdbc.DAO.StudentDAO;

@Service("studentDaoHelper")
public class StudentDAOHelper {

	@Autowired
	private StudentDAO studentDAO;

	public void setUpStudentTable() {

		Student student1 = new Student();
		student1.setRollNo(1);
		student1.setName("Yaswanth");
		student1.setAddress("MCU");

		Student student2 = new Student();
		student2.setRollNo(2);
		student2.setName("Pavan");
		student2.setAddress("MCU");

		Student student3 = new Student();
		student3.setRollNo(3);
		student3.setName("Vani");
		student3.setAddress("Kadiri");

		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);

		System.out.println("Inserting Batch of Objects..");
		studentDAO.insert(studentList);

	}

	public void printAllStudents(List<Student> students) {

		for (Student student : students) {

			System.out.println(student);
		}
	}
}
