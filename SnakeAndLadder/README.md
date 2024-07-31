Requirements : 

a) Two players game. Player reaching 100 number first is the winner
b) Players will roll the dice in alternate.
c) Player1 will start the game.
d) If there is snake encountered, the player will go down. If there is ladder encountered, the player will go up. 


Entities : 

a) Board (n * m)
    1. Cells - It can be normal cell, or special cell - snake or ladder
b) Player
    1. id 
    2. currentPosition
c) Dice
    1. currentValue
    2. minValue
    3. maxValue
d) Snake
    1. list of cells
e) Ladder
    1. list of cells


SOLID Principles Review : 

1. Single Responsibility Principle (SRP)
	• Review: Each class has a single responsibility. The SnakeAndLadderService handles the game logic, Player manages player-related data, Board manages the board size, Dice handles dice rolls, and Snake and Ladder represent their respective entities. This adherence is good.

2. Open/Closed Principle (OCP)
	• Review: The code is mostly closed for modification but open for extension. However, improvements can be made. For example, if new game elements are introduced, the SnakeAndLadderService class will need to be modified. Using interfaces or abstract classes for game elements could improve adherence to OCP.

3.	Liskov Substitution Principle (LSP)
	• Review: LSP is not directly applicable as there are no subclasses or inheritance hierarchies.

4.	Interface Segregation Principle (ISP)
	• Review: ISP is not applicable here as there are no interfaces used in the code.

5.	Dependency Inversion Principle (DIP)
	• Review: High-level modules depend on low-level modules directly. Introducing abstractions, such as interfaces for Dice, Board, Player, etc., can improve the design by following DIP.