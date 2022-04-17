/**
 * 
 */
package org.yaswanth.jdbc.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yaswanth.jdbc.Student;
import org.yaswanth.jdbc.service.StudentAddressResultSetExtractor;
import org.yaswanth.jdbc.service.StudentRowMapper;

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

		String sql = "SELECT * FROM STUDENT";

		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());

		return students;
	}

	@Override
	public Student findStudentByRollNo(int rollNo) {

		String sqlStatement = "SELECT * FROM STUDENT WHERE ROLL_NO = ?";

		Student sutdent = jdbcTemplate.queryForObject(sqlStatement, new StudentRowMapper(), rollNo);

		return sutdent;
	}

	@Override
	public Map<String, List<String>> groupStudentsByAddress() {

		String sql = "SELECT * FROM STUDENT";

		Map<String, List<String>> result = jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());

		return result;
	}

	@Override
	public int updateStudent(Student student) {

		String sql = "UPDATE STUDENT SET STUDENT_ADDRESS = ? WHERE ROLL_NO = ?";

		int updatedRecords = jdbcTemplate.update(sql, student.getAddress(), student.getRollNo());

//		Object[] args = { student.getAddress(), student.getRollNo() };
//		jdbcTemplate.update(sql, args);

		return updatedRecords;
	}

	@Override
	@Transactional
	public int updateStudentsList(List<Student> studentList) {

		String sql = "UPDATE STUDENT SET STUDENT_ADDRESS = ? WHERE ROLL_NO = ?";

		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {

				// need to set values for the sql statement

				ps.setString(1, studentList.get(index).getAddress());
				ps.setInt(2, studentList.get(index).getRollNo());

			}

			@Override
			public int getBatchSize() {
				// we need to define how many times query or setValues method has to executed

				return studentList.size();
			}
		});
		int updatedRowCount = 0;
		for (int i = 0; i < batchUpdate.length; i++) {
			if (batchUpdate[i] == 1)
				updatedRowCount++;
		}

		return updatedRowCount;
	}
	// to use Transactional Annotation we need to configure/Activate in xml file
	// we can use Transaction Annotation at top of the Method or at the top of the
	// class
	// Transaction Annotation is Used to Roll Back the all Changes if any error
	// occurs in the process.
}
