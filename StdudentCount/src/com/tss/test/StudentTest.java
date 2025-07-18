package com.tss.test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.tss.model.*;

public class StudentTest {
	public static void main(String[] args) {
		
		 	StudentModel s1 = new StudentModel("Alice", 1, 70);
	        StudentModel s2 = new StudentModel("Bob", 2, 70);
	        StudentModel s3 = new StudentModel("Charlie", 3, 70);
	        StudentModel s4 = new StudentModel("David", 4, 80);
	        StudentModel s5 = new StudentModel("Eva", 5, 88);
	        StudentModel s6 = new StudentModel("Frank", 6, 65);
	        StudentModel s7 = new StudentModel("Grace", 7, 55);
	        StudentModel s8 = new StudentModel("Hannah", 8, 40);
	        StudentModel s9 = new StudentModel("Ian", 9, 59);
	        StudentModel s10 = new StudentModel("Jane", 10, 64);
	        
	        List<StudentModel> students = new ArrayList<StudentModel>();
	        students.add(s1);
	        students.add(s2);
	        students.add(s3);
	        students.add(s4);
	        students.add(s5);
	        students.add(s6);
	        students.add(s7);
	        students.add(s8);
	        students.add(s9);
	        students.add(s10);
	        
	        Predicate<StudentModel> filter = (studentlist)->{
	        	
	        	if(studentlist.getMarks() >= 75) {
	        		return true;
	        	}
	        	else {
	        		return false;
	        	}
	        };
	        
	        Consumer<StudentModel> print = (detailsPrint)->{
	        	System.out.println("Congratulations " + detailsPrint.getName() + "!!!");
	        };
	        
	        for(StudentModel student : students ) {
	        	if(filter.test(student)) {
	        		print.accept(student);
	        	}
	        }
	}
}
