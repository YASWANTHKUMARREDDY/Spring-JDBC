/**
 * 
 */
package org.yaswanth.jdbc.DAO;

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
		// TODO Auto-generated method stub
		
	}

}
