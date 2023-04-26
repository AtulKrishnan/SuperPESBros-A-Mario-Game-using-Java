package PESMario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.sql.*; 

public class Leaderboard {
	public static Rectangle backButton = new Rectangle(500, 15, 60, 30);
    
	public static void render3(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 45);
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		Font fnt2 = new Font("arial", Font.BOLD, 15);
		
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Super PES Bros", 120, 40);
		
		g.setFont(fnt1);
		g.setColor(Color.white);
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
			ResultSet rs = stmt.executeQuery("Select * from Leaderboard ORDER BY PointsCollected DESC LIMIT 10;"); 
		 
			// Loop through the results and display them in the console 
			int yAxis = 120;
			
			g.drawString("Name", 19, 90);
			g.drawString("Points", 300, 90);
			
			while (rs.next()) { 
				
				String Name = rs.getString("Name");
				//int Coins = rs.getInt("CoinsCollected"); 
				int Points = rs.getInt("PointsCollected"); 
				
				g.drawString(Name, 19, yAxis);
				//g.drawString(String.valueOf(Coins), 200, yAxis);
				g.drawString(String.valueOf(Points), 300, yAxis);
				yAxis = yAxis + 30;
			} 

			g.setFont(fnt2);
			g.drawString("Back", backButton.x + 10, backButton.y + 20);
			g2d.draw(backButton);

			// Close the database resources 
			rs.close(); 
			stmt.close(); 
			conn.close(); 
		}
		catch (Exception e) { 
		     e.printStackTrace(); 
		} 
	}
}