SYSC 3110 Project - Plants vs Zombies: the Puzzle! 

MileStone1: In this milestone we have been asked to make a console version of the game (Plant Vs Zoombies) with the UML diagrams. It is an initial design and implementation of the model part of the MVC.

This project consist of four people as follwed:

Zoha Mehdi - Coding (Initial design and implementation of plant VS Zoombie model class + Readme file)

Amandeep singh - Coding (Initial design and implementation of plant VS Zoombie model class + commenting and indentation of the code)

Toluwalope - UML diagram

James - UML diagram

This project consists of 6 classes which work together to build up the console version of the game as listed below:

BasicZoombie

Command

CommandWords

Game

Parser

Zoombie

The basic Zoobie class is used to give feature to one type of Zoombie found in level 1 of the game. This class extends the Zoombie class 
where the features given to a particular zoombie are applied to it like health, power to attack and its description. Moreover the 
Zoombie class also uses the getHealth() method to return the health of a particular Zoombie and also decrements the zoombies health when 
it is attacked by the plants (Peashoter, Cherryboom).

The command Class is used to hold information about a command that was given by the user like (DropSunflower, DropPeashooter etc..). In 
this class a field of type String 'commandWord' is used to holds the command that the user assigns to do in the game. 
The constructor in this class creates the object of the command where the command given by the user will be stored. A getCommandWord() 
method is used to return the command that the user has asked to implement and if it is null than the result returned is also null. 
Furthermore, isUnKnown() method is used to set the commandWord field to null if the command given by the user is not valid like not 
understandable or false otherwise.

The CommandWord class consists of an array used to hold all the valid command words that the user can use in this game. CommandWord 
class lets the Command class know which commands are valid and which commands are not valid. If the command used by the user is not 
found in the array containing the valid commands in CommandWord class than isKnown() method is implemented in the Command class to 
assign null to the command given by the user as it is not understandable. The isCommand() method in CommandWord class is to used to 
check that a given String is a valid command or not and getCommandList() method returns a list of all valid command.

The Parser class acts as an input class where it reads input from the user and tries to interpret that it is a valid command or not 
using the commandWord class. It checks the validity of the command given by the user by checking the user input against the known command from commandWord class array. If it is valid than it carries on its job else it assigns null to it.

Game class is the one that uses all the other classes given above to implement the game. This class uses several methods to implement
the game as listed below:

PrintWelcome(),

gainSun(),

ceateEnemy(),

processCommand(),

cherryBoob(),

quit(),

peaShooter(),

sunflower(),

shoot(),

loseGame(),

countZoombies(),

play(),

replay(),

main(),

currPoints()

I would explain the Game class in such a way as if we are playing the game rightnow. First of all, whenever the user starts the game it 

generally welcomes its users; therefore, in our main() method a play() method has been called to call on to the welcome() method within 

the play() method to welcome its user when the game starts as shown below:

Welcome to the World of PlantsVsZombies!

Welcome to Adventure Level One.
 
Type 'Sunpoints' if you want to gather the falling Sun Points.
 
Type 'DropPeashooter' if you want to a Pea shooter on the grass.
 
Type 'DropSunflower' if you want a Sunflower on the grass.
 
Type 'Shoot' if you want to shoot a Zombie with Pea Shooter
 
Type 'Quit' if you want to quit.

The welcome() method also gives instructions to the user how to play this game like "Type 'Sunpoints'" to earn Sunpoints etc.. 

Before the game starts a createEnemy() method is called in the main() method to create zoombies in our game before the round starts. 

The createEnemy() method creates 6 zoombies to attack our house in the game.

After the welcome method is printed on the screen for the user to see at the same time the cuuPoints() method is also called to describe 

about the initial situation of the game as shown below:

 CURRENT STATUS OF THE GAME          
 
 Current Sun points : 50
 
 Current Pea Shooters on the grass : 0
 
 Current Sun Flowers on the grass : 0
 
 Current Number of Zombies on the grass: 6
 
 It basically lets the user know how many points the user has initially with how many zoombies, pee Shooter and sunflower are there on 
 
 the field.
 
 Finally, Parser class is than used to take the input from the user of what to do next. All of this metioned above happens in the main 
 
 and play method. This is how the game starts and now the the methods that run the game in the Game class are going to explained below.
 
If the user inputs 'Sunpoints' than processCommand() method in game class compares the command given by the user aginst the valid 

command words stored in commandWord class to see if the command is valid. If the command is valid than the action related to the given 

command is performed. As 'sunPoints' command is given by the user and as it is valid command; therefore, this command will call the 

gainSun() method in Game class to gain 25 points for the user. The gainSun() method increses the points by 25 points whenever called. 

The gainSun() method implements the points falling from the sky in the game. The currpoint() method is called within the gainSun() 

method automatically to show the user that how much points the user has earned by displaying the current situation of the game as shown 

below:
 
 CURRENT STATUS OF THE GAME          
 
 Current Sun points : 75
 
 Current Pea Shooters on the grass : 0
 
 Current Sun Flowers on the grass : 0
 
 Current Number of Zombies on the grass: 6
 
 As we can see above that the sun points just changed from 50 to 75 points. 
 
 After typing in the 'Sunpoints' command several times the user earns the desired number of points the user wants to earn. The user can 
 
 also buy a sunflower for 50 points by typing in the 'DropSunflower' command. The 'DropSunflower' command drops a sunflower on the field 
 
 and its function is to help user earn 100 points whenever it is dropped down on the field. Whenever 'DropSunflower' command is typed in 
 
 by the user the sunflower() method is called in the processCommand() method to implement its functions as described above and shown 
 
 below:
 
  CURRENT STATUS OF THE GAME          
  
  Current Sun points : 125
  
  Current Pea Shooters on the grass : 0
  
  Current Sun Flowers on the grass : 1
  
  Current Number of Zombies on the grass: 6
  
  As we can see. above that the points increased to 125 points from 75 points as the sunflower cost 50 points and than increases by 100 
  
  points after which result in 125 points. Moreover, we can see that the quantity of sunflower increased by one to 1 sunflower on the 
  
  grass. This is how a sunflower() method works in the Game class.
  
 

 
 After typing in 'DropPeashooter' a Peashooter will be dropped down on the grass. This plant is used to attack the zoombies in the 
 
 field. The peaShooter() method is called in the processCommand() method in the Game class to drop the peaShooter on the grass. After
 
 the peaShooter has beem dropped a currPoint() method is called to show the status of the game as shown below:
 
  CURRENT STATUS OF THE GAME          
 
  Current Sun points : 25
           
  Current Pea Shooters on the grass : 1
           
  Current Sun Flowers on the grass : 1
           
  Current Number of Zombies on the grass: 6
  
  We can see above that peaShooter increased from 0 to 1.
  
  To kill the zoombies we use 'Shoot' command. The shoot() method has several conditions that are checked and the once which go
  
  with the conditions are implemented which causes the person to loose or win the game. The simple rule to win this game is as followed:
  
  1) If Peeshooter assigned by the user are more than the zoombies in the game than we will the game
  
  2) If peeshooter and zoombies are equal in number than we win the game because each peeshooter kills one zoombie and one zoombie kills 
  
  one peeshooter; therefore, no one is left in the field alive but the house is safe as there are no more zoombies to kill.
  
  3) If there are three peeshooters on the field than three zombies are killed by the peashooters and the other three zoombies are 
  
  killed by the lawnmower; thus,  we will the game as all zoombies are dead.
  
  The rules to loose the game are:
 
 If peeshooters are less than 3 like 2 or 1 than we lose the game because all the peeshooters die after killing one or two zombies and 
 
 all the 3 landmowers are used to kill 3 more zombies but still one or two zoombies are left on the grass attacking the house; thus, we 
 
 lose the game. The game provides not more than 3 land mowers. Therefore, this is how the game class is used to implement the game.








