package labActivity2;
import java.util.Scanner;

public class BSIT2_Colonia_ArrayA {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); // Declared and initialized Scanner for inputs
		boolean ifProgramRun = true; // Declared and initialized boolean "ifProgramRun" checks if the program would still run based on user input
		
		System.out.println("\nData Structures and Algorithms | Introduction 2A Program"
				+ "\nProgrammed by Kurt Robin P. Colonia from 2BSIT-2, A.Y. 2022-2023");
		
		while(ifProgramRun == true) {
			/* Declared and initialized int variables to be used in Arrays, and Option Select */
			int arraySize = 0, optionSelect = 0;
			
			/* Input for Array Size */
			System.out.print("\nInput Array Size: ");
			arraySize = input.nextInt();
			int intArray[] = new int[arraySize];
			int intArrayHold[] = new int[arraySize];
			
			/* Input for Assigning Array Values */
			System.out.print("\nInput " + arraySize + " values: ");
			for(int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
				intArray[arrayIndex] = input.nextInt();
				intArrayHold[arrayIndex] = intArray[arrayIndex];
			}
			
			System.out.println("\nChoose from the following options:"
							+ "\n1. Sum of N numbers in an array"
							+ "\n2. Maximum and Minimum number"
							+ "\n3. Distinct Number"
							+ "\n4. Exit");
			
			/* Input for selecting an Option */
			System.out.print("\nEnter Option [1-4]: ");
			optionSelect = input.nextInt();
						
			switch(optionSelect) {
				case 1:
					System.out.println("\n1. Sum of N numbers in an array");
					
					int sum = 0;
					
					/* For-Loop. Adds up every single value inside intArray into integer "sum" */
					for(int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
						sum += intArray[arrayIndex];// For every iteration of for-loop, the integer sum gets added to the current intArray index value
					}
					System.out.println("\nSum of " + arraySize + " values: " + sum);
					
					break;
				case 2:
					System.out.println("\n2. Maximum and Minimum number");
					
					/* Declared and initialized variables for Minimum and Maximum Value */
					int minVal = intArray[0];
					int maxVal = intArray[0];
					
					/* For-loop, checks every value inside intArray and checks through if statements to get the lowest and highest value inside the array */
					for(int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
						if(intArray[arrayIndex] >= maxVal) {
							maxVal = intArray[arrayIndex];// Check if current index value is greater than or equal to the current assigned maximum value
						}
						if(intArray[arrayIndex] <= minVal) {
							minVal = intArray[arrayIndex];// Check if current index value is lesser than or equal to the current assigned minimum value
						}
					}
					
					System.out.println("\nMaximum Value: " + maxVal);
					System.out.println("Minimum Value: " + minVal);
					
					break;
				case 3:
					System.out.println("\n3. Distinct Number\n");
					
					System.out.print("Distinct Value: ");
					
					/* Nested For-Loop. Checks if a value inside of intArray has an equal value in a different index and if the index being checked has already been passed */
					for(int arrayIndex=0; arrayIndex < arraySize; arrayIndex++) {
						for (int arrayIndexHold = 0; arrayIndexHold < arraySize; arrayIndexHold++) {
							if(arrayIndex != arrayIndexHold && arrayIndex <= arrayIndexHold && intArray[arrayIndex] == intArrayHold[arrayIndexHold]) {
								intArrayHold[arrayIndexHold] = 0; // If checked value inside intArray has a duplicate, change duplicate value into 0
							}
						}
					}
					
					/* For-Loop. Prints out every distinct value present in intArray */
					for(int arrayIndex = 0; arrayIndex < arraySize; arrayIndex++) {
						if(intArrayHold[arrayIndex] != 0) {
							System.out.print(intArrayHold[arrayIndex] + " ");
						}
					}
					
					System.out.print("\n");
					
					break;
				case 4:
					System.out.println("\nExiting Program. Program Coded by Colonia, Kurt Robin 2BSIT-2");
					/* Boolean condition present in While-Loop. Enters false to stop and terminate program */
					ifProgramRun = false;
					break;
				default:
					/* Default case, proceeds to the start of While-loop in order for the user to be able to choose a valid option */
					System.out.println("\nInvalid Input. Please choose from numbers 1 to 4.\n");
			}
		}
		input.close();
	}
}
