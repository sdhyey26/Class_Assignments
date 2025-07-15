package com.tss.test;

import com.tss.model.StudentService;

public class Student {

    private StudentService studentService;

    public Student(StudentService studentService) {
        this.studentService = studentService;
    }

    public int calculateAverage() {
        return studentService.getFinalMarks() / studentService.getNumberOfSubjects();
    }
}
