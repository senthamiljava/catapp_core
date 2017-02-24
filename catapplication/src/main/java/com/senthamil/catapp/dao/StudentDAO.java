package com.senthamil.catapp.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.model.Student;
import com.senthamil.catapp.util.ConnectionUtil;

public class StudentDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();

	public void save(Student student) {
		String sql = "INSERT INTO students(NAME,dept) VALUES(?,?)";
		Object[] args = { student.getName(), student.getDept() };
		int rows = jdbcTemplate.update(sql, args);
		System.out.println("number of row inserted " + rows);
	}

	public Student validate(Student student) {
		Student stud = null;
		try {
			String sql = "select id,name,dept from students where id=?";
			Object[] args = { student.getId() };
			stud = jdbcTemplate.queryForObject(sql, args, (rs, rowNo) -> {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setDept(rs.getString("dept"));
				return s;
			});
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e);
		}
		return stud;
	}
}
