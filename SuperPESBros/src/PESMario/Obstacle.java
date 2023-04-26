package PESMario;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Obstacle
{
	//public static Rectangle hitBox;
	Rectangle getHitBox(Obstacle Box);
	void draw(Graphics2D g2d);
	int set(int cameraX);
}
