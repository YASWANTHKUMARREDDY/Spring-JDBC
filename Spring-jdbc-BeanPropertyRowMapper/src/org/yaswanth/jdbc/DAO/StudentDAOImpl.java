/**
 * 
 */
package org.yaswanth.jdbc.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	@Override
	public int deleteRecordByStudentNameOrStudentAddress(String name, String address) {

		String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDRESS = ?";

		// Object [] arguments = {name, address};
		// jdbcTemplate.update(sql, arguments);
		int deletedRows = jdbcTemplate.update(sql, name, address);
		System.out.println("No of Rows Deleted : " + deletedRows);
		return deletedRows;
	}

	@Override
	public void deleteAll() {

		String sql = "TRUNCATE TABLE STUDENT";
		jdbcTemplate.update(sql);
		System.out.println("Table is Empty Now...");

	}

	@Override
	public List<Student> findAllStudents() {

		String sql = "SELECT ROLL_NO as rollNo, STUDENT_NAME as name, STUDENT_ADDRESS as address FROM STUDENT";

		List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

		return students;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {

		String sqlStatement = "SELECT ROLL_NO as rollNo, STUDENT_NAME as name, STUDENT_ADDRESS as address FROM STUDENT WHERE ROLL_NO = ?";

		Student sutdent = jdbcTemplate.queryForObject(sqlStatement, new BeanPropertyRowMapper<Student>(Student.class),
				rollNo);

		return sutdent;
	}

}
