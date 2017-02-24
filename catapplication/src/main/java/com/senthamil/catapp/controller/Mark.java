package com.senthamil.catapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senthamil.catapp.dao.StudentDAO;
import com.senthamil.catapp.model.Student;

@WebServlet("/Mark")
public class Mark extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentName = request.getParameter("student_name");
		String studentId = request.getParameter("student_id");
//		System.out.println(studentName);
//		System.out.println(studentId);
		Student student = new Student();
		student.setId(Integer.valueOf(studentId));
		student.setName(studentName);
		System.out.println(student);
        StudentDAO dao=new StudentDAO();
        Student stu=dao.validate(student);
        PrintWriter printWriter=response.getWriter();
        if(stu==null)
        	printWriter.print("invalid user");
      
        else
        	printWriter.println("welcome "+studentName);
	}

}
