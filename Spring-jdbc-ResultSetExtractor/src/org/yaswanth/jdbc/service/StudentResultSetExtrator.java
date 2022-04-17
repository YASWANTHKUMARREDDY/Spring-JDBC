package org.yaswanth.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.yaswanth.jdbc.Student;

public class StudentResultSetExtrator implements ResultSetExtractor<Student> {

	// ResultSetExtractor get all the data required from database at a time.
	@Override
	public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
		Student student = new Student();
		while (rs.next()) {
			student.setRollNo(rs.getInt("ROLL_NO"));
			student.setName(rs.getString("STUDENT_NAME"));
			student.setAddress(rs.getString("STUDENT_ADDRESS"));

		}
		return student;
	}

}
