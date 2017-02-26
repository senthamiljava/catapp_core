package com.senthamil.catapp.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.model.Student;
import com.senthamil.catapp.model.StudentMark;
import com.senthamil.catapp.model.Subject;
import com.senthamil.catapp.util.ConnectionUtil;

public class StudentMarkDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();

	public List<StudentMark> list() {
		String sql = "select id,student_id,subject_id,cat1,cat2,cat3,internal from  student_mark_details";
		List<StudentMark> list = jdbcTemplate.query(sql, (rs, rowNo) -> {
			Student student = new Student();
			Subject subject = new Subject();
			student.setId(rs.getInt("student_id"));
			subject.setId(rs.getInt("subject_id"));
			StudentMark mark = new StudentMark();
			mark.setId(rs.getInt("id"));
			mark.setStudent(student);
			mark.setSubject(subject);
			mark.setCat1(rs.getInt("cat1"));
			mark.setCat2(rs.getInt("cat2"));
			mark.setCat3(rs.getInt("cat3"));
			mark.setInternal(rs.getInt("internal"));
			return mark;

		});

		return list;
	}

	public StudentMark findById(Integer id) {
		String sql = "select id,student_id,subject_id,cat1,cat2,cat3,internal from  student_mark_details where id=?";
		Object[] args = { id };
		StudentMark list = jdbcTemplate.queryForObject(sql, args, (rs, rowNo) -> {
			Student student = new Student();
			Subject subject = new Subject();
			student.setId(rs.getInt("student_id"));
			subject.setId(rs.getInt("subject_id"));
			StudentMark mark = new StudentMark();
			mark.setId(rs.getInt("id"));
			mark.setStudent(student);
			mark.setSubject(subject);
			mark.setCat1(rs.getInt("cat1"));
			mark.setCat2(rs.getInt("cat2"));
			mark.setCat3(rs.getInt("cat3"));
			mark.setInternal(rs.getInt("internal"));
			return mark;

		});

		return list;
	}
}
