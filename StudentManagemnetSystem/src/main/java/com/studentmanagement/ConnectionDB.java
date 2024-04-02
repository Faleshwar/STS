package com.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	private static final ConnectionDB ConnectionDB = null;
	private final String DB_URL = "com.mysql.cj.jdbc.Driver";
	private final String username = "root";
	private final String password = "root";
	private static Connection conn = null;
	public static ConnectionDB CONN = null;
	private final String url = "jdbc:mysql://localhost:3306/students_db";
	
	private ConnectionDB() throws SQLException, ClassNotFoundException {
		
		if(conn == null) {
			Class.forName(DB_URL);
			conn = DriverManager.getConnection(url,username, password);
		}
	}
	
	
	public static ConnectionDB createConnection() throws SQLException, ClassNotFoundException{
		if(CONN == null) {
			return new ConnectionDB();
		}
		
		return ConnectionDB;
	}
	
	
	public Connection getConnection() {
		return conn;
	}

}
