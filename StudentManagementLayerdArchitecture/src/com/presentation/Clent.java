package com.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.model.Student;
import com.service.StudentService;

public class Clent {
	private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. View Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        listStudents();
                        break;

                    case 3:
                        viewStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Consume invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();  // Consume input
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        // Validate name input
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        try {
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Validate age input
            if (age < 0 || age > 150) {
                System.out.println("Invalid age. Please enter a valid age.");
                return;
            }

            studentService.addStudent(name, age);
            System.out.println("Student added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for age. Please enter a valid number.");
            scanner.nextLine();  // Consume invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();  // Consume input
        }
    }

    private static void listStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                System.out.println("Student List:");
                for (Student student : students) {
                    System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Age: " + student.getAge());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();  // Consume input
        }
    }

    private static void viewStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Student student = studentService.getStudentById(id);
            if (student != null) {
                System.out.println("Student ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
            } else {
                System.out.println("Student not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for ID. Please enter a valid number.");
            scanner.nextLine();  // Consume invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();  // Consume input
        }
    }

    private static void updateStudent() {
        try {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Student existingStudent = studentService.getStudentById(id);
            if (existingStudent == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine();

            // Validate name input
            if (newName.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter new student age: ");
            int newAge = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            // Validate age input
            if (newAge < 0 || newAge > 150) {
                System.out.println("Invalid age. Please enter a valid age.");
                return;
            }

            studentService.updateStudent(id, newName, newAge);
            System.out.println("Student updated successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for ID or age. Please enter valid numbers.");
            scanner.nextLine();  // Consume invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();  // Consume input
        }
    }

    private static void deleteStudent() {
        try {
            System.out.print("Enter student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            studentService.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for ID. Please enter a valid number.");
            scanner.nextLine();  // Consume invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();  // Consume input
        }
    }
}
