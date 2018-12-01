# CSC242-Project-1

Tic Tac Toe - minimax, alpha-beta pruning, heuristic function

Lilian Ludford, Chang Kyung Kim

This project contains: 
   Tic.java, Tic2.java, Player.java
   
   Tic.java = 3x3 Tic Tac Toe ||||
   - contains everything needed for Part I
   Tic2.java = Ultimate Tic Tac Toe |||| 
   - contains everything needed for Part II 
   Player.java 
   - contains a simple "Player" class
   - needed for both Parts I and II

To Compile:
   	- javac *.java
To Run:
   	- java Tic -or- java Tic2
   	- follow instructions to play the game
   	- in order to demonstrate our minimax algorithm, Tic2 will print the score for each board/cell combination that it finds
   	-
NOTE: Tic is the simple 3x3 Tic Tac Toe board. Tic2 runs the Part 2 "Ultimate" Tic Tac Toe board 

How do we build programs:

  3x3 : We used basic minimax function. Using recursive function, make minimax tree that has all the cases. Each leafs have score and computer would follow to leaf that has highest score. It would print score of nodes every turn when computer plays. 

