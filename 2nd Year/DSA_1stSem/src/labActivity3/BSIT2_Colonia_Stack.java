package labActivity3;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

public class BSIT2_Colonia_Stack {
	// Imported Scanner for Input
	static Scanner input = new Scanner(System.in);
	
	// Stack Initialization Variables
	static Integer stack[], elementInitial = 0;
	
	// Input Variables
	static Integer stackLength = 0, menuInput = 0, pushInt = 0;
	static boolean sizeIsValid, ifProgramRun =  true, canTry = true;
	
	// Output Variables
	static Integer topVal = 0, stackSize = 0;
	static boolean isEmpty;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		printDelay("\n\t[ ------------ LOADING PROGRAM ------------- ]\n", TimeUnit.MILLISECONDS, 80);
		
		System.out.println("\n\tData Structures and Algorithms | Stack Program"
				+ "\nProgrammed by Kurt Robin P. Colonia from 2BSIT-2, A.Y. 2022-2023\n");
		
		input();
		while(ifProgramRun == true) {
			try {
				menu();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static void input() {
		while(sizeIsValid == false) {
			
			do {
				canTry=true;
				try {
					System.out.print("How many elements will this stack have?: ");
					stackLength = input.nextInt();
					canTry=false;
				}
				catch(InputMismatchException e) {
					System.out.println("Input Invalid. Please only enter an Integer.\n");
					input.nextLine();
				}
			} while(canTry);
			
			if(stackLength <= 0) {
				System.out.println("\nInput invalid, please only set a stack size greater than 0\n");
			}
			else {
				stack = new Integer[stackLength];
				sizeIsValid = true;
			}
		}
		
		
		while(elementInitial < stackLength) {
			stack[elementInitial] = null;
			elementInitial++;		
		}
		System.out.println("Stack with a length of " + stackLength + " created");
	}

	static void menu() throws InterruptedException {
		do {
			canTry=true;
			try {
				System.out.println("\nMAIN MENU:"
						 + "\n1. PUSH"
						 + "\n2. POP"
						 + "\n3. TOP"
						 + "\n4. SIZE"
						 + "\n5. EMPTY"
						 + "\n6. DISPLAY STACK"
						 + "\n7. EXIT PROGRAM\n");
				
				System.out.print("Enter Choice [1-7]: ");
				menuInput = input.nextInt();
				canTry=false;
			}
			catch(InputMismatchException e) {
				System.out.println("Input Invalid. Please only enter an Integer.");
				input.nextLine();
				continue;
			}
		} while(canTry);
		
		
		switch(menuInput) {
		case 1:
			System.out.println("\n[ PUSH ELEMENT INTO STACK ]\n");
			do {
				canTry=true;
				try {
					System.out.println("\n" + push());
					canTry=false;
				}
				catch(InputMismatchException e) {
					System.out.println("Input Invalid. Please only enter an Integer.\n");
					input.nextLine();
				}
			} while(canTry);
			break;
		case 2:
			System.out.println("\n[ POP ELEMENT OUT OF STACK ]\n");
			printDelay("[ ------- LOADING -------- ]\n\n", TimeUnit.MILLISECONDS, 100);
			pop();
			break;
		case 3:
			System.out.println("\n[ TOP ELEMENT OF STACK ]\n");
			printDelay("[ ----- LOADING ------ ]\n\n", TimeUnit.MILLISECONDS, 100);
			System.out.println(top());
			break;
		case 4:
			System.out.println("\n[ CURRENT SIZE OF STACK ]\n");
			printDelay("[ ------ LOADING ------ ]\n\n", TimeUnit.MILLISECONDS, 100);
			System.out.println(size());
			break;
		case 5:
			System.out.println("\n[ VERIFYING STACK EMPTINESS ]\n");
			printDelay("[ -------- LOADING -------- ]\n\n", TimeUnit.MILLISECONDS, 100);
			System.out.println(empty());
			break;
		case 6:
			System.out.println("\n[ DISPLAY STACK ]\n");
			printDelay("[ -- LOADING -- ]\n\n", TimeUnit.MILLISECONDS, 100);
			display();
			break;
		case 7:
			System.out.println("\nExiting Program. Programmed by Colonia, Kurt Robin 2BSIT-2, A.Y. 2022-2023.");
			ifProgramRun = false;
			break;
		default:
			System.out.print("Invalid Input. Please only enter from numbers 1 to 7.\n");
			
		}
	}

	static String push() throws InterruptedException {
		String pushResult = "";
		
		System.out.print("Enter an Integer Number: ");
		pushInt = input.nextInt();
		
		printDelay("\n[ ------- LOADING ------- ]\n", TimeUnit.MILLISECONDS, 100);
		
		for(int pushElement = 0; pushElement < stackLength; pushElement++) {
			if(stack[pushElement] == null) {
				stack[pushElement] = pushInt;
				pushResult = "Element pushed into stack successfully.";
				break;
			}
			else {
				pushResult = "Stack Overflow. Element cannot be pushed.";
			}
		}
		
		return pushResult;
	}

	static String pop() {
		String pushResult = "";
		
		for(int popElement = stackLength-1; popElement >= 0; popElement--) {
			if(stack[popElement] != null) {
				stack[popElement] = null;
				System.out.println("Element popped out of stack");
				break;
			}
			else if(stack[popElement] == null && popElement == 0){
				System.out.println("Cannot pop element. Stack is currently empty.");
				break;
			}
		}
		
		return pushResult;
	}

	static String top() {
		String topResult = "";
		
		for(int topElement = stackLength-1; topElement >= 0; topElement--) {
			if(stack[topElement] != null) {
				topVal = stack[topElement];
				break;
			}
			else {
				topVal=null;
				continue;
			}
		}
		
		if(topVal != null) {
			topResult = "Top Element's Value is: " + topVal;
		}
		else {
			topResult = "Cannot find top element. Stack is currently empty.";
		}
		
		return topResult;
	}

	static String size() {
		String sizeResult = "";
		
		for(int topElement = stackLength-1; topElement >= 0; topElement--) {
			if(stack[topElement] != null) {
				stackSize = topElement+1;
				break;
			}
			else {
				stackSize=null;
				continue;
			}
		}
		
		if(stackSize != null) {
			sizeResult = "Current Stack Size is: " + stackSize;
		}
		else {
			sizeResult = "Cannot specify stack size. Stack is currently empty";
		}
		
		return sizeResult;
	}

	static String empty() {
		String emptyResult = "";
		
		for(int emptyElement = stackLength-1; emptyElement >=0; emptyElement--) {
			if(stack[emptyElement]!=null) {
				isEmpty = false;
			}
			else {
				isEmpty = true;
			}
		}
		
		if(isEmpty) {
			emptyResult = "Stack is empty. Value from empty() is " + isEmpty;
		}
		else {
			emptyResult = "Stack is not empty. Value from empty() is " + isEmpty;
		}
		
		return emptyResult;
	}

	static void display() {
		
		for(int emptyElement = stackLength-1; emptyElement >=0; emptyElement--) {
			if(stack[emptyElement]!=null) {
				isEmpty = false;
			}
			else {
				isEmpty = true;
			}
		}
		
		for(int displayElement = 0; displayElement < stackLength; displayElement++) {
			if(stack[displayElement] != null) {
				System.out.print(stack[displayElement] + "  ");
			}
		}
		
		if(isEmpty) {
			System.out.print("Cannot display any elements. Stack is currently empty");
		}
		
		System.out.print("\n");
	}
	
	static void printDelay(String printOut, TimeUnit unit, long delay) throws InterruptedException {
	    for (char ch:printOut.toCharArray()) {
	        System.out.print(ch);
	        unit.sleep(delay);
	    }
	}
	
	/* Programmed by:
	 * Colonia, Kurt Robin P.
	 * 2BSIT-2, A.Y 2022-2023 */
	
}
