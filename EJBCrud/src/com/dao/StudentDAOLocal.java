package com.dao;

import com.model.Student;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StudentDAOLocal {

	void addStudent(Student student);

	void editStudent(Student student);

	void deleteStudent(int studentId);

	Student getStudent(int studentId);

	List<Student> getAllStudents();

}