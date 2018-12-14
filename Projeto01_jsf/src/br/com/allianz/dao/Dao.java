package br.com.allianz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//import com.mysql.jdbc.PreparedStatement;


public class Dao {

	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	protected void openConnection () throws Exception{
//		Class.forName("com.mysql.jdbc.Driver");
//		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dblivros", "root", "p@ssword");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		cn = DriverManager.getConnection("jdbc:odbc:javadb", "", "");		
	}
	
	protected void closeConnection() throws Exception {
		if (cn!=null && !cn.isClosed()) {
			cn.close();
		}
	}
	
}