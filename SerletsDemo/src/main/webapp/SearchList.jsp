<%@ page import="java.util.*"%>
<%@ page import="com.servlets.domain.Student"%>
<html>
<body>
<h1>Student Details</h1>
<p>
<%
	Student std = (Student)request.getAttribute("list");
	out.print(std.getSid());
	out.print(std.getSname());
	out.print(std.getMarks());
	out.print(std.getCity());
%>
</body>
</html>