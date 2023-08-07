package com.servlets.dao;

import java.util.List;

import com.servlets.domain.Student;

public interface StudentDAO {
  public boolean addStudent(Student std);
  public boolean deleteStudent(int sid);
  public boolean updateStudent(Student std);
  public Student searchById(int sid);
  public List<Student> viewAllStudents();
}
