package controller;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.io.IOException;
import model.CreateLevel;
import model.Model;
import view.mainFrame;
import view.View;

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
			else if(e.getSource() == view.getUndo()){			
				model.undo();
			}
			else if(e.getSource() == view.getRedo()){
				model.redo();
			}
			else if(e.getSource() == view.getSaveGame()){
				try {
					File newFileOutput=view.actionSaveFile();
					model.writeObject(newFileOutput.getPath());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == view.getLoadGame()){
				try {
					File newFileOutput=view.actionOpenFile();
					model.readObject(newFileOutput.getPath());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			
			
			
			else{
				if(newLevel != null && createView != null){
					for(int zombInd=0; zombInd<createView.getZombies().length; zombInd++){
						if(e.getSource() == createView.getZombies()[zombInd] ){
							switch(zombInd){
								case 0:
									newLevel.putZombie("BasicZombie");
									break;
								case 1:
									newLevel.putZombie("ExplosiveZombie");
									break;
								case 2:
									newLevel.putZombie("PoleZombie");
									break;
								default:
									break;
							}
						}
					}
				
					if(e.getSource() == createView.Undo()){
						newLevel.takeZombie();
					}
				}
				
				for(int plantInd=0; plantInd<view.getPlantsList().length;plantInd++){
					if(e.getSource() == view.getPlantsList()[plantInd] ){
						switch(plantInd){
							case 0:
								model.setChoice("sunflower");
								break;
							case 1:
								model.setChoice("shooter");
								break;
							case 2:
								model.setChoice("snowshooter");
								break;
							case 3:
								model.setChoice("walnut");
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
							if(model.getChoice()!=null)	{
								if(model.placePlant(col, row, model.getChoice())){
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
        if(model.state() == 1){
            System.out.println("WON");
           
            System.exit(0);
        }
        else if(model.state() == -1){
            System.out.println("LOST");
            System.exit(0);
        
    
	}
		
	}
}}