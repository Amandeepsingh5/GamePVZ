
Milestone 3:

Complete Implementation: fully-featured with various types of plants and
zombies, and unlimited undo/redo feature.

• Deliverables: readme file + code + refined tests + refined design + documentation.
The program must work robustly, and the code must be “smell-free” (we will be
hunting for smells!). Make sure that you document the changes since the last
iteration, and the reason for those changes.

• Deadline: Monday November 18th. Weight: 30% of the overall project grade. 
Group 6:

Amandeep Singh: Coding for Model,Controller classes readme file and class diagrams.

Zoha Mehdi: Coding for View, Controller classes and writing the JUnit tests.

Toluwalope Ajisola: Commenting, indentatation and refactoring issues of the code.

James Desorsiers: Sequence Diagrams.

The ZIP file contains  the a jar file that contains the code which is further on divided into different packages of 
classes acting as VIEW, classes acting as MODEL, the contoller package consists of the controller class, tests for testing the sunflower
class, peashooter class, level class, Explosive Zombie class. The ZIP file also contains the class diagram and the sequence diagrams under the 
diagrams folder.

Different kinds of datastructures have been used for the Milestone.Includes Arraylist that contains the Zombies,the characters and many more.
We have also used the cloneable and serialization interfaces becauseWhen you use some marker interface(no method implementation ) you want to tell jvm or compiler for adding or checking something during runtime or compile time.

The Previous design for the console game of the version was was using the classes like commandwords ans were missing classes like peashooter, sunflowers.
So, comparing it from the previous version of the game we have added the new helper classes for the model like plant, peashooter, zombie , sunflower ,level classes that we missing in the milestone 1.
The View, Controller have been added, as well as the we have restructured and redesigned the Model classes as directed by the marking TA for milestone 1


KNOWN ISSUES: We are still working on the implementation to put in the button to skip a turn, but for this milestone we have not achieved that yet. THe new LEVEL option in the menubar doesn't work for now. So, to play the game we need to go to the menubar and click new to play the game. We also also working on the health of zombie, which is the ZOMBIE dies with one shot for now.But for next milestone we are planning to increase that to 3 shots i.e the zombie will die with 3 shots . For this milestone we are just using the one kind of flower that is sunflower, and only kinf of zombie. In the terms of the smelly code, the Model class of the code has smelly code whereas the view and controller are well organized with low coupling and high cohesion. As the zombies are randomly produced using the random number generator so sometimes the game acts a bit weird and the zombies come to the field very late  whereas 9/10 times the game works perfectly fine and the zombies come on the field after putting approximately  4-5 sunflowers and 3-5 peashooters  on the field.

MODEL PACKAGE: The model  package contains of the model class that deals with methods that add zombie on the field , buying a plant,place a plant on the field after you bought it, check if the the zombies have reached the end and we lose the game or we killed all the zombies, returning the sun points , the returning at what level we are present right now. THe Character class is the another important class that has the common functions for both plants and zombies.Basically it acts as a superclass for all the plants and zombies. The Level class contains the data associated with the current level. Then the sunflower, plant, zombies,,explosive zombie class and zombie class that cotains the different kind plant price, and the other methods related to plant and zombies.

VIEW PACKAGE: contains the classes that act as different panel for the main FRAME. The Plant panel contains the JButton for the sunflower, the peashooter. The MenuBar class contains the menubar for the frame that conatins new level, new and exit where new level doesn't work. The mainPanel class contains the grid layout for the game. The mainframe class contains where we add all the panels, gamePanel,statusPanel and other panels and set their layout.The view class is the main class that contains all the main Jframe that contains the grid and the plants the menuBar and the status Panel containing the sunPoints.

CONTROLLER PACKAGE : Contains only the controller class is reponsible to handle all the events  caused by the view using the MVC style.

HOW TO USE THE GAME: As previously mentioned, the new Level doesn't work , so as we run the game, we see the newLevel. So ,we have to go to the MenuBar and click on the new which would start the new game. Then, we can add plants and peashooters to the field while the zombies enter the field. We initially start with 10 sunPoints then as we buy the sunflower we get hike in points and 
we have with every 3 turns we get hike of some sun points. We can both LOSE and WIN the Game.


