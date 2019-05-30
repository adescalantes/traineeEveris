package com.trainee.services;

import java.util.List;

import com.trainee.models.Student;

public interface IStudentService {
	
	public List<Student> getAll();
	
	public Student getById(int studentId);
	
	public Student post(Student student);
	
	public void putById(int studentId,Student student);
	
	public void delete(int studentId);
	
	public Student findOne(int studentId);
	
}
