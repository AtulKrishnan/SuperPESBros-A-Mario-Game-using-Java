package PESMario;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseInput implements MouseListener{
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if(board.State == board.STATE.HELP || board.State == board.STATE.SCORE || board.State == board.STATE.DEAD || board.State == board.STATE.WIN)  {
        	if(mx >= 500 && mx <= 550) {
        		if(my >= 15 && my <= 45) {
        			board.State = board.STATE.MENU;
        		}
        	}
        }
       
        if(board.State == board.STATE.Character) {
        	// select pixels captain Atharva
        	if(mx >= 52 && mx <= 150) {
        		if(my >= 171 && my <= 336) {
        			board.strPlayerFacingLeft = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/Left_CaptainAtharva.png";
        	        board.strPlayerFacingRight = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/Right_CaptainAtharva.png";
        	        board.p.CharacterChoice();
        			board.State = board.STATE.GAME;
        		}
        	}
        	else if(mx >= 250 && mx <= 350) {
        		if(my >= 171 && my <= 336) {
        			board.strPlayerFacingLeft = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/SuperAtulLeft.png";
        	        board.strPlayerFacingRight = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/SuperAtulRight.png";
        	        board.p.CharacterChoice();
        	        board.State = board.STATE.GAME;
        		}
        	}
        	else if(mx >= 430 && mx <= 500) {
        		if(my >= 171 && my <= 336) {
        			board.strPlayerFacingLeft = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/GooglyAtharvLeft.png";
        	        board.strPlayerFacingRight = "D:/ATUL/PES/Sem6/OOAD/JavaPrograms/Eclipse/SuperPESBros/GooglyAtharvRight.png";
        	        board.p.CharacterChoice();
        	        board.State = board.STATE.GAME;
        		}
        	}
        }
        
        if(board.State == board.STATE.MENU) {
        	if(mx>=15 && mx<=210) {
        		if(my>=75 && my<=112) {
        			board.State = board.STATE.Character;
        		}
        		if(my>=179 && my<=216) {
        			board.State = board.STATE.SCORE ;
        		}
        		if(my>=231 && my<=268) {
        			// Help 
        			board.State = board.STATE.HELP ;
        		}
        		if(my>=283 && my<=320) {
        			System.exit(1);
        		}
        		if(my>=127 && my<=164) {
        			// choose character 
        			board.State = board.STATE.Character;
        		}
        	}
        }
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}