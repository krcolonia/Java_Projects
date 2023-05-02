package labActivity5;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BSIT_2__Colonia_David_Singly {
	// Imported Scanner for inputs
	static Scanner input = new Scanner(System.in);
	
	// Input variables
	static Integer mainMenuInput, dataInput, posInput;
	static char subMenuInput;
	
	// Boolean variables for Program Looping
	static boolean ifProgramContinue = true, canTry = true;
	
	// Importing User-Defined Linked List Class
	static LinkedList_byColonia_David linkedList = new LinkedList_byColonia_David();
	
	public static void main(String[] args) {
		
		System.out.println("\nData Structures and Algorithms | Singly Linked List"
				+ "\nProgrammed by Colonia and David from 2BSIT-2, A.Y. 2022-2023");
		
		while(ifProgramContinue) {
			mainMenuInput=0; dataInput=0; posInput=0;
			menu();
			System.gc(); // Garbage collector. Collects all unused (null) objects and deletes them.
		}
	}
	
	static void menu() {
		System.out.println("\nMain Menu:"
						 + "\n1. Insertion"
						 + "\n2. Deletion"
						 + "\n3. Display Linked List"
						 + "\n4. Exit Program");
		
		mainMenuInput();
		
		switch(mainMenuInput) {
		case 1:
			System.out.println("\nInsertion Sub Menu"
							 + "\nA. At the Beginning"
							 + "\nB. At the End"
							 + "\nC. At Any Specified Position"
							 + "\nD. Return to Menu");
			subMenuInput();
			
			switch(subMenuInput) {
			case 'a':
			case 'A':
				System.out.println("\nINSERTION AT THE BEGINNING");
	            dataInput();
	            // Calls method for Insertion at the Beginning from User-Defined Linked List
	            linkedList.insertBeginning(dataInput);
				break;
			case 'b':
			case 'B':
				System.out.println("\nINSERTION AT THE END");
	            dataInput();
	            // Calls method for Insertion at the End from User-Defined Linked List
	            linkedList.insertEnd(dataInput);
				break;
			case 'c':
			case 'C':
					System.out.println("\nINSERTION AT ANY SPECIFIED POSITION");
	            dataInput();
	            posInput();
	            // Calls method for Insertion at any Specified Position from User-Defined Linked List
	            linkedList.insertAnyPosition(dataInput, posInput);
				break;
			case 'd':
			case 'D':
				// This case is simply an option so that user can return to Main Menu
				break;
			default:
				System.out.println("\nInput Invalid, please choose only from choices A to D"
								+  "\nReturning to Main Menu.");
			}
			break;
		case 2:
			System.out.println("\nDeletion Sub Menu"
							 + "\nA. At the Beginning"
							 + "\nB. At the End"
							 + "\nC. At Specified Data"
							 + "\nD. Return to Menu");
			subMenuInput();
	
			switch(subMenuInput) {
			case 'a':
			case 'A':
				System.out.println("\nDELETION AT THE BEGINNING");
				// Calls method for Deletion at the Beginning from User-Defined Linked List
				linkedList.deleteBeginning();
				break;
			case 'b':
			case 'B':
				System.out.println("\nDELETION AT THE END");
				// Calls method for Deletion at the End from User-Defined Linked List
				linkedList.deleteEnd();
				break;
			case 'c':
			case 'C':
				System.out.println("\nDELETION AT SPECIFIED DATA");
				dataInput();
				// Calls method for Deletion at Specified Data from User-Defined Linked List
				linkedList.deleteAtSpecificData(dataInput);
				break;
			case 'd':
			case 'D':
				// This case is simply an option so that user can return to Main Menu
				break;
			default:
				System.out.println("\nInput Invalid, please choose only from choices A to D"
								+  "\nReturning to Main Menu.");
			}
			break;
		case 3:
			System.out.println("\nDISPLAY LINKED LIST\n");
			linkedList.displayLinkedList();
			break;
		case 4:
			
			System.out.println("\nExiting Program. Program Coded by Colonia and David from 2BSIT-2");
			ifProgramContinue = false;
			break;
		default:
			System.out.println("\nInput Invalid. Please only choose from numbers 1 to 4.");
		}
	}
	
	// mainMenuInput() - used to catch errors during input receiving for the Main Menu options
	static void mainMenuInput() {
		do {
			canTry = true;
			try {
				System.out.print("Input option [1-4]: ");
				mainMenuInput = input.nextInt();
				canTry=false;
			}
			catch(InputMismatchException e){
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		}while(canTry);
	}
	
	// subMenuInput() - used to catch errors during input receiving for the Sub Menu options
	static void subMenuInput() {
		do {
			canTry = true;
			try {
				System.out.print("Input option [A-D]: ");
				subMenuInput = input.next().charAt(0);
				canTry=false;
			}
			catch(InputMismatchException e) {
				System.out.println("\nInput Invalid, not a Character. Please try again");
			}
		} while(canTry);
	}
	
	// dataInput() - used to catch errors during input recieving for the Data input
	static void dataInput() {
		do {
			canTry = true;
			try {
				System.out.print("Data: ");
				dataInput = input.nextInt();
				canTry=false;
			}
			catch(InputMismatchException e){
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		}while(canTry);
	}
	
	// posInput() - used to catch errors during input receiving for the Position input
	static void posInput() {
		do {
			canTry = true;
			try {
				System.out.print("Position: ");
				posInput = input.nextInt();
				canTry=false;
			}
			catch(InputMismatchException e){
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		}while(canTry);
	}
}
