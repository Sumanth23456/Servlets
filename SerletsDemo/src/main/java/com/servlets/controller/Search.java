package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlets.dao.DAOImpl;
import com.servlets.dao.StudentDAO;
import com.servlets.domain.Student;

public class Search extends HttpServlet{
  public void service(HttpServletRequest request,HttpServletResponse response) 
		  throws IOException, ServletException {
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
	  view.forward(request, response);
  }
}
