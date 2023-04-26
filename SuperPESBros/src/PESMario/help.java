package PESMario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class help {
	public static Rectangle backButton = new Rectangle(500, 15, 60, 30);
    
	public static void render2(Graphics g) {
    	Graphics2D g2d = (Graphics2D) g;                                             //casts 2d graphics(or however you would explain it)
    	
    	Font fnt0 = new Font("arial", Font.BOLD, 30);
    	Font fnt1 = new Font("arial", Font.BOLD, 15);
    	Font fnt2 = new Font("arial", Font.BOLD, 25);
    	
    	g.setFont(fnt0);
    	g.setColor(Color.white);
    	g.drawString("Welcome to the help section !", 10, 40);
    	g.setFont(fnt2);
    	g.drawString("Here is how to play our game", 10, 90);
    	
    	g.setFont(fnt1);
    	g.drawString("Welcome to Super PES Bros!", 10, 130);
    	g.drawString("To play this game, the only controls available to you are the arrow keys .", 10, 150);
    	g.drawString("You can jump up , go forward , go backwards and go down ", 10, 170);
    	g.drawString("Your goal is to select a character, cross the obstacle course and travel across", 10, 190);
    	g.drawString("the map to reach the boys hostel. This is when you have successfully ", 10, 210);
    	g.drawString("finished the game !! ", 10, 230);
    	g.drawString("You also have to sneak past the bouncers and sprint across the campus xD ", 10, 290);
    	g.drawString("Don't forget to have fun !! ", 10, 310);
    	
    	g.drawString("Back", backButton.x + 10, backButton.y + 20);
    	g2d.draw(backButton);
    }
}