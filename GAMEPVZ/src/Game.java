import java.io.*;
import java.util.ArrayList;

/**
 * The main engine of the game, which handles the logic and data manipulation. In effect, the model in traditional model-view-controller paradigm.
 * 
 * @author James, zoha mehdi
 *
 */
public class Game {
	private static final int LANES = 2;
	private static final int TILES = 5;
    
    private ArrayList<ArrayList<GameEntity>> lawn;
	private int sun= 50;
	private int passiveIncome = 25;
	
	public Game() {
		lawn = new ArrayList<ArrayList<GameEntity>>(LANES);
		for(ArrayList<GameEntity> lane: lawn) {
			lane = new ArrayList<GameEntity>(TILES);
		}
		
	}
	
	/* Old Code for the Text Based Engine
	public void printWelcome() {
		System.out.println();
        System.out.println("->Welcome to the World of PlantsVsZombies!");
        System.out.println("->Welcome to Adventure Level One.");
        System.out.println("Type 'Sunpoints' if you want to gather the falling Sun Points.");
        System.out.println("Type 'DropPeashooter' if you want to a Pea shooter on the grass.");
        System.out.println("Type 'DropSunflower' if you want a Sunflower on the grass.");
        System.out.println("Type 'Shoot' if you want to shoot a Zombie with Pea Shooter.");
        System.out.println("Type 'Quit' if you want to quit.");
        
        System.out.println();
	}
	
	
	public void gainSun() {
	    	sun += 25;
	    	currPoints();	
	}
	
	public void createEnemy() {

		zombie = new BasicZoombie();
		for(int i=0; i < 6;i++) {
			Game.enemy.add(zombie);
		}
	}


    
   private boolean processCommand(Command command) 
   {
       
       boolean wantToQuit = false;
     if(command.isUnknown()) {
           System.out.println("I don't know what you mean...");
           return false;
       }

     String commandWord = command.getCommandWord();

       if (commandWord.equals("DropPeashooter")) {
          peaShooter();
       }
       else if (commandWord.equals("DropSunflower")) {
          sunflower();
       }
       else if (commandWord.equals("Shoot")) {
          shoot();
       }
       else if (commandWord.equals("Sunpoints")) {
           gainSun();
        }
       
       else if (commandWord.equals("DropCherrybomb")) {
           cherryBomb();
          
       }
       else if (commandWord.equals("Quit")) {
    	   wantToQuit = quit(command);
       }
       else if(commandWord.equals("Replay")) {
    	   replay();
       }
      
 
       // else command not recognised.
       return wantToQuit;
   }
   
   private void cherryBomb() {
	   if(sun >= 150) {
  			cherryBomb += 1;
  			System.out.println("A CherryBomb has been dropped on the grass");
  			System.out.println(" ");
  			sun -=150;
  			System.out.println("Cherry Bomb bursted, All Zombies Dead! Move to level 2");
  		
  		}else {
  			
  			System.out.println("Not enough sunpoints to Buy CherryBomb");
  			System.out.println(" ");
  			currPoints();
  		
      }}
   
	   
	   

   
   private boolean quit(Command command) 
   {
       if(command.hasSecondWord()) {
           System.out.println("Quit what?");
           return false;
       }
       else {
           return true;  // signal that we want to quit
       }
   }

   public void currPoints() {
		System.out.println("      ---------------------------------------------" );
		System.out.println("           CURRENT STATUS OF THE GAME          " );
		
		System.out.println("           Current Sun points : "  + this.sun);
		System.out.println("           Current Pea Shooters on the grass : "  + this.peaShooter);
		System.out.println("           Current Sun Flowers on the grass : " + this.sunFlower);
		System.out.println("           Current Number of Zombies on the grass: " + enemy.size());
		System.out.println("      ----------------------------------------------" );
	}
  
	

   public void peaShooter() {
       if(sun >= 100) {
   			peaShooter += 1;
   			System.out.println("A Pea Shooter has been dropped on the grass");
   			System.out.println(" ");
   			sun -=100;
   			currPoints();
   		}else {
   			
   			System.out.println("Not enough sunpoints");
   			System.out.println(" ");
   			currPoints();
   		
       }}
	   
	   
   
   
  public void sunflower() {
	   sunFlower += 1;
		sun -=50;
		System.out.println("A sunflower has been dropped on the grass");
		sun= sun + 100;
		currPoints();
	
  }
  
  public void shoot() {
	 
	  if ((peaShooter > enemy.size() && enemy.size() > 0) && !(enemy.size()==0)) {
		  enemy.remove(0);
		  System.out.println("Zombie dead");
		  peaShooter -= 1;
		  countZombie();
		  }
		  
	  else if(peaShooter >= 0 && yardMower>=0 && enemy.size()==0) {
		  System.out.println("You win the game. Move to Level 2");
		  
	  }
	  
	  else if ((peaShooter <=3 && peaShooter >0) && yardMower ==3) {
		    while(peaShooter >= 1) {
		    	enemy.remove(0);
				System.out.println("Zombie dead");
				peaShooter -=1;
				countZombie();
				System.out.println(" ");
		    }
	  }
	  else if((peaShooter ==0 && yardMower > 0) && enemy.size() > 0) {
		    enemy.remove(0);
			System.out.println("Zombie dead");
			yardMower -= 1;
			countZombie();
			System.out.println(" ");
		    }
	  
	  else if ((peaShooter >3 && peaShooter <=6) && yardMower > 0) {
		   
				enemy.remove(0);
				System.out.println("Zombie dead");
				peaShooter -=1;
				countZombie();
				System.out.println(" ");
		   }
	  
	  else if ((peaShooter <=2 )) {
		  while(peaShooter > 0) {
			  enemy.remove(0);
				System.out.println("Zombie dead");
				peaShooter -=1;
				countZombie();
				System.out.println(" ");
		  }
		  while(yardMower == 3 && peaShooter == 0) {
			  enemy.remove(0);
				System.out.println("Zombie dead");
				yardMower -=1;
				countZombie();
				System.out.println(" ");
			  
		  }
		  
		  loseGame();
		  
		  
	  }
	  
	  else if ((peaShooter ==0 && yardMower ==0) && enemy.size() >0) {
		  
		  loseGame();
	  }
  }
  */
  
  /*
   * Generic Function to place a new plant at a given location(lane, tile)
   */
  public void placePlant(Plant newPlant, int lane, int depth) {
	  assert(newPlant != null);//Note to self, change this to throw an exception in the future
	  assert(lane >= 0 && lane < LANES && depth >= 0 && depth < TILES);//Change to an exception in the future.
	  
	   GameEntity location = lawn.get(lane).get(depth);
	   
	   if(location == null) {
		   location = newPlant;
	   }else {
		   //throw exception
	   }
  }
  
  /*
   * Generic Function to spawn a zombie at the end of a given lane. Will throw an exception in the future
   */
  public void spawnZombie(Zoombie spawn, int lane) {
	  GameEntity location = lawn.get(lane).get(TILES-1);
	  if(location != null) {
		  location = spawn;
	  }else {
		  //throw exception
	  }
  }
	  
  /*
   * Function that ticks every in game turn to iterate over all current tiles to acquire game actions.
   */
  public void turnTick() {
	  int laneIndex, depthIndex;
	  laneIndex = 0;
	  for(ArrayList<GameEntity> lane:lawn) {
		  depthIndex = 0;
		  for(GameEntity obj:lane) {
			  if(obj != null) {
				  handleAction(obj.gameFunction(), laneIndex, depthIndex, obj);
				  depthIndex++;
			  }
		   laneIndex++;
		  }
	  }
	  sun += passiveIncome;
  }
  
  /*
   * Function that resolve the action on the data. See Action Class for the ID table
   */
  private void handleAction(Action command, int lane, int depth, GameEntity caller) {
	  if(command.getID() == 0) {
		  return;
	  }else if(command.getID() == 1) {
		  if(depth == 0) {
			  //game over command
		  }else if(lawn.get(lane).get(depth-1) == null) {				  
			  lawn.get(lane).add(depth - 1, caller);
			  lawn.get(lane).add(depth, null);
		  }else {
			  lawn.get(lane).get(depth-1).takeDamage(command.getPower());
		  }
	  }else if(command.getID() == 2) {
		  sun += command.getPower();
	  }
  }
  
  /*
   * Generic Code to remove an Entity by it's reference
   */
  public void removeEntity(GameEntity in) {
	  for(ArrayList<GameEntity> lane:lawn) {
		  for(GameEntity obj: lane) {
			  if(obj == in) {
				  obj = null
			  }
		  }
	  }
  	}
  
	  /*Legacy Code
   public void loseGame() {
    	System.out.println("Oops! You lost the Game");
    	System.out.println("      xxxxxxxxxxxxxxxxxx");
    	System.out.println("Do you wish to 'Replay' OR 'Quit'");
    	System.out.println("      xxxxxxxxxxxxxxxxxx");
    	boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
  public void countZombie() {
	  System.out.println("      -------------------------------------------------" );
	  System.out.println("            Current Number of Zombies in the Grass:  " + enemy.size());
	  System.out.println("            Current Number of Peashooter in the Grass:  " + peaShooter);
	  System.out.println("            Current Number of yardMower in the Grass:" + yardMower);
	  System.out.println("      --------------------------------------------------" );
  }
  
  public void play() 
  {            
      printWelcome();
     
      currPoints();
      
      // Enter the main command loop.  Here we repeatedly read commands and
      // execute them until the game is over.
      boolean finished = false;
      while (! finished) {
          Command command = parser.getCommand();
          finished = processCommand(command);
      }
      System.out.println("Thank you for playing.  Good bye.");
  }
  
  public void replay() 
  {            
      this.sun=50;
      this.peaShooter =0;
      this.sunFlower=0;
      zombie = new BasicZoombie();
      
      for(int i=enemy.size() -1; i >= 0;i--) {
		Game.enemy.remove(i);
      }
      zombie = new BasicZoombie();
      
      for(int i=0; i < 6;i++) {
		Game.enemy.add(zombie);
      }
      
      play();
  }
*/


	@SuppressWarnings("resource")
	public static void main(String[] args){
	}
}