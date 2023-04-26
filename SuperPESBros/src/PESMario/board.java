package PESMario;

import java.awt.*;                                                                           //Imported to allow use of Image
import java.awt.event.*;                                                                     //Imported to allow use of ActionListener
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class board extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static player p;                                                                                //Instance of player class
	
	public static ArrayList<Obstacle> walls = new ArrayList<>();
	public static ArrayList<Obstacle> bouncers = new ArrayList<>();
	static ObstacleFactory obstacleFactory;
	
	Image background, menuBg, characterBg, gameOver, gameWon;                                                                //The background images
    Timer time;                                                                              //A timer
    java.util.Timer gameTimer;
    private menu Menu;
    private frame Frame;
    
    public static Rectangle backButton = new Rectangle(500, 15, 60, 30);
    
    static int cameraX;

    public static enum STATE {MENU,GAME,HELP,SCORE,Character,DEAD,WIN};

    public static STATE State = STATE.MENU;
    
    public static String strPlayerFacingLeft = null;
    public static String strPlayerFacingRight = null;

    public board() {
    	this.addMouseListener(new mouseInput());
           
        p = player.getInstance();                                                                    //Start running player class
        //Menu = new menu();
        audio.playAudio();
        
        obstacleFactory = new ObstacleFactory();
        
        makeWalls(-100);
        makeBouncers();

        addKeyListener(new AL());                                                            //Listen for keys
        setFocusable(true);                                                                                                                  //Allows movement         
        ImageIcon i = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/home.png");                  //Image for menu
        menuBg = i.getImage();
        i = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/FINAL_FINAL_MAP.png");  //Image for background
        background = i.getImage();                                                           //Give the background the image
        i = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/select_char.png");                  //Image for menu
        characterBg = i.getImage();
        i = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/died.png");                  //Image for menu
        gameOver = i.getImage();
        i = new ImageIcon("D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/win.png");                  //Image for menu
        gameWon = i.getImage();
        time = new Timer(20,this);                                                           //Timer set to update "this" class every 20 milliseconds(Approximately 50fps)
        time.start();                                                                        //Actually start the timer
        gameTimer = new java.util.Timer();
        gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				p.move();
				for(Obstacle wall: walls) wall.set(cameraX);
				for(Obstacle bouncer: bouncers) bouncer.set(cameraX);
				repaint();  
			}
        	
        }, 0, 17);
    }

public static void makeBouncers() {
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 400, 318, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 1000, 318, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 2250, 318, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 2650, 100, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 2800, 100, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 3100, 318, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 3550, 318, 15, 15));
	bouncers.add(obstacleFactory.getObstacle("Bouncer", 4450, 318, 15, 15));
}

public static void makeWalls(int offset) {
    	
    	int s = 20;
    	Random rand = new Random();
    	int index = rand.nextInt(1);
    	    	
		for(int i=0;i<5000;i+=20)
			if(i == 260) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				i = i + 60;
			}
			else if(i == 680) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				i = i + 80;
			}
			else if(i == 1100) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", i+100, 355, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", i+200, 355, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", i+300, 355, s, s));
				i = i + 400;
			}
			else if(i == 1680) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				i = i + 300;
			}
			else if(i == 2400) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", 2420, 270, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", 2480, 220, s, s));
				
				for(int j= 2600 ; j<3000 ; j+=20) {
					walls.add(obstacleFactory.getObstacle("Wall", j, 140, s, s));
				}
				i = i + 600;
			}
			else if(i == 3700) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", i+100, 270, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", i+200, 240, s, s));
				walls.add(obstacleFactory.getObstacle("Wall", i+300, 270, s, s));
				i = i + 400;
			}
			else if(i == 4200) {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
				i = i + 100;
			}
			else {
				walls.add(obstacleFactory.getObstacle("Wall", i, 355, s, s));
			}
		
		walls.add(obstacleFactory.getObstacle("Wall", 170, 295, 30, 30));
		walls.add(obstacleFactory.getObstacle("Wall", 170, 325, 30, 30));
		walls.add(obstacleFactory.getObstacle("Wall", 170, 265, 30, 30));
    	//walls.add(new Wall(130, 225, 30, 30));
		walls.add(obstacleFactory.getObstacle("Wall", 650, 325, 30, 30));	//triangle formation
		walls.add(obstacleFactory.getObstacle("Wall", 680, 295, 30, 30));	//triangle formation
		walls.add(obstacleFactory.getObstacle("Wall", 680, 325, 30, 30));
    	
		walls.add(obstacleFactory.getObstacle("Wall", 780, 325, 30, 30));
		walls.add(obstacleFactory.getObstacle("Wall", 810, 325, 30, 30));
		walls.add(obstacleFactory.getObstacle("Wall", 780, 295, 30, 30));	//Reverse Triangle
    	
		walls.add(obstacleFactory.getObstacle("Wall", 1740, 265, 30, 30));	//Canteen Timepass
		walls.add(obstacleFactory.getObstacle("Wall", 1880, 245, 30, 30));
    	
    }
    
    public static void reset() {
    	player.x = 75;
    	player.y = 335;
    	player.dx = 0;
    	player.dy = 0;
    	player.nx = -0;                                                                             //Repeating background 1
		player.nx2 = -575;                                                                          //Repeating background 2
		player.distanceTraveled = 24;
    	cameraX = 0;
    	player.flag = 1;
    	
    	strPlayerFacingLeft = null;
        strPlayerFacingRight = null;
    	
    	walls.clear();
    	
    	int offset = 50;
    	makeWalls(offset);
    }
    
    public void actionPerformed(ActionEvent e) {
        //p.move();                                                                            //Call the move method from the player class
        //repaint();                                                                           //Repaint
        //p.jump();                                                                            //Call the move method from the player class
        //repaint();                                                                           //Repaint
    }

    public void paintComponent(Graphics g) {                                                 //Graphics method
		if(State==STATE.GAME) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;                                             //casts 2d graphics(or however you would explain it)
	        player.draw(g2d);
	        g2d.drawImage(background, -p.nx, 0, null);                                   //Draw the background image
	        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);                      //Draw the player at the position he is currently(Coordinate values taken from player class)
	        player.Score(g2d);
	        //player.draw(g2d);
	        for(Obstacle wall: walls) wall.draw(g2d);
	        for(Obstacle bouncer: bouncers) bouncer.draw(g2d);
		}
		else if(State==STATE.HELP) {
		    super.paintComponent(g);
		    g.drawImage(menuBg, 0, 0, null);
		    help.render2(g);
		}
		else if(State==STATE.SCORE) {
			super.paintComponent(g);
		    g.drawImage(menuBg, 0, 0, null);
		    Leaderboard.render3(g);
		}
		else if(State==STATE.Character) {
			super.paintComponent(g);
		    g.drawImage(characterBg, 0, 0, null);
		}
		else if(State==STATE.DEAD) {
			super.paintComponent(g);
		    g.drawImage(gameOver, 0, 0, null);
		    
		    Font fnt1 = new Font("arial", Font.BOLD, 15);
		    g.setFont(fnt1);
		    g.setColor(Color.white);
		    g.drawString("Back", backButton.x + 10, backButton.y + 20);
		    Graphics2D g2d = (Graphics2D) g; 
		    g2d.draw(backButton);
		}
		else if(State==STATE.WIN) {
			super.paintComponent(g);
		    g.drawImage(gameWon, 0, 0, null);
		    
		    Font fnt1 = new Font("arial", Font.BOLD, 15);
		    g.setFont(fnt1);
		    g.setColor(Color.BLACK);
		    g.drawString("Back", backButton.x + 10, backButton.y + 20);
		    Graphics2D g2d = (Graphics2D) g; 
		    g2d.draw(backButton);
		}
		else {
	        g.drawImage(menuBg, 0, 0, null);
	        menu.render(g);
		}
    }

    private class AL extends KeyAdapter {                                                    //Action Listener extends key adapter
		public void keyPressed(KeyEvent e) {                                                 //On key press
	        p.keyPressed(e);                                                                 //Send whatever key was pressed  TO the keyPressed  method in the player class
		}
		public void keyReleased(KeyEvent e) {                                                //On key release
	        p.keyReleased(e);                                                                //Send whatever key was released TO the keyReleased method in the player class
		}
    }
}