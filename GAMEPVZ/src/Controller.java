package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import view.View;
import view.mainFrame;
import model.CreateLevel;
import model.Model;



@SuppressWarnings("unused")
public class Controller implements ActionListener{
	
	//The controller hard wired to the Model and View through
	
	private View view;
	private Model model;
	private int level;
	private mainFrame createView;
	private CreateLevel newLevel;
	
	public Controller(int level){
		this.level = level;
		
		view = new View();
		
		view.addAction(this);
	}

	/*
	 * This action performed method will handle all the events caused by the view using the MVC style.
	 * @param ActionEven e -The source of the interrupt
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getNewGame()){
			model = new Model(level);
			model.addObserver(view);
			if(view.isBuilderMode()){
				view.switchToPlayMode();
			}
			model.notifyObservers();
		}
		else if (e.getSource() == view.getExitGame()){
			view.dispose();
			System.exit(0);
		}
		else if (e.getSource() == view.getNewLevel()){
			System.out.println("New Level Selected");
			if(!view.isBuilderMode()){
				view.switchToBuildMode();
				if(createView== null){
					createView= new mainFrame();
					createView.addAction(this);
				}
				if(newLevel == null){
					newLevel = new CreateLevel(1);
					newLevel.addObserver(createView);
				}
			}
		}
		if(model!=null){
			if(e.getSource() == view.getSkipTurn())
			{
				model.setChoice(null);
				try {
					model.update();
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
			}
			
			
			else if(e.getSource() == view.getLoadGame()){
				
			}
			else{
				if(newLevel != null && createView!= null){
					for(int zomb=0; zomb<createView.getZombies().length; zomb++){
						if(e.getSource() == createView.getZombies()[zomb] ){
									newLevel.putZombie("ExplosiveZombie");
						}
					}
				
					
				}
				
				for(int plant=0; plant<view.getPlantsList().length;plant++){
					if(e.getSource() == view.getPlantsList()[plant] ){
						switch(plant){
							case 0:
								model.setChoice("sunflower");
								break;
							case 1:
								model.setChoice("shooter");
								break;
							default:
								model.setChoice(null);
								break;
						}
					}
				}
				
				for(int row = 0; row < view.getGridList().length; row++){
					for(int col = 0; col<view.getGridList()[row].length; col++ ){
						if(e.getSource() == view.getGridList()[row][col] )	{
							if(model.Choice()!=null)	{
								if(model.placePlant(col, row, model.Choice())){
									try {
										model.update();
									} catch (CloneNotSupportedException e1) {
										e1.printStackTrace();
									} 
								}
							}
						}
					}
				}
			}
			if(model.statusOfGame() == 1){
            System.out.println("WON.");
            //TODO advance level here
            System.exit(0);
        }
        else if(model.statusOfGame() == -1){
            System.out.println("LOST.");
            System.exit(0);
        }
    
	}
		
	}
}
