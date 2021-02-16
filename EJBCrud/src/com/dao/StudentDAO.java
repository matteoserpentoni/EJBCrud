package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.model.Student;

@Stateless
public class StudentDAO implements StudentDAOLocal {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addStudent(Student student) {
		em.merge(student);
		em.flush();
	}

	@Override
	public void editStudent(Student student) {
		em.merge(student);
		em.flush();
	}

	@Override
	public void deleteStudent(int studentId) {

		em.remove(getStudent(studentId));
		em.flush();
	}

	@Override
	public Student getStudent(int studentId) {
		em.flush();
		return em.find(Student.class, studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		em.flush();
		return em.createNamedQuery("Student.getAll").getResultList();
	}

}