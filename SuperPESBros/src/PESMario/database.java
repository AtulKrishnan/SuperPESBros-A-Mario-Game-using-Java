package PESMario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {
	public static void Insert(int points) {
		try { 
			// Load the MySQL JDBC driver 
			//Class.forName("com.mysql.jdbc.Driver"); 
		 
			// Establish a connection to the database 
			String url = "jdbc:mysql://localhost:3306/superpesbros"; 
			String username = "root"; 
			String password = "root"; 
			Connection conn = DriverManager.getConnection(url, username, password); 
		 
			// Create a statement object 
			Statement stmt = conn.createStatement(); 
		 
			// Execute a query and get the results 
			String query = "Insert into Leaderboard values (\"" + LoginPanel.userName + "\", " + points + ")";
			stmt.executeUpdate(query); 

			// Close the database resources 
			//rs.close(); 
			stmt.close(); 
			conn.close(); 
		}
		catch (Exception e) { 
		     e.printStackTrace(); 
		} 
	}
}
