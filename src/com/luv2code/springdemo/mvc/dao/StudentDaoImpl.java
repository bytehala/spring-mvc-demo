package com.luv2code.springdemo.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.luv2code.springdemo.mvc.Student;

public class StudentDaoImpl implements StudentDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Student findByName(String name) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);

		String sql = "SELECT * FROM students WHERE first_name=:name";

		Student result = namedParameterJdbcTemplate.queryForObject(sql, params, new StudentMapper());

		// new BeanPropertyRowMapper(Customer.class));

		return result;

	}


	@Override
	public List<Student> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM students";

		List<Student> result = namedParameterJdbcTemplate.query(sql, params, new StudentMapper());

		return result;
	}

	private static final class StudentMapper implements RowMapper<Student> {

		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student user = new Student();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			return user;
		}
	}

}
