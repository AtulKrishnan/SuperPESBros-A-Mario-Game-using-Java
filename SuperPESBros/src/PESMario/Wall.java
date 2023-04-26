package PESMario;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Wall implements Obstacle{
	int x, y;
	int width, height;
	int startX;
	
	Image brick;
	
	Rectangle hitBox;
	
	public Wall(int x, int y, int width, int height) {
		this.x = x;
		startX = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		ImageIcon i = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/media/brick.jpg");                  //Image for menu
        brick = i.getImage();
		
		hitBox = new Rectangle(x, y, width, height);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x, y, width, height);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(x+1, y+1, width-2, height-2);
		g2d.drawImage(brick, x, y, null);
	}
	
	@Override
	public int set(int cameraX) {
		x = startX - cameraX;
		hitBox.x = x;
		
		return x;
	}
	
	@Override
	public Rectangle getHitBox(Obstacle Box) {
		return hitBox;
	}
}
