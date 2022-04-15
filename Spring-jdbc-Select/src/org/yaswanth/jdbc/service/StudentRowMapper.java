package org.yaswanth.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.yaswanth.jdbc.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student = new Student();

		student.setRollNo(rs.getInt("ROLL_NO"));
		student.setName(rs.getString("STUDENT_NAME"));
		student.setAddress(rs.getString("STUDENT_ADDRESS"));

		return student;
	}

}
