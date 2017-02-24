package com.senthamil.catapp.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.model.Subject;
import com.senthamil.catapp.util.ConnectionUtil;

public class SubjectDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();
	public List<Subject> listOfSubjects()
	{
		String sql="select id,name from subjects";
		List<Subject> subjects=jdbcTemplate.query(sql, (rs,rowNo)->
		{
			Subject subject=new Subject();
			subject.setId(rs.getInt("id"));
			subject.setName(rs.getString("name"));
			return subject;
		});
		return subjects;
	}

}
