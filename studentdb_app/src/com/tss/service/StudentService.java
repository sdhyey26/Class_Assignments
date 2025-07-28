package com.tss.service;

import java.util.List;

import com.tss.dao.StudentDao;
import com.tss.model.Student;

public class StudentService {
	private StudentDao studentDao;

	public StudentService() {
		super();
		this.studentDao = new StudentDao();
	}
	
	public List<Student> readAllStudent()
	{
		return studentDao.readAllStudents();
	}
	
	public void addNewStudent(Student student) {
        if (student.getAge() < 18) {
            System.out.println("Age must be greater than 18");
            return;
        }
        if (student.getPercentage() < 0) {
            System.out.println("Age must be greater than 18");
            return;
        }
        
        studentDao.addNewStudent(student);
    }
	
	public Student readStudentById(int id) {
	    return studentDao.readStudentById(id);
	}

	public boolean updatePercentageById(int id, double newPercentage) {
	    return studentDao.updatePercentageById(id, newPercentage);
	}
	
	public boolean deleteStudentById(int id) {
	    return studentDao.deleteStudentById(id);
	}
}