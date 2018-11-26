
Milestone 3:

Complete Implementation: fully-featured with various types of plants and
zombies, and unlimited undo/redo feature.

• Deliverables: readme file + code + refined tests + refined design + documentation.
The program must work robustly, and the code must be “smell-free” (we will be
hunting for smells!). Make sure that you document the changes since the last
iteration, and the reason for those changes.

• Deadline: Monday November 25th. Weight: 30% of the overall project grade. 

Group 6:

Amandeep Singh: Coding for Model,Controller classes readme file , class diagrams.

Zoha Mehdi: Coding for View, Controller classes and writing the JUnit tests diagrams.

Toluwalope Ajisola: Commenting, indentatation and refactoring issues of the code.

James Desorsiers: Sequence Diagrams.

The ZIP file contains  the a jar file that contains the code which is further on divided into different packages of 
classes acting as VIEW, classes acting as MODEL, the controller package consists of the controller class, tests for testing the sunflower
class, Peashooter class, level class,Basic zombie class, getPlant class, Polezombie class, Snowshooter class and Explosive Zombie class. The ZIP file also contains the class diagram and the sequence diagrams under the 
diagrams folder.
The new sequence diagrams for the controller class and  undo, redo feature have been added to this milestone other than the other old diagrams from the milestone 2 which have the same implementation in milestone 3 as well.

Different kinds of datastructures have been used for the Milestone.Including Arraylist that contains the Zombies,for storing different kind of characters in the game.
We have also used the cloneable and serialization interfaces because When you use some marker interface(no method implementation ) you want to tell jvm or compiler for adding or checking something during runtime or compile time. 

The Previous design for the milestone 1 has the console game of the version which was using the classes like commandwords and were missing classes like peashooter, sunflowers.
Milestone 2 contained the MVC design pattern for the plant and zombies which implements the step by step approach of the game instead of the real time version of the game.
Milestone 3 resembles mostly all the classes from milestone 2, but with the addition of new kinds of plants and the zombies and the implementation of the undo /redo feature for the game moves. The code in milestone 2 had limited smelly code, and with good documentation  and design techniques we can aso say that our code is not smelly at this point of the game for the Milestone 3.We were trying new level option for the game in milestone 2, but it doesn’t work for now. So, for this part of the game we have moved out the new level option from the menuBar, which will come back in milestone 4. The Zombie health has also been moved from 1 shot from previous iteration to the 3 shots for the basic zombies, and the health factor has been added for the different zombies.

KNOWN ISSUES: The game works perfectly fine but it has some issues some random times like at the starting of the game, if we run out of the sun Points i.e. sun Points become 0 then the game is stuck neither we lose nor we can make a move to quit or lose. So, that’s a big known issue that we tackle when we run out of the sun Points. Another one, what we can say that is when we click on the skipTurn button the games stops for while and then depending on the number of the presses of the button the zombie takes a step but we can’t take kill the zombies. But, still we can reset the skip using the undo feature.
Sometimes while playing the game 1/20 times or even less we get some random runtime error for the poleZombie, but still the polezombie and the game works fine. We are working on to figuring out that issue right now. As the zombies are randomly produced using the random number generator so sometimes the game acts a bit weird and the zombies come to the field very late whereas 9/10 times the game works perfectly fine and the zombies come on the field after putting approximately  4-5 sunflowers and 3-5 peashooters  on the field.

MODEL PACKAGE: The model  package contains of the model class that deals with methods that add zombie on the field , buying a plant,place a plant on the field after you bought it, check if the the zombies have reached the end and we lose the game or we killed all the zombies, returning the sun points , the returning at what level we are present right now. THe Character class is the another important class that has the common functions for both plants and zombies.Basically it acts as a superclass for all the plants and zombies. The Level class contains the data associated with the current level. Then the sunflower, plant, zombies,,explosive zombie class and zombie class that contains the different kind plant price, and the other methods related to plant and zombies.The Undoredo class deals with the implementation of the undo and redo and contains the undo / redo button, uses stack for the purpose of undoing the steps and redoing the steps. The Model class also contains the new plants that we added to the game as a part of milestone 3,Snowshooter and Walnut are the plants that we added to the game. Walnuts have hard shells which you can use to protect your other plants. The snowshooters shoot frozen peas that damage and slow the enemy. Different kinds of zombies added to the pvz game are Polezombie and explosive zombie.PoleZombie absorbs 340 damage per shot and he degrades upon absorbing 180 damage per shot before dying at 340 damage per shot. When he approaches most plants, Pole Vaulting Zombie will vault over the plant and abruptly lose his pole. His speed will become normal upon losing the pole.

VIEW PACKAGE: contains the classes that act as different panel for the main FRAME. The Plant panel contains the JButton for the sunflower, the peashooter. The MenuBar class contains the menubar for the frame that conatins new level, new and exit where new level doesn't work. The mainPanel class contains the grid layout for the game. The mainframe class contains where we add all the panels, gamePanel,statusPanel and other panels and set their layout.The view class is the main class that contains all the main Jframe that contains the grid and the plants the menuBar and the status Panel containing the sunPoints.The View package the contains the almost the same code as milestone 2 except the new buttons for the undo,redo and the skipTurn have been added to the game.

CONTROLLER PACKAGE : Contains only the controller class is responsible to handle all the events  caused by the view using the MVC style. The undo,redo and skipturn features as methods have been added to the controller class to pass on the message to model, that we want to implement the following command.

The User Visible changes for the game:Are the new buttons for the UNDO and REDO button , the skipTurn button and the different kind of plants like the button for walnut and snowshooter added to the Plant Panel on the left side of the screen of the game.

The Roadmap ahead for the game is to fix some random occurring errors in the code, and implementing the level builder and the SAVE/LOAD features for the game.

HOW TO USE THE GAME So ,we have to go to the MenuBar and click on the new which would start the new game. Then, we can add plants and peashooters to the field while the zombies enter the field. We initially start with 10 sunPoints then as we buy the sunflower we get hike in points and 
we have with every 3 turns we get hike of some sun points. We can both LOSE and WIN the Game.


