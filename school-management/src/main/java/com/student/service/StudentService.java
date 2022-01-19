package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student getStudentById(int id);
	
	public Student update(Student student);
	
	public void delete(int id);

}
