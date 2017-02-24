package com.senthamil.catapp.controller;

import com.senthamil.catapp.dao.StudentDAO;
import com.senthamil.catapp.model.Student;

public class TestStudentDAO {

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(1);
		student.setName("arun");
		StudentDAO dao = new StudentDAO();
		Student validate = dao.validate(student);
		if (validate == null) {
			System.out.println("invalid user");
		} else
			System.out.println(validate);
	}

}
