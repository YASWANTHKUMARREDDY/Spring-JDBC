package org.yaswanth.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<String, List<String>> studentMap = new HashMap<String, List<String>>();

		while (rs.next()) {

			String studentName = rs.getString("STUDENT_NAME");

			String studentAddress = rs.getString("STUDENT_ADDRESS");

			List<String> namesList = studentMap.get(studentAddress);

			if (namesList == null) {
				ArrayList<String> studentList = new ArrayList<String>();
				studentList.add(studentName);
				studentMap.put(studentAddress, studentList);

			} else
				namesList.add(studentName);

		}
		return studentMap;
	}

}
