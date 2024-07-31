Requirements : 

a) Two players game. Player reaching 100 number first is the winner
b) Players will roll the dice in alternate.
c) Player1 will start the game.
d) If there is snake encountered, the player will go down. If there is ladder encountered, the player will go up. 


Entities : 

a) Board of given size
b) Player
    1. name 
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


Design Patterns Feedback

	1.	Factory Pattern
	•	Feedback: A factory pattern can be used to create instances of Snake, Ladder, and Player. This can encapsulate the instantiation logic and provide a single point of control for object creation.
	2.	Strategy Pattern
	•	Feedback: The dice rolling logic could use a strategy pattern to allow different dice rolling strategies without changing the Dice class.
	3.	Observer Pattern
	•	Feedback: Implementing an observer pattern can help notify players or other components of game events, such as when a player moves, a snake bite occurs, or a ladder is climbed.
	4.	Builder Pattern
	•	Feedback: The SnakeAndLadderService constructor has multiple parameters, which could be simplified using a builder pattern for easier and more readable object construction