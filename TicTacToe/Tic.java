import java.util.Scanner;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Position{ // Saving Position of the Board
	int a;
	int b;
		
	public Position(int a, int b)
	{
		this.a=a;
		this.b=b;
	}
}

public class Tic {
	Player user;
	Player computer;
	String[][] board = new String[3][3];
	//Position comP;
	Position comP = new Position(0,1);
	int checkArr[]= new int[10];
	

	
	public Tic()
	{
		Tac();
	}
	/*
		Tac
		- framework for the game
		- calls all appropriate methods as well as retrieves user input
		- checks for wins and for draws
		- calls appropriate methods for executing moves for user and for computer
	*/
	public void Tac() // Start Game
	{
		int counter=0;
		System.err.println("Do you want to play first(X) or second(O)?");
		Scanner scan = new Scanner(System.in);
		String x= scan.nextLine();
		x = x.toUpperCase();
		System.err.println(x);
		String y;
		Random rand = new Random();
		int position;
		initiateBoard();
		
		
		if ( x.equals("X"))
		{	
			System.err.println("You are X");
			System.err.println("Puts number, 1~9");
		//	whoFirst = 0;
			y = "O";
		}
		else
		{
			System.err.println("You are O");
			System.err.println("Puts number , 1~9");
		//	whoFirst = 1;
			y = "X";
		}
		//System.err.println(whoFirst);

		user = new Player(x);
		computer = new Player(y);
		
		if(user.value.equals("X")) // When Players play First
		{
			printBoard();
			while(true)
			{
					
					System.err.println("It's Your Turn!");
					position = scan.nextInt();

					fillBoard(position, user);
					counter++;
					printBoard();
						if(checkWin(user)==1)
						{
							System.err.println("You Won");

							break;
						}
						if(counter==9)
						{
							System.err.println("DRAW!");
							break;
						}
					
					minimax(0,1,computer.value);
					ComFillBoard(comP);
					counter++;
					printBoard();
					if(checkWin(computer)==1)
					{
						System.err.println("You Lost");

						break;
					}
					if(counter==9)
					{
						System.err.println("DRAW!");

						break;
					}

			}
			//Tac();
			
		}
		else{ // When Computer play first
			while(true)
			{
				minimax(0,1,computer.value);
				ComFillBoard(comP);
				counter++;
				printBoard();
				if(checkWin(computer)==1)
				{
					System.err.println("You Lost");
					break;
				}
				if(counter==9)
				{
					System.err.println("DRAW!");
					break;
				}
				System.err.println("It's Your Turn!");
				position = scan.nextInt();

				fillBoard(position, user);
				counter++;
				printBoard();
					if(checkWin(user)==1)
					{
						System.err.println("You Won");
						break;
					}
					if(counter==9)
					{
						System.err.println("DRAW!");
						break;
					}
			}
			//Tac();
//			String scans = scan.nextLine().toLowerCase();
//			if(scans=="y")
//			{
//				Tic ttt = new Tic();
//			}

		}
		Tac();
	}

	/*
		checkwin
		- checks win for each valid winning configuration

	*/
	public int checkWin(Player p){ // This method check result of the game, and it checks every turns.(Horizontal, Vertical, diagnal)
		int win = 0;
		for(int i = 0 ; i<3 ; i++)
		{
				if(p.value.equals(board[i][0])&&!board[i][0].equals(" ")&&board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]))
				{
					//System.err.println("Test1");
					win = 1;
					break;
				}
		}
		for(int i = 0 ; i<3 ; i++)
		{
				if(p.value.equals(board[0][i])&&!board[0][i].equals(" ")&&board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]))
				{
					//System.err.println("Test12");
					win = 1;
					break;
				}
		}
		if(p.value.equals(board[0][0])&&!board[0][0].equals(" ")&&board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
		{
			//System.err.println("Test13");
			win = 1;
		}
		if(p.value.equals(board[0][2])&&!board[0][2].equals(" ")&&board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))
		{
			//System.err.println("Test14");
			win = 1;
		}
		return win;
	}
	/*
		initiateBoard
		- fills in board with empty spaces to initialize it
	*/
	public void initiateBoard() // initiate Board
	{
		for(int i = 0; i<3; i++)
			for(int j = 0; j<3; j++)
					board[i][j] = " ";
	}
	/*
		printBoard
		- method to print board
	*/
	public void printBoard() // Printing the board
	{
		int j=0;
		for(int i = 0; i<3; i++)
		{
				System.err.println(" " + board[i][0]+ " | " + board[i][1] + " | " + board[i][2]);
			if(i != 2)
				System.err.println("---|---|---");

		}
	}
	public void ComFillBoard(Position P) // Computer Fill Board
	{
		System.out.println(comP.a);
		System.out.println(comP.b);
		board[comP.a][comP.b] = computer.value;
	}
	public void fillBoard(int position, Player p){ // fillBoard depends on where player puts
		Scanner scan = new Scanner(System.in);
		switch(position)
		{
		case 1:
			if(board[0][0]== " ") // Check if board is already filled
			{
				board[0][0] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 2:
			if(board[0][1]== " ")
			{
				board[0][1] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 3:
			if(board[0][2] == " ")
			{
				board[0][2] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 4:
			if(board[1][0] == " ")
			{
				board[1][0] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 5:
			if(board[1][1] == " ")
			{
				board[1][1] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 6:
			if(board[1][2] == " ")
			{
				board[1][2] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 7:
			if(board[2][0] == " ")
			{
				board[2][0] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 8:
			
			if(board[2][1] == " ")
			{
				board[2][1] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		case 9:
			if(board[2][2] == " ")
			{
				board[2][2] = p.value;
			}
			else{
				System.err.println("Wrong place try again");
				position=scan.nextInt();
				fillBoard(position,user);
			}
			break;
		}
	}

	List<Position> emptySp;
	public List<Position> emptySpace()// Make an list with an emptySpace
	{
		emptySp = new ArrayList<>();
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
			{
				if(board[i][j].equals(" "))
				{
					emptySp.add(new Position(i,j));
				}
			}
		return emptySp;
		
	}
	
	public void setComp(Position p) 
	{
		comP=p;
		
	}

	public int minimax(int depth, int turn, String x)//  minimax algorithm
	{
        int max = 99999;
        int min = 99999;
        

	       if (checkWin(computer) ==1) // score 1 if computer win
			{
				return 1;
			}
	        if (checkWin(user)==1)  // score -1 if lose
			{
				return -1;
			}

	        List<Position> emptyStates = emptySpace();
	        if (emptyStates.isEmpty()) return 0;
	        
	        if(x =="X")
	        {
	        	Collections.shuffle(emptyStates); // Shuffle the states list for random plays.
	        }


	                
	        for (int i = 0; i < emptyStates.size(); ++i) {
	            Position p = emptyStates.get(i);
	            
	            
	            if (turn == 1) { // MAX COMPUTER
	            	board[p.a][p.b] = computer.value;
	           
	                int score = minimax(depth + 1, 2,computer.value); // next Step to Min
	               max = Math.max(score, max);

	                if(score >= 0){ 
	                	if(depth == 0)
	                		comP = p;
	                	}
	                if(score == 1){ // terminate
	                	
	                	board[p.a][p.b] = " ";
	                	comP=p;
	                	break;
	                	}
	                if(i == emptyStates.size()-1 && max < 0){
	                	if(depth == 0)
	                		comP = p;
	                	}
			if(depth ==0)
	                {
	                	System.err.println("Score of Empty Position: "+ (i+1) + "="+score);
	                }
	            } else if (turn == 2) {// Min USER
	            	
	                board[p.a][p.b] = user.value;
	                
	                int score = minimax(depth + 1, 1,computer.value); // next Step to Max
	                
	                min = Math.min(score, min);
	                if(min == -1){ // terminate
	                	board[p.a][p.b] = " ";
	                	comP=p;
	                	break;
	                	}
	            }
	            board[p.a][p.b] = " ";
	        }
	        if(turn==1)
	        {
	        	return max;
	        }
	        else return min;


	}
	public static void main(String[]args){
		Tic ttt = new Tic();
	}
}
