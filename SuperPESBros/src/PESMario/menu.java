package PESMario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class menu {
	public static Rectangle playButton = new Rectangle(15, 75, 80, 37);
    public static Rectangle chooseButton = new Rectangle(15, 127, 210, 37);
    public static Rectangle scoreButton = new Rectangle(15, 179, 140, 37);
    public static Rectangle helpButton = new Rectangle(15, 231, 80, 37);
    public static Rectangle quitButton = new Rectangle(15, 283, 80, 37);

    public static void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        Font fnt2 = new Font("arial", Font.BOLD, 20);
        
        g.setFont(fnt1);
        g.setColor(Color.white);
        g.drawString("Super PES Bros", 10, 40);

        g.setFont(fnt2);
        g.drawString("Play", playButton.x + 19, playButton.y + 29);
        g2d.draw(playButton);
        
        g.drawString("Help", helpButton.x + 19, helpButton.y + 29);
        g2d.draw(helpButton);
        
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 29);
        g2d.draw(quitButton);
        
        g.drawString("Choose Character", chooseButton.x + 19, chooseButton.y + 29);
        g2d.draw(chooseButton);
        
        g.drawString("Scorecard", scoreButton.x + 19, scoreButton.y + 29);
        g2d.draw(scoreButton);
    
        g.setFont(fnt2);
        g.drawString("Version 0.0.2",460,370);
    }
}