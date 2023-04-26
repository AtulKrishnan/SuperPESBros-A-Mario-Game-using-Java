package PESMario;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*; 
import java.awt.Font;
import java.awt.Graphics;

class BgPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image bg = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/login.png").getImage();
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}

class LoginPanel extends JPanel implements ActionListener{
	/**s
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel username, password, message;
	JTextField username_text;
	JPasswordField password_text;
	JButton submit;
	public static String userName;
	public Frame superFrame;
	
	LoginPanel() {
	    setOpaque(false);
	    setLayout(new FlowLayout(FlowLayout.LEFT, 140, 100));
	    
	    username = new JLabel("Username: ");
	    username.setForeground(Color.white);
	    Font fnt2 = new Font("arial", Font.BOLD, 20);
	    username.setFont(fnt2);
	    add(username); 
	    
	    username_text = new JTextField(10);
	    //label2.setForeground(Color.white);
	    add(username_text);
	    
	    password = new JLabel("Password: ");
	    password.setForeground(Color.white);
	    password.setFont(fnt2);
	    add(password); 
	    
	    password_text = new JPasswordField(10);
	    //label4.setForeground(Color.white);
	    add(password_text);
	    
	    message = new JLabel();
	    submit = new JButton("SUBMIT");
	    add(submit, message);
	    submit.addActionListener(this);
	}
	    
	public void actionPerformed(ActionEvent ae) {
		
		userName = username_text.getText();
	    String password = password_text.getText();
	    String pass = "admin";
		
		  try { 
 	         // Load the MySQL JDBC driver 
 	         //Class.forName("com.mysql.jdbc.Driver"); 
 	 
 	         // Establish a connection to the database 
			 String url = "jdbc:mysql://localhost:3306/superpesbros"; 
			 String username = "root"; 
			 String password1 = "root"; 
			 Connection conn = DriverManager.getConnection(url, username, password1); 
 	         // Create a statement object 
 	         Statement stmt = conn.createStatement(); 
 	 
 	         // Execute a query and get the results
 	         String query = "select * from USER where username = \"" + userName + "\""; 
 	         ResultSet rs = stmt.executeQuery( query); 
 	 
 	         // Loop through the results and display them in the console 
 	         while (rs.next()) { 
 	            pass = rs.getString("password");
 	         } 
 	         
 	         // Close the database resources 
 	         rs.close(); 
 	         stmt.close(); 
 	         conn.close(); 
 	      } catch (Exception e) { 
 	         e.printStackTrace(); 
 	      } 
		

	    
	    if (password.trim().equals(pass)) {    
	    	
	    	JFrame frame = new JFrame("Super PES Bros");                     //Create JFrame called frame
	    	frame.getContentPane().add(new board());                       //Go to board class
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                //Make frame close on X click
	    	frame.setSize(600,413);                                                              //Set the frame size to the size of the background
	    	frame.setResizable(false);                                                           //Make sure the user can't resize the frame
	    	frame.setLocation(20, 50);                                                           //Place the frame in a nicer position
	    	frame.setVisible(true);                                                              //Make the frame visible
	    	superFrame.setVisible(false);
	    	
	    	int frameWidth  = frame.getContentPane().getWidth();
	    	int frameHeight  = frame.getContentPane().getHeight();
	    } 
	    else {
	    	//Else Message
	    	message.setText(" Invalid User ");
	    }
	}
}

public class frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		
		frame t = new frame();
		JPanel bgPanel = new BgPanel();
		bgPanel.setLayout(new BorderLayout());
		LoginPanel lp = new LoginPanel();
		lp.superFrame = t;
		bgPanel.add(lp, BorderLayout.CENTER);

		t.setContentPane(bgPanel);
		t.setDefaultCloseOperation(EXIT_ON_CLOSE);
		t.setSize(600, 413);
		t.setVisible(true);
	}
}