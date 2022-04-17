package org.yaswanth.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.yaswanth.jdbc.Student;

public class StudentListResultSetExtrator implements ResultSetExtractor<List<Student>>{

	// ResultSetExtractor get all the data required from database at a time.
	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Student> studentList = new ArrayList<Student>();
		
		while(rs.next()) {
			Student student = new Student();
			
			student.setRollNo(rs.getInt("ROLL_NO"));
			student.setName(rs.getString("STUDENT_NAME"));
			student.setAddress(rs.getString("STUDENT_ADDRESS"));
			
			studentList.add(student);
		}
		return studentList;
	}



}