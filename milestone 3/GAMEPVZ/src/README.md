pvz
===

SYSC 3110 Project

How To Play:
Select File->New from the drop down menu. Implementation does'nt allow other options to be clicked
Click on a plant to chose a type.
Click anywhere on the grid after selecting a plant to place a plant. 
Click the End Turn button if you do not wish to place a plant. 
Zombies invade from the right.

Fixed Issues:
-tile-actor double-linking. is poor design, often leads to problems. an alternative will be found



Changes from Previous Release:
-  Grid system of the game changed, Tile class removed as a result reduced coupling   between classes and more efficient stacking of zombies
-Tests for new plants and zombies (from previous milestone) added
- Save/Load Feature added
-Undo/Redo has been implemented using the Clonnable interface
-Stacking of Zombies is supported
-Some classes re-factored, View split into smaller classes, other changes


Known Issues:
- Level builder doesnt work in gui