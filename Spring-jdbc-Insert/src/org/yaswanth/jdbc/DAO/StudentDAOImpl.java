/**
 * 
 */
package org.yaswanth.jdbc.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.yaswanth.jdbc.Student;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
public class StudentDAOImpl implements StudentDAO {

	// private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

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

	// Creating Data Source through Java
//	public DataSource getDataSource() {
//
//		String url = "jdbc:mysql://localhost:3306/school?useSSL=false";
//		String userName = "root";
//		String password = "Chinna@0248";
//		DataSource dataSource = new DriverManagerDataSource(url, userName, password);
//
//		return dataSource;
//
//	}

}
