package com.servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.servlets.domain.Student;

public class DAOImpl implements StudentDAO{
 
	Connection con=null;

    public DAOImpl() {

        

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlabs","root","Sumanth1123*");

        }

        catch(Exception e) {

            System.out.println(e);

        }
    }

	@Override
	public boolean addStudent(Student std) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
					ps.setInt(1, std.getSid());
			        ps.setString(2, std.getSname());
			        ps.setInt(3, std.getMarks());
			        ps.setString(4, std.getCity());
			        int a=ps.executeUpdate();
			        if(a>0) {
			        	b=true;
			        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean deleteStudent(int sid) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("delete from student where sid=?");
					ps.setInt(1, sid);
					int c=ps.executeUpdate();
					if(c>0) {
						b=true;
					}}
		catch(Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean updateStudent(Student std) {
		boolean b=false;
		try {
			PreparedStatement ps=con.prepareStatement("Update student set sname=?,marks=?,city=? where sid=?");
			ps.setInt(4, std.getSid());
			ps.setString(1, std.getSname());
			ps.setInt(2, std.getMarks());
			ps.setString(3, std.getCity());
			int c=ps.executeUpdate();
			if(c>0) {
				b=true;
			}}
			catch(Exception e) {
				System.out.println(e);
			}
			
		return b;
	}

	@Override
	public Student searchById(int sid) {
		 Student std=new Student();
		try {
			PreparedStatement ps=con.prepareStatement("select * from student where sid=?");
			ps.setInt(1, sid);
			ResultSet rs=ps.executeQuery();
		  if(rs.next()) {
			 
			  std.setSid(rs.getInt("sid"));
			  std.setSname(rs.getString("sname"));
			  std.setMarks(rs.getInt("marks"));
			  std.setCity(rs.getString("city"));
		  }
		  
	}
		catch(Exception e) {
			System.out.println(e);
		}
	return std;	
}

	@Override
	public List<Student> viewAllStudents() {
		List<Student> ls=new ArrayList<>();
			try {
				PreparedStatement ps=con.prepareStatement("select * from student");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Student std=new Student();
					std.setSid(rs.getInt("sid"));
					std.setSname(rs.getString("sname"));
					std.setMarks(rs.getInt("marks"));
					std.setCity(rs.getString("city"));
					ls.add(std);
				}
			
	}
			catch(Exception e) {
				System.out.println(e);
			}
			return ls;
}
}