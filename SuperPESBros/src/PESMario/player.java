package PESMario;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class player {
	static int x, dx, y, dy, nx, nx2, distanceTraveled;                                                     //x coordinate,change in x coordinate,y coordinate,1st rep bg,2nd rep bg,dist traveled
    Image player;                                                                                //The player variable
    Rectangle hitBox;
    static int oldCameraX = 0;
    static int flag = 1;
    boolean keyUp, keyLeft, keyRight;
    public ImageIcon playerFacingLeft = new     ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/Left_CaptainAtharva.png");  //Image for player while he is turning left
    public ImageIcon playerFacingRight = new     ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/Right_CaptainAtharva.png");//Image for player while he is turning right
    
    // public ImageIcon playerFacingLeft;
    // public ImageIcon playerFacingRight;
    
    //Create an object of SingleObject
    //Singleton Pattern
    Rectangle Temp;
  	private static player instance = new player();
    
    private player() {
		player = playerFacingRight.getImage();                                               //Give the player the image
		x = 75;                                                                              //The original x position of the player
		y = 335;                                                                             //The original y position of the player
		nx = -0;                                                                             //Repeating background 1
		nx2 = -575;                                                                          //Repeating background 2
		distanceTraveled = 24;
		hitBox = new Rectangle(x, y, 30, 40);
    }
    
    //Get the only object available
    //Singleton Pattern
  	public static player getInstance()
  	{
  		return instance;
  	}
        
    public void CharacterChoice() {
    	playerFacingLeft = new ImageIcon(board.strPlayerFacingLeft);
        playerFacingRight = new ImageIcon(board.strPlayerFacingRight);
        player = playerFacingRight.getImage(); 
    }

    public void move() {
    	
    	if(keyLeft && keyRight || !keyLeft && !keyRight)
    		dx *= 0.8;
    	else if(keyLeft && !keyRight)
    		dx = dx - 1;
    	else if(keyRight && !keyLeft)
    		dx = dx + 1;
    	
    	if(dx > 0 && dx < 0.75)
    		dx = 0;
    	if(dx < 0 && dx > -0.75)
    		dx = 0;
    	
    	if(dx > 5)
    		dx = 5;
    	if(dx < -5)
    		dx = -5;
    	
    	if(x>10 && board.cameraX<5000) {                                                                   //If the player is within the moving area                                                                      //The x position is updated to become itself+the amount you moved
    		if(oldCameraX != board.cameraX) {
    			nx = nx+dx;                                                                      //Place the repeating background at regular speed
    			nx2 = nx2+dx;                                                                    //Place the repeating background at regular speed
    		}
            oldCameraX = board.cameraX;
    	}
        if(board.cameraX<=0) {                                                                           //If the player has reached he very left side of the screen(0px)
        	board.cameraX=5;                                                                             //Move him up a pixel so he can move again
            //nx = nx+(dx*(int)0.5);                                                           //Place the background at a slower speed since Mario stops moving
            //nx2 = nx2+(dx*(int)0.5);                                                         //Place the background at a slower speed since Mario stops moving
        }
        if(dx>0)
        	distanceTraveled++;
        else if(dx<0)
        	distanceTraveled--;
        if(board.cameraX==1 && dx<0)
            distanceTraveled++;
        if(distanceTraveled<50){
            nx=0;
            nx2=-575;
        }
    	
    	if(keyUp) {
    		hitBox.y ++;
    		for(Obstacle wall: board.walls) {
    			Temp = wall.getHitBox(wall);
    			if(Temp.intersects(hitBox))
    				dy = -15;
    		}
    		hitBox.y --;
    		//dy = -6;
    	}
    	
    	if(y < 355) {
    		dy += 1;
    	}
    	
       	//Horizontal Collision
    	hitBox.x += dx;
    	for(Obstacle wall: board.walls) {
    		Temp = wall.getHitBox(wall);
    		if(hitBox.intersects(Temp)) {
    			hitBox.x -= dx;
    			while(!Temp.intersects(hitBox)) 
    				hitBox.x += Math.signum(dx);
    			hitBox.x -= Math.signum(dx);
    			board.cameraX += x - hitBox.x;
    			dx = 0;
    			hitBox.x = x;
    		}
    	}
    	
    	//Vertical Collision
    	hitBox.y += dy;
    	for(Obstacle wall: board.walls) {
    		Temp = wall.getHitBox(wall);
    		if(hitBox.intersects(Temp)) {
    			hitBox.y -= dy;
    			while(!Temp.intersects(hitBox)) 
    				hitBox.y += Math.signum(dy);
    			hitBox.y -= Math.signum(dy);
    			dy = 0;
    			y = hitBox.y;
    		}
    	}
    	
    	//Horizontal Collision for Bouncers
    	hitBox.x += dx;
    	for(Obstacle bouncer: board.bouncers) {
    		Temp = bouncer.getHitBox(bouncer);
    		if(hitBox.intersects(Temp)) {
    			flag = 0;
    		}
    	}
    	
    	//Vertical Collision for Bouncers
    	hitBox.y += dy;
    	for(Obstacle bouncer: board.bouncers) {
    		Temp = bouncer.getHitBox(bouncer);
    		if(hitBox.intersects(Temp)) {
    			flag = 0;
    		}
    	}
    	
    	//x = x + dx;
    	board.cameraX = board.cameraX + dx;
    	y = y + dy;
    	
    	hitBox.x = x;
    	hitBox.y = y;
    	
    	//Death Code
    	if(y > 550)
    	{
    		flag = 0;
    	}
    	
    	//Victory Code
    	if(board.cameraX > 4800)
    	{
    		database.Insert(board.cameraX);
    		board.reset();
    		board.State = board.STATE.WIN;
    	}
    	
    	//Death Redirection Code
    	if(flag == 0) {
    		database.Insert(board.cameraX);
    		board.reset();
    		board.State = board.STATE.DEAD;
    	}
    }

    /*
    public void jump() {
    	if(y == 285) {
    		y = y + dy;
    		hitBox.y = hitBox.y;
    	}
    	//dy += 0.3;
    }*/

    public static void draw(Graphics2D g2d) {
    	g2d.setColor(Color.BLACK);
    	g2d.fillRect(x, y, 30, 40);
    }
    
    public static void Score(Graphics2D g2d) {
	    Font f = new Font("Arial", Font.BOLD, 40);
		g2d.setFont(f);
		g2d.drawString(Integer.toString(board.cameraX), 500, 40);
		//g2d.drawString(LoginPanel.userName, 500, 80);
    }
    
    public int   getX()     { return x;      }                                               //This method will return the x.      Is used by other classes
    public int   getY()     { return y;      }                                               //This method will return the y.      Is used by other classes
    public Image getImage() { return player; }                                               //This method will return the player. Is used by other classes

    public void keyPressed(KeyEvent e) {                                                     //Called from the board class, the argument is whatever key was pressed
        int key = e.getKeyCode();                                                            //The key originally sent from the board class

        if(key == KeyEvent.VK_LEFT) {                                                        //If the key sent was LEFT
            player = playerFacingLeft.getImage();                                            //Make the player face leftwards
            //if(distanceTraveled<104)dx=-3;else dx=-2;
            keyLeft = true;
        }

        if(key == KeyEvent.VK_RIGHT) {                                                       //If the key sent was RIGHT
            player = playerFacingRight.getImage();                                           //Make the player face rightwards
            //if(distanceTraveled<104)dx=3;else dx=2;
            keyRight = true;
        }
        
        if(key == KeyEvent.VK_UP) {                                                       //If the key sent was RIGHT
            keyUp = true;
        	//dy = -60;
        }
    }

    public void keyReleased(KeyEvent e) {                                                    //Called from the board class, the argument is whatever key was released
        int key = e.getKeyCode();                                                           //The key originally sent from the board class

        if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {                              //If the left or right key was released
            dx = 0;                                                                          //Stop moving
            keyLeft = false;
            keyRight = false;
        }
        if(key == KeyEvent.VK_UP)                              //If the left or right key was released
        {
        	keyUp = false;
        	//y = y - dy;
        	//dy = 0;
        } 
    }
}
