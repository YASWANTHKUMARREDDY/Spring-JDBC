/**
 * 
 */
package org.yaswanth.jdbc.DAO;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.yaswanth.jdbc.Student;

/**
 * @author POOLA YASWANTH KUMAR REDDY
 *
 * 
 */
public class StudentDAOImpl implements StudentDAO {

	// @Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

	@Override
	public void insert(Student student) {

		Object[] args = { student.getRollNo(), student.getName(), student.getAddress() };
		String sql = "Insert into student values (?,?,?)";

		int update = jdbcTemplate.update(sql, args);

		System.out.println(update +" rows Updated");
	}

	public DataSource getDataSource() {

		String url = "jdbc:mysql://localhost:3306/school?useSSL=false";
		String userName = "root";
		String password = "Chinna@0248";
		DataSource dataSource = new DriverManagerDataSource(url, userName, password);

		return dataSource;

	}

}
