<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.servlets.domain.Student"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Students</title>
</head>
<body>
    <h1>All Students</h1>
    <div>
        <%
            List<Student> students = (List<Student>) request.getAttribute("view1");
            if (students != null && !students.isEmpty()) {
                for (Student student : students) {
        %>
        <div>
            <p><strong>Student ID:</strong> <%= student.getSid() %></p>
            <p><strong>Name:</strong> <%= student.getSname() %></p>
            <p><strong>Marks:</strong> <%= student.getMarks() %></p>
            <p><strong>City:</strong> <%= student.getCity() %></p>
        </div>
        <%
                }
            } else {
        %>
        <p>No students found.</p>
        <%
            }
        %>
    </div>
</body>
</html>
