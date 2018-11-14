package view;
import model.Model;
import model.CreateLevel;
import controller.Controller;


import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

import model.Character;


public class gamePanel extends mainPanel implements Observer {
	
	public void addAction(Controller c){
		
		//the buttons do nothing
	}
	
public void update(Observable arg0, Object arg1) {
		int x=0;
		int y=0;

		CreateLevel newLevel = ((CreateLevel)arg0);
		
		//draw each Character added to the level
		for(Character a: newLevel.showLevel().getCharacterList()){
			if(newLevel.showLevel().fieldDimension(x, y)){
				
				super.buttons[y][x].setIcon(new ImageIcon(a.getPicture()));
				
			}
			x++;
			
			if(x > newLevel.showLevel().getMaxX()){
				x = 0;
				y++;
				if(y > newLevel.showLevel().getMaxY()){
					y = 0;
				}
			}
		}
		
	}
	
}
