package com.servlets.controller;

import com.servlets.domain.*;
import com.servlets.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/reqAdd", "/reqDelete", "/reqUpdate","/reqSearch","/reqView"})
public class MyController extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String path=request.getServletPath();
		if(path.equals("/reqAdd")) {
			Student std=new Student();
			PrintWriter out= response.getWriter();
			std.setSid(Integer.parseInt(request.getParameter("sid")));
			std.setSname(request.getParameter("sname"));
			std.setMarks(Integer.parseInt(request.getParameter("marks")));
			std.setCity(request.getParameter("city"));
			StudentDAO dao=new DAOImpl();
			boolean b=dao.addStudent(std);
			if(b) {
				out.print("<h1>Success<h1>");
			}
			else {
				out.print("<h1>Failed<h1>");
			}
		}
		else if(path.equals("/reqDelete")) {
			Student std=new Student();
			   PrintWriter out=response.getWriter();
			  int i =Integer.parseInt(request.getParameter("sid"));
			  
			  StudentDAO dao=new DAOImpl();
			  boolean b=dao.deleteStudent(i);
			  if(b) {
				  out.print("<h2>Success</h2>");
			  }
			  else {
				  out.print("<h2>Failed</h2>");  
			  }
		}
		else if(path.equals("/reqUpdate")) {
			Student std=new Student();
			PrintWriter out=response.getWriter();
			std.setSid(Integer.parseInt(request.getParameter("sid")));
			std.setSname(request.getParameter("sname"));
			std.setMarks(Integer.parseInt(request.getParameter("marks")));
			std.setCity(request.getParameter("city"));
			StudentDAO dao=new DAOImpl();
			boolean c=dao.updateStudent(std);
			if(c) {
				out.print("<h2>Success</h2>");
			}
			else {
				out.print("<h2>Failed</h2>");}
		
		}
		else if(path.equals("/reqSearch")) {
			 PrintWriter out=response.getWriter();
			  Student std;
			 int i= Integer.parseInt(request.getParameter("sid"));
			  StudentDAO dao=new DAOImpl();
			  std=dao.searchById(i);
			  if(std!=null) {
				  System.out.println("Student Found");
				  System.out.println(std.getSid());
				  System.out.println(std.getSname());
				  System.out.println(std.getMarks());
				  System.out.println(std.getCity());
			  }
			  else {
				  System.out.println("Student Not Found");
			  }
			  RequestDispatcher view = request.getRequestDispatcher("SearchList.jsp");
			  request.setAttribute("list", std);
			  view.forward(request, response);}
		
	     else if(path.equals("/reqView")) {
	    	 
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
	    		 request.setAttribute("view1", ls);
	    		    RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
	    		    rd.forward(request, response);
	    	 }
	     }
		
		}
	
	

		
	

