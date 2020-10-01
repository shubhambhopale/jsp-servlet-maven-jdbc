package com.codeyogi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.codeyogi.model.Student;

public class StudentDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/shubham";
	private String user = "root";
	private String password = "root@123";
	
	public Student getStudent(int studentId) {
		Student s = new Student();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from student where id="+studentId);
			
			if(rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setCourse(rs.getString(3));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
}
