package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

import model.Character;
import model.Model;
import model.CreateLevel;
import controller.Controller;

@SuppressWarnings("unused")
public class gamePanel extends mainPanel implements Observer {
	
	public void addAction(Controller c){
		//the buttons do nothing
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		CreateLevel Level = ((CreateLevel)arg0);
		int x=0;
		int y=0;

		//draw each Character added to the level
		for(Character a: Level.showLevel().getCharacterList()){
			
			if(Level.showLevel().fieldDimension(x, y)){
				
				super.buttons[y][x].setIcon(new ImageIcon(a.getSprite()));
				
			}
			x++;
			if(x > Level.showLevel().getMaxX()){
				
				x = 0;
				y++;
				if(y > Level.showLevel().getMaxY()){
					y = 0;
				}
			}
		}
		
	}
}
