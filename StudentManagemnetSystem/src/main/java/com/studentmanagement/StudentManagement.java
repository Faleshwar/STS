package com.studentmanagement;

import java.sql.SQLException;
import java.util.List;

public class StudentManagement {
	
 private DBManagement dbManagement = null;
 
 	public StudentManagement() throws ClassNotFoundException, SQLException {
 		if(dbManagement == null) {
 			dbManagement = new DBManagement();
 		}
 		
 	}
 	
 	public void AddStudent(Student student) throws SQLException {
 	 int result =	dbManagement.add(student.getId(), student.getFirstname(), student.getLastname(), student.getGender(), student.getAge(), student.getCourse());
 		if(result > 0) {
 			System.out.println("Student Added successfully...");
 		}
 	}
 	
 	public void showStudents() throws SQLException {
 		List<Student> list = dbManagement.show();
 		for(Student st: list) {
 			System.out.println(st.getId()+" "+st.getFirstname()+" "+st.getLastname()+" "+st.getGender()+" "+st.getAge()+" "+st.getCourse());
 			System.out.println();
 		}
 	}
 	
 	public void deleteById(int Id) throws SQLException {
 		int result = dbManagement.delete(Id);
 		if(result == 0) {
 			System.out.println("Student Deleted Successfully");
 		}
 		else {
			System.out.println("Failed");
		}
 		
 		
 	}
 	
 	public void updateStudent(Student student, int Id) throws SQLException {
 		int result = dbManagement.update(Id, student);
 		if(result ==0)System.out.println("Failed");
 		System.out.println("Updated student successfully");
 	}

}
