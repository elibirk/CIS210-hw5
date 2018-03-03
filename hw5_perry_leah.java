package hw5_perry_leah;

import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class hw5_perry_leah {
	public static void main(String[]args) throws IOException {
	Scanner keyboard = new Scanner(System.in);
	PrintWriter outputfile = new PrintWriter("hw5_perry_leah.txt");

	char programLoop = 'Y';//determines whether or not to loop the program, default runs once
	int userRPS;//user's choice
	int compRPS;//computer's choice
	String winner;//winner decided
	String uChoice;//string of user's choice
	String cChoice;//string of computer's choice
	int loop = 0;//number of times program has looped, so it stops after 10 rounds
	
	while(programLoop != 'N' && programLoop != 'n' && loop < 10) {
		//while user hasn't exited and program hasn't run too many times
		
	userRPS = UserSelection(keyboard, outputfile);//let's user select rock paper or scissors
	compRPS = ComputerSelection();//generates the computer's choice
	
	winner = DecideWinner(userRPS, compRPS);//decides which choice is superior
	
	uChoice = ConvertToStringRPS(userRPS);//converts user's choice to a string
	cChoice = ConvertToStringRPS(compRPS);//converts computer's choice to a string
	
	AnnounceWinner(winner, uChoice, cChoice, outputfile);//announces the winner of the game
	
	
	programLoop = ProgramLoop(keyboard,outputfile);//determines whether or not to rerun
	
	
	loop++;//increments number of times the program has run
	}//end loop program
	

	keyboard.close();//closes keyboard Scanner object to prevent memory leaks
	outputfile.close();//closes output file to prevent memory leaks
	}//end main	



	
public static char ProgramLoop(Scanner keyboard, PrintWriter out){
	/* FUNCTION: ProgramLoop
	 * PURPOSE: Determines whether or not to loop program
	 * @Parameter	programLoop	Holds the user's choice y or n
	 * */
	char programLoop;//stores program loop choice
	
		System.out.println("Do you want to play again? Enter Y or y for yes or " + 
		"N or n for no.");//prompt
		out.println("Do you want to play again? Enter Y or y for yes or " + 
		"N or n for no.");//print to output file
		programLoop = keyboard.next(".").charAt(0); //scans in choice
		out.println(programLoop);
				
		while (programLoop != 'Y' && programLoop != 'y' && programLoop != 'N' && programLoop 
				!= 'n')//if choice isn't valid, run again
		{
			System.out.println("Sorry that is an invalid choice. Enter 'Y' or 'y' for yes" + 
				", or 'N' or 'n' for no.");	
			out.println("Sorry that is an invalid choice. Enter 'Y' or 'y' for yes" + 
				", or 'N' or 'n' for no.");
				
			if (keyboard.hasNext()) {
				programLoop = keyboard.next(".").charAt(0); //scans in choice
				out.println(programLoop);
			}//end if	
		}//end while
	return programLoop;//return the user's choice
}//end UserSelection function



public static int UserSelection(Scanner io, PrintWriter out){
/* FUNCTION: UserSelection
 * PURPOSE: Let's user choose rock, paper, or scissors
 * @Parameter	UserSelection	Holds the user's choice rock, paper, or scissors
 * */
 int userSelection;
 
	do {//while selection isn't 1, 2, or 3, keep asking for a new selection
		System.out.println("Please choose a number: \n1 for rock\n2 for paper" +
		"\n3 for scissors");//prompt
		out.println("Please choose a number:"); 
		out.println("1 for rock");
		out.println("2 for paper");
		out.println("3 for scissors");//print to output file
		userSelection = io.nextInt();//scans in choice
		out.println(userSelection);//print to output file
	} while (userSelection != 1 && userSelection != 2 && userSelection != 3);
	
	return userSelection;//return the user's choice
}//end UserSelection function




public static int ComputerSelection(){
/* FUNCTION: ComputerSelection
 * PURPOSE: Calculates random selection 1, 2, or 3
 * @Parameter	r		random value
 * @Parameter	random	random int 1, 2, or 3
 */
	Random r = new Random(); //gets new random number
	int random = r.nextInt(3) + 1; //random = 1, 2, or 3
	
	return random;
}//end ComputerSelection function




public static String DecideWinner(int userChoice, int computerChoice){
/* FUNCTION: DecideWinner
 * PURPOSE: Decides winner in rock paper scissors
 * @Parameter	userChoice		User's choice rock/paper/scissors
 * @Parameter	computerChoice	computer's randomly generated choice
 * @Parameter	rock			int value for rock
 * @Parameter	paper			int value for paper
 * @Parameter	scissors		int value for scissors
 * @Parameter	computerWins	string returning Computer as winner
 * @Parameter	userWins		string returning User as winner
 */
	String winner = "Tie";//defaults to tie so one must only determine victor
	final int rock = 1;
	final int paper = 2;
	final int scissors = 3;
	final String computerWins = "Computer";
	final String userWins = "User";
	//all the finals since the program uses all of these several times and so it's more readable
	
	switch (userChoice){//looking at user's choice
	case rock:
		if (computerChoice == paper) {//paper beats rock
			winner = computerWins;
		}//end if
		else if (computerChoice == scissors){//rock beats scissors
			winner = userWins;
		}//end else if
		break;
	case paper:
		if (computerChoice == scissors) {//scissors beat paper
			winner = computerWins;
		}//end if
		else if (computerChoice == rock){//paper beats rock
			winner = userWins;
		}//end else if
		break;
	case scissors:
		if (computerChoice == rock) {//rock beats scissors
			winner = computerWins;
		}//end if
		else if (computerChoice == paper){//scissors beat paper
			winner = userWins;
		}//end else if
		
	}//end switch case
	
	return winner;
}//end DecideWinner function




public static void AnnounceWinner(String winner, String uChoice, String cChoice, PrintWriter out){
/* FUNCTION: AnnounceWinner
 * PURPOSE: Announces winner of rock paper scissors
 * @Parameter	winner			string with winner's name
 * @Parameter	userChoice		user's choice of rock/paper/scissors
 * @Parameter	computerChoice	computer's random choice of rock/paper/scissors
 */
	
	System.out.print("User chose " + uChoice + " and the computer chose " +
	cChoice);//prints out choices
	
	out.print("User chose " + uChoice + " and the computer chose " +
			cChoice);
	if (winner == "Tie") {//if there was a tie
		System.out.println(" so it's a tie!");
		out.println(" so it's a tie!");
	}//tie
	else if (winner == "User") {//if user won
		System.out.println(" so the User wins!");
		out.println(" so the User wins!");
	}//user wins
	else if (winner == "Computer") {//if computer won
		System.out.println(" so the Computer wins!");
		out.println(" so the Computer wins!");
	}//computer wins
}//end AnnounceWinner function

public static String ConvertToStringRPS(int choice){
	/* FUNCTION: ConvertToStringRPS
	 * PURPOSE: Converts rock/paper/scissors int choice to a string
	 * @Parameter	choice		int version of choice
	 * @Parameter	strChoice	string version of choice
	 */
	String strChoice = "invalid";//defaults to invalid in case of issues
	
	switch (choice){
	case 1:
		strChoice = "rock";//converts 1 to "rock"
		break;
	case 2:
		strChoice = "paper";//converts 2 to "paper"
		break;
	case 3:
		strChoice = "scissors";//converts 3 to "scissors"
		break;
	}//end switch case
	
	
	return strChoice;
}//end ConvertToStringRPS function



}//end class
