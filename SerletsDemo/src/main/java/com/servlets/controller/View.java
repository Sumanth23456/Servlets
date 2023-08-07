package com.servlets.controller;
import com.servlets.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.servlets.domain.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class View extends HttpServlet {
 public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	 PrintWriter out=response.getWriter();
	 StudentDAO dao=new DAOImpl();
	 List<Student> ls=dao.viewAllStudents();
	 Iterator<Student> it=ls.iterator();
	 while(it.hasNext()) {
		 Student student = it.next(); 
         System.out.println(student.getSid());
         System.out.println(student.getSname());
         System.out.println(student.getMarks());
         System.out.println(student.getCity());
	 }
	 RequestDispatcher rd=request.getRequestDispatcher("ViewAll.jsp");
	 request.setAttribute("view1", ls);
 }
}
