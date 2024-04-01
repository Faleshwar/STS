package com.studentmanagement;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	int Id;
    	String firstname;
    	String lastname;
    	String gender;
    	int age;
    	String course;
    	
    	@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
    	StudentManagement studentManagement = new StudentManagement();
    	
    	
    	while(true) {
    		System.out.println("Enter your choice");
    		System.out.println("1. Add Student");
        	System.out.println("2. Show Students");
        	System.out.println("3. Update Student");
        	System.out.println("4. Delete Student");
        	System.out.println("5. Exit");
        	int choice = scanner.nextInt();
        
        	
        	switch (choice) {
    		case 1:
    			System.out.println("Enter student Id:");
    			Id = scanner.nextInt();
    			System.out.println("Enter student firstname");
    			firstname = scanner.next();
    			System.out.println("Enter student lastname");
    			lastname = scanner.next();
    			System.out.println("Enter student gender");
    			gender = scanner.next();
    			System.out.println("Enter student age");
    			age = scanner.nextInt();
    			System.out.println("Enter student course");
    			course = scanner.next();
    			Student student = new Student(Id, firstname, lastname, gender, age, course);
    			studentManagement.AddStudent(student);
    			break;
    		case 2:
    			studentManagement.showStudents();
    			break;
    		case 3:
    			System.out.println("Enter Id to update student");
    			Id = scanner.nextInt();
    			System.out.println("Enter student firstname");
    			firstname = scanner.next();
    			System.out.println("Enter student lastname");
    			lastname = scanner.next();
    			System.out.println("Enter student gender");
    			gender = scanner.next();
    			System.out.println("Enter student age");
    			age = scanner.nextInt();
    			System.out.println("Enter student course");
    			course = scanner.next();
    			studentManagement.updateStudent(new Student(Id, firstname, lastname, gender, age, course), Id);
    			break;
    		case 4:
    			System.out.println("Enter id to delete student...");
    			Id = scanner.nextInt();
    			studentManagement.deleteById(Id);
    			break;
    		case 5:
    			System.exit(1);
    			break;

    		default:
    			break;
    		}
    	}
    	
       
    }
}
