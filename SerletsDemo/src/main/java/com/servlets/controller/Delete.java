package com.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import com.servlets.domain.*;
import com.servlets.dao.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
   public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
	   Student std=new Student();
	   PrintWriter out=response.getWriter();
	  int i =Integer.parseInt(request.getParameter("sid"));
	  
	  StudentDAO dao=new DAOImpl();
	  boolean b=dao.deleteStudent(i);
	  if(b) {
		  out.print("<h2>Success</h2>");
	  }
	  else {
		  out.print("<h2>Success</h2>");  
	  }
   }
}
