package midtermExamLab;

import java.util.*;

public class BSIT_2_ME_Colonia {
	// Global Variables
	static Scanner input  = new Scanner(System.in); // Creates an instance of Scanner.
	static boolean ifProgramContinue = true; // Boolean variable. used to check if program should continue running.
	
	public static void main(String[] args) {
		
		
		
		System.out.println("\nData Structures and Algorithms | Midterm Lab Exam Program"
				+ "\nProgrammed by Kurt Robin P. Colonia from 2BSIT-2, A.Y. 2022-2023");
		
		while(ifProgramContinue) {
			mainMenu();
		}
	}
	
	static void mainMenu() {
		
		int menuInput = 0; // initializes menuInput.
		
		System.out.println("\nMain Menu: "
						 + "\n1. Reverse Word"
						 + "\n2. Balancing the Parenthesis"
						 + "\n3. Exit\n");
		
		System.out.print("Enter Option [1-3]: ");
		try {
			menuInput = input.nextInt();
			input.nextLine(); // accepts menu input.
		}
		catch (InputMismatchException e) {
			input.nextLine();
			System.out.println("Input is Invalid. Please only enter a valid Integer value.");
		}
		
		switch(menuInput) {
		case 1:
			String stringInput;
			
			System.out.print("\nInput String: ");
			stringInput = input.nextLine(); // Accepts String input for Reverse String.
			
			System.out.println(reverseString(stringInput));
			
			ifProgramContinue = true;
			break;
		case 2:
			String parenthesisInput;
			
			System.out.print("\nInput Parenthesis: ");
			parenthesisInput = input.nextLine(); // Accepts input for Parenthesis Balancing.
			
			System.out.println(parenthesisBalancing(parenthesisInput));
			
			ifProgramContinue = true;
			break;
		case 3:
			System.out.println("\nExiting Program. Program Coded by Colonia, Kurt Robin 2BSIT-2");
			
			ifProgramContinue = false;
			break;
		}
	}
	
	static String reverseString(String input) {
		
		/* The if statement below checks if the input String is empty
		   if it is empty, the method will return a blank. */
		
		if(input.length() == 0)
			return "";
		
		
		/* Substring was used in order to access each letter in the input String.
		   the return value below returns the top-most letter in the string, then
		   the top-most letter is removed from the String input inside of
		   the method reverseString which is called recursively. */
		
		return input.charAt(input.length() -1) + reverseString(input.substring(0, input.length()-1));
		// method returns each character from end to start recursively until there are none left.
	}
	
	static String parenthesisBalancing(String input) {
		
		// String variables to be used in this method.
		
		String balanceOutput = "";
		// Holds the output message of the method.
		
		String parentheses[] = input.split(" ");
		// Initializes the parentheses array based on the given input by the user.
		
		// int variables to be used in this method.
		int openParentheses = 0, closeParentheses = 0, arrSize = parentheses.length;
		/* openParentheses holds the number of opening parentheses.
		   closeParentheses holds the number of closing parentheses.
		   arrSize holds the size of the array for easy access with the for-loop below. */
		
		if(input.length() != 0) { // checks if the length of the input is not empty
			// for-loop. goes through each element inside of parentheses[]
			for(int c = 0; c < arrSize; c++) {
				
				if (parentheses[c].matches("\\w*")){ // checks if there is any word in the input
					balanceOutput = "Input is Invalid. Please only input a Parenthesis";
					return balanceOutput;
				}
				
				switch(parentheses[c].charAt(0)) {
				case '(':
					openParentheses++;
					// if current element is an opening parentheses, we increment openParentheses by 1.
					break;
				case ')':
					closeParentheses++;
					// if current element is a closing parentheses, we increment closeParentheses by 1.
					break;
				}
			}
		}
		else {
			balanceOutput = "Input is Empty.";
			return balanceOutput;
		}
			
			if((openParentheses != closeParentheses) // checks if number of both open and close parentheses are not equal
			|| (parentheses[0].charAt(0) == ')') // checks if the start of user input is a closing parenthesis
			|| (parentheses[arrSize-1].charAt(0)) == '(') { // checks if the end of user input is an opening parenthesis.
				balanceOutput = "Input is Not Balanced.";
			}
			else {
				balanceOutput = "Input is Balanced.";
			}
			
		return balanceOutput; // method returns the output of parenthesisBalancing() method.
	}
}
