package com.studentmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManagement {
	
	private final String INSERT_STUDENT = "insert into students(Id, firstname, lastname, gender, age, course) values(?,?,?,?,?,?)";
	private final String DELETE_STUDENT_BY_ID = "delete from students where id = ?";
	private final String SELECT_ALL_STUDENT = "select * from students";
	private final String UPDATE_QUERY = "update students set firstname=?, lastname=?, gender=?, age=?, course=? where Id = ?";
	private ConnectionDB connectionDB;
	private Connection conn;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	public DBManagement() throws ClassNotFoundException, SQLException {
		if(connectionDB == null) {
			connectionDB = ConnectionDB.createConnection();
		}
		if(conn == null)
		conn = connectionDB.getConnection();
	}
	
	
	public int add(int Id, String firstname, String lastname, String gender, int age, String course) throws SQLException {
			
			
			//Add Student
			Connection conn = connectionDB.getConnection();
			PreparedStatement pStatement = conn.prepareStatement(INSERT_STUDENT);
			pStatement.setInt(1, Id);
			pStatement.setString(2, firstname);
			pStatement.setString(3, lastname);
			pStatement.setString(4, gender);
			pStatement.setInt(5, age);
			pStatement.setString(6, course);
			int result = pStatement.executeUpdate();
			pStatement.close();
			if(result > 0) return result;
			
		
		
			return -1;
		
	}
	
	public int delete(int Id) throws SQLException {
		pStatement = conn.prepareStatement(DELETE_STUDENT_BY_ID);
		pStatement.setInt(1, Id);
		int result = pStatement.executeUpdate();
		if(result >0)return result;
		return -1;
	}
	
	
	public List<Student> show() throws SQLException {
		pStatement = conn.prepareStatement(SELECT_ALL_STUDENT);
		resultSet = pStatement.executeQuery();
		List<Student> students = new ArrayList<>();
		while(resultSet.next()) {
			Student s = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
			students.add(s);
		}
		return students;
	}
	
	public int update(int Id, Student student) throws SQLException {
		pStatement = conn.prepareStatement(UPDATE_QUERY);
		
		pStatement.setString(1, student.getFirstname());
		pStatement.setString(2, student.getLastname());
		pStatement.setString(3, student.getGender());
		pStatement.setInt(4, student.getAge());
		pStatement.setString(5, student.getCourse());
		pStatement.setInt(6, Id);
		int result = pStatement.executeUpdate();
		if(result > 0)return result;
		return -1;
	}

}
