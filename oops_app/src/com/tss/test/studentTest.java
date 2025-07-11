package com.tss.test;

import java.util.Scanner;

import com.tss.model.Student;

public class studentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println("Enter student 1 attributes : ");
		
		System.out.print("Enter student RollNumber : ");
		s1.setRollNumber(sc.nextInt());
		System.out.print("Enter student Name : ");
		s1.setName(sc.next());
		System.out.print("Enter student age : ");
		s1.setAge(sc.nextInt());
		System.out.print("Enter student Marks for sub1 : ");
		s1.setMarksSub1(sc.nextInt());
		System.out.print("Enter student Marks for sub2 : ");
		s1.setMarkSub2(sc.nextInt());
		System.out.print("Enter student Marks for sub3 : ");
		s1.setMarkSub3(sc.nextInt());
		
		System.out.println("Enter student 2 attributes : ");
		
		System.out.print("Enter student RollNumber : ");
		s2.setRollNumber(sc.nextInt());
		System.out.print("Enter student Name : ");
		s2.setName(sc.next());
		System.out.print("Enter student age : ");
		s2.setAge(sc.nextInt());
		System.out.print("Enter student Marks for sub1 : ");
		s2.setMarksSub1(sc.nextInt());
		System.out.print("Enter student Marks for sub2 : ");
		s2.setMarkSub2(sc.nextInt());
		System.out.print("Enter student Marks for sub3 : ");
		s2.setMarkSub3(sc.nextInt());
		
		int averageOfStudentOne = (s1.getMarksSub1() + s1.getMarkSub2() + s1.getMarkSub3())/3;
		int averageOfStudentTwo = (s2.getMarksSub1() + s2.getMarkSub2() + s2.getMarkSub3())/3;
		
		s1.display();
		s2.display();
		
		System.out.println();
		System.out.println("Average of marks of student one : " + averageOfStudentOne);
		System.out.println();
		System.out.println("Average of marks of student two : " + averageOfStudentTwo);

	}

}
