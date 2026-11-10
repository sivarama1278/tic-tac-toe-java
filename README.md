# Tic-Tac-Toe Game – Java

## Overview

A Java-based Tic-Tac-Toe game developed using Object-Oriented Programming (OOP) and Low-Level Design (LLD) principles.

The project focuses on clean class responsibilities, object-oriented design, and separation of concerns.

## Features

- Configurable board size.
- Two-player game.
- Player turn management.
- Move validation.
- Winning condition detection.
- Draw detection.
- Game status management.

## Tech Stack

- Language: Java
- Build Tool: Apache Maven
- Testing Framework: JUnit 5
- IDE: IntelliJ IDEA


## Design Overview

The project follows object-oriented design principles.

Class  Responsibility 

Game:  Manages game flow, player turns, and game status 
Board: Manages the game board and cell operations 
Player: Represents a player 
Move: Represents a player's move 
WinningStrategy: Defines the winning-condition contract 
StandardWinningStrategy: Implements the winning-condition logic 
Symbol: Represents player symbols 
GameStatus: Represents the current game status 

## How to Build

Make sure Java and Maven are installed.

Clone the repository:


git clone https://github.com/sivarama1278/tic-tac-toe-java.git


Navigate into the project:

cd tic-tac-toe-java


Build the project:

mvn clean package


## Running Tests

Execute the unit tests using:


mvn test


## Learning Objectives

This project demonstrates practical application of:

- Object-Oriented Programming.
- Encapsulation and abstraction.
- Separation of responsibilities.
- Interface-based design.
- Low-Level Design principles.
- Unit testing with JUnit 5.
- Maven project management.
- Git and GitHub version control.

## Author

Developed as a hands-on Java Low-Level Design learning project.
