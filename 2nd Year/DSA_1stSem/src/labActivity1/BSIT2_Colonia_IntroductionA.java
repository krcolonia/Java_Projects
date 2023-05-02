package labActivity1;
import java.util.Scanner;

public class BSIT2_Colonia_IntroductionA {

	public static void main(String[] args) {
		
		/* Imported Scanner for inputs */
		Scanner input = new Scanner(System.in);
		
		/* Boolean to check if the Program is still running */
		boolean ifProgramRun = true;
		
		/* Additional Header for my Program */
		System.out.println("\nData Structures and Algorithms | IntroductionA Program"
							+ "\nProgrammed by Kurt Robin P. Colonia from 2BSIT-2, A.Y. 2022-2023\n");
		
		/* While Loop for the Menu and Options 1 to 6 */
		while(ifProgramRun == true) {
			
			/* Integer that holds our Input Integer */
			int intVal=0, optionInput, intValToModify=0, intValReversed = 0, intValSum = 0;
			/*
			 * intVal holds our Input Integer, this is so that the value does not get modified.
			 * optionInput is what holds our values for the option input.
			 * intValToModify copies the value of intVal so that it can be modified in each switch case that gets used.
			 * intValReversed stores the reversed value of our intVal.
			 * intValSum stores the sum of each individual digit in our input integer intVal.
			 */
			
			/* Integer Input */
			System.out.print("Input your Integer Value: ");
			intVal = input.nextInt();
			intValToModify = intVal;
			
			/* Console output showing the Menu and selectable options */
			System.out.println("\nChoose from the following options:"
							+ "\n1 - Sum of Digits"
							+ "\n2 - Reverse the Number"
							+ "\n3 - Display all the prime numbers from 2 to n"
							+ "\n4 - Palindrome Checking"
							+ "\n5 - Odd or Even Number"
							+ "\n6 - Exit Program");
			
			System.out.print("\nEnter Option [1-6]: ");
			optionInput = input.nextInt();
			
			/* Switch Case for every Option */
			switch(optionInput) {
				case 1:
					/* Case 1 : Sums up each digit in our input integer */
					System.out.println("\n====================================================================\n");
					System.out.println("\n1 - Sum of Digits\n");
					
					
					/* This while loop reverses the input integer by taking the remainder of our integer divided by 10, which leaves the number
					 * in the ones place and assigns it to intValReversed. The integer in the ones place then gets removed from intValToModify
					 * by dividing the variable by 10. */
					while(intValToModify != 0) {
				    	intValReversed = intValReversed * 10 + intValToModify % 10;
				        intValToModify /= 10;
				    }
					
				    System.out.print("The sum of each digit in the integer " + intVal + " is ");
				    
				    /* This while loop then takes the remainder of the reversed integer divided by 10 so that only the number in the ones place value gets left and
				     * printed onto the console.
				     */
				    while(intValReversed > 0) {
				        System.out.print((intValReversed % 10));

				        intValSum = intValSum + (intValReversed % 10);
				        intValReversed /= 10;
				        
				        if (intValReversed > 0) {
				            System.out.print(" + ");
				        }
				    }
				   
				    /* This println prints out onto the console the sum of each digit from our input integer */
				    System.out.println(" = " + intValSum);
					
				    System.out.print("\n"
									+"\n====================================================================\n\n");
					
					break;
				case 2:
					/* Case 2 : Code for reversing our input integer */
					System.out.println("\n====================================================================\n");
					System.out.println("\n2 - Reverse The Number\n");
					
					/* This while loop takes the last value of our input integer and assigns it to intValReversed until all values are added in reverse order. */
					while(intValToModify !=0) {
						/* int lastDigit is where the last digit of our intVal gets assigned to before it gets assigned to intValReversed */
						int lastDigit = intValToModify % 10;
						intValReversed = intValReversed * 10 + lastDigit;
						
						intValToModify /= 10;
					}
					
					System.out.println("The reverse of the integer " + intVal + " is " + intValReversed);
					
					System.out.print("\n"
									+"\n====================================================================\n\n");
					
					break;
				case 3:
					/* Case 3 : Code for displaying prime numbers between the number 2 and our input integer */
					System.out.println("\n====================================================================\n\n"
									+ "\n3 - Display all the prime numbers from 2 to n\n");
					
					/* int primeVal array is where our input gets assigned to. its number of indexes is based off of our input integer.
					 * primeValHolder array copies the contents of primeVal array and acts like intValToModify, wherein it is the array
					 * that gets modified so that the values inside primeVal array does not get modified. */
					int primeVal[] = new int[intValToModify+1], primeValHolder[] = new int[intValToModify+1];
					/* boolean primeValBool is a boolean array that holds the same amount of indexes as primeVal. It marks whether or not
					 * the value in a specific index is a prime number or not*/
					boolean primeValBool[] = new boolean[intValToModify+1];
					
					/* This for loop fills up the primeVal primeValHolder, and primeValBool arrays to the exact amount of indexes that
					 * the input integer intends. */
					for(int i = 0; i <= intValToModify; i++) {
						primeVal[i] = i;
						primeValHolder[i] = primeVal[i];
						primeValBool[i] = true;
					}
					
					/* This for loop goes through every value inside of our primeValBool. each index serves as one value and determines which
					 * value is a prime number or not */
					for(int p = 2; p * p <= intValToModify; p++) {
						if(primeValBool[p] == true) {
							for(int i = p * p; i <= intValToModify; i += p) {
								primeValBool[i] = false;
							}
						}
					}
					
					/* This for loop prints out every value in the primeValHolder array and prints it out to the console to show which numbers get
					 * factored out and leaves the prime numbers on to the very first value of each line. */
					for(int i = 2; i <= intValToModify; i++) {
						for(int j = 2; j <= intValToModify;j++) {
							if(primeValHolder[j]!=0 && primeValBool[i]==true) {
								System.out.print(primeValHolder[j] + " ");
							}
							if(j%i==0 && primeValBool[i] == true) {
								primeValHolder[j] = 0;
							}
						}
						if(primeValBool[i] == true)
						System.out.print("\n");
					} 
					
					System.out.print("\n");
					
					/* This for loop prints out the prime numbers present in between 2 and our given input integer. */
					for (int i = 2; i <= intValToModify; i++) {
						if(primeValBool[i] == true) {
							System.out.print(primeVal[i] + " ");
							
						}
					}
					
					System.out.print("\n\n"
									+"\n====================================================================\n\n");
					
					break;
				case 4:
					/* Case 4 : Palindrome Checking */
					System.out.println("\n====================================================================\n");
					System.out.println("\n4 - Palindrome Checking\n");
					
					/* The code for this while loop is the same as the code for my Case 2 : Reversing our Integer Input */
					while(intValToModify !=0) {
						int lastDigit = intValToModify % 10;
						intValReversed = intValReversed * 10 + lastDigit;
						
						intValToModify /= 10;
					}
					
					/* This If-Else statement compares our reversed value to our original input integer and checks if the value between
					 * the two variables are indeed equal and is a Palindrome. */
					if(intValReversed == intVal) {
						System.out.println("The integer " + intVal + " is a Palindrome.\n");
					}
					else {
						System.out.println("The integer " + intVal + " is not a Palindrome.\n");
					}
					
					System.out.print("\n====================================================================\n\n");
					
					break;
				case 5:
					/* Case 5 : Odd or Even number */
					System.out.println("\n====================================================================\n");
					System.out.println("\n5 - Odd or Even Number");
					
					
					/* This If-Else statement checks whether or not our Input Integer has a remainder of 0 if it is divided 
					 * by 2. Through this, the program determines whether or not our input integer is an Odd or Even number.*/
					if(intVal % 2 == 0) {
						System.out.println("\nThe integer " + intVal + " is an even number.\n");
					}
					else {
						System.out.println("\nThe integer " + intVal + " is an odd number.\n");
					}
					
					System.out.print("\n====================================================================\n\n");
					
					break;
				case 6:
					/* Case 6 : Exit the Program */
					System.out.println("\n====================================================================\n");
					System.out.println("\nExiting Program. Program Coded by Colonia, Kurt Robin 2BSIT-2");
					
					/* This boolean checks whether or not our program is still running or not. It is connected to the While-loop
					 * that runs all of my code, starting from when it takes in input from the user, to options 1-6. Case 6 turns
					 * the value of ifProgramRun to false so that when it returns to our while loop condition, it terminates the
					 * whole program. */
					ifProgramRun = false;
					
					System.out.print("\n\n====================================================================\n\n");
					
					break;
				default:
					/* The default case. This case only gets used if the input on the optionInput is invalid (which only accepts 1 to 6). */
					System.out.println("\n====================================================================\n\n"
									+ "\nInvalid Input, please choose from numbers 1 to 6.\n"
									+ "\n\n====================================================================\n");
			}
		}
		
		/* This line of code closes our imported Scanner input */
		input.close();
		
		/* Program coded by Kurt Robin Colonia of 2BSIT-2, Academic Year 2022-2023 */
	}

}
