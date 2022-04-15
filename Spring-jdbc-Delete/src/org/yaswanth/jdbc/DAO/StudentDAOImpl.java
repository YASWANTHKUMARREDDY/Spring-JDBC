/**
 * 
 */
package org.yaswanth.jdbc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yaswanth.jdbc.Student;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Student student) {

		Object[] args = { student.getRollNo(), student.getName(), student.getAddress() };
		String sql = "Insert into student values (?,?,?)";

		int update = getJdbcTemplate().update(sql, args);

		System.out.println(update + " rows Updated");
	}

	@Override
	public void insert(List<Student> student) {

		String sql = "Insert into student(ROLL_NO,STUDENT_NAME,STUDENT_ADDRESS) values (?,?,?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<>();

		for (Student temp : student) {
			Object[] args = { temp.getRollNo(), temp.getName(), temp.getAddress() };
			sqlArgs.add(args);
		}
		jdbcTemplate.batchUpdate(sql, sqlArgs);

	}

	@Override
	public boolean deleteRecordByRollNo(int rollNo) {

		String sql = "Delete From STUDENT Where ROLL_NO =?";
		int recordsDeleted = jdbcTemplate.update(sql, rollNo);
		System.out.println("No of Rows Deleted : " + recordsDeleted);
		return recordsDeleted == 1;
	}

}
