package com.training.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection getDerbyConnection() {
		
		Connection derbyConnection = null;
		
		//
		try {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			
			String derbyURL = "jdbc:derby:SampleDB;create=true";
			
			derbyConnection = DriverManager.getConnection(derbyURL);
			
			if (derbyConnection != null) {
				System.out.println("Connection Established");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return derbyConnection;
	}
}