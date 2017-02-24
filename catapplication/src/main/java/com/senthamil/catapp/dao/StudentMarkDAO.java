package com.senthamil.catapp.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.senthamil.catapp.util.ConnectionUtil;

public class StudentMarkDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getjdbcTemplate();
	
}
