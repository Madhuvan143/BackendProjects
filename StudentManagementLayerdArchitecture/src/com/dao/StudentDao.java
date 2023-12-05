package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentDao {
	private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                return;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
