1. Single Responsibility Principle (SRP)
Each class should have only one reason to change. Here’s how your design stands:

	•	User Class: Handles user-specific details.
	•	Group Class: Manages group-specific details and transactions related to the group.
	•	Transaction Class: Manages the details of a transaction.
	•	Split Class and its Subclasses: Manage the splitting logic of transactions.
	•	Splitwise Class: Acts as the orchestrator for user, group, and transaction management.


2. Open/Closed Principle (OCP)

Classes should be open for extension but closed for modification.

Feedback:

	•	The Split class hierarchy is a good example of OCP. New split types can be added by extending the Split class without modifying existing code.
	•	The Transaction class can be further extended to support different types of transactions (e.g., Equal, Exact, Percentage).

3. Liskov Substitution Principle (LSP)

Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.

Feedback:

	•	The Split class and its subclasses (EqualSplit, PercentageSplit) follow LSP as they can be used interchangeably in the context of transactions.


4. Interface Segregation Principle (ISP)

Clients should not be forced to depend on methods they do not use.

Feedback:

	•	The current design does not have many interfaces, but the concept of ISP can be applied if you introduce more specific interfaces for different functionalities. For example, you could create separate interfaces for balance management and transaction processing.


5. Dependency Inversion Principle (DIP)

High-level modules should not depend on low-level modules. Both should depend on abstractions.

Feedback:

	•	The Splitwise class tightly couples with concrete implementations of User, Group, and Transaction. Introducing interfaces can help in adhering to DIP.
	•	For example, Splitwise could depend on IUser, IGroup, and ITransaction interfaces.

Design Patterns:

Singleton Pattern

	•	Used in Splitwise to ensure only one instance exists. This is correctly implemented.

Factory Pattern

	•	Consider using the Factory Pattern for creating different types of splits. This will centralize the creation logic and make it easier to extend in the future.

Strategy Pattern

	•	Implement the Strategy Pattern for splitting logic. Different splitting strategies (equal, percentage) can be encapsulated into their own classes.