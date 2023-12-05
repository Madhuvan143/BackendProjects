package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.model.Student;

public class StudentService {
	private StudentDao studentDAO = new StudentDao();

	public void addStudent(String name, int age) {
		Student student = new Student(0, name, age);
		studentDAO.addStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	public void updateStudent(int id, String name, int age) {
		Student student = new Student(id, name, age);
		studentDAO.updateStudent(student);
	}

	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
	}
}
