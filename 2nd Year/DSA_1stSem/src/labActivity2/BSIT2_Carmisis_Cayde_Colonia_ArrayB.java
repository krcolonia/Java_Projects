package labActivity2;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class BSIT2_Carmisis_Cayde_Colonia_ArrayB {
	/* Declared and Initialized imported classes for input, decimal formatting, and */
	static DecimalFormat df = new DecimalFormat ("#00.00");
	static Scanner input = new Scanner(System.in);
	static PrintWriter outputFile;
	
	/* Declared and Initialized variables */
	static int studIndex, quizIndex, passed, failed;
	static double gradeBook[][], recordToDelete[][], average[];
	static boolean ifProgramRun = true, inputIsValid = false;
	static String remarks[];
	
	/* Input receiving variables */
	static int mainMenuInput, studNum;
	
	/* Main method where the program runs as a whole.
	 * Makes use of try-catch-finally to be able to run the program and catch errors without terminating the program 
	 * FileNotFoundException is an exception that gets called if ever the given directory inside outputFile is invalid*/
	public static void main(String[] args) {
		
		System.out.println("\nData Structures and Algorithms | Introduction 2B Program"
				+ "\nProgrammed by Carmisis, Cayde, Colonia from 2BSIT-2, A.Y. 2022-2023\n");
		
		try {
			
			userInput();
			
			while(ifProgramRun == true) {
				outputFile = new PrintWriter("../DSA_1stSem/src/labActivity2/Student.txt");
				// Initialization of PrintWriter outputFile, which creates Student.txt in the specified directory
				
				mainMenu();
				printTable();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR - FILE NOT FOUND"); // Prints out ERROR message if ever
		}
		finally {
			outputFile.close(); // Closes outputFile so that it can print out to Student.txt
		}
	}
	
	/* mainMenu : method that stores the options, input, and switch cases for the options .
	 * Makes use of a switch case that depends on the value given to mainMenuInput.
	 * Cases 1-3 calls the methods for View, Update, and Delete respectively.
	 * Case 4 executes the while-loop in main method, which then ends the program .
	 * An invalid input will make the program output message inside default case.*/
	static void mainMenu() {
		System.out.println("\nMain Menu:"
							+ "\n1. View Grade Book"
							+ "\n2. Update Student Record"
							+ "\n3. Delete Student Record"
							+ "\n4. Exit Program");
		
		System.out.print("\nEnter Input [1-4]: ");
		mainMenuInput = input.nextInt();
		
		switch(mainMenuInput) {
		case 1:
			System.out.println("\nView Menu:");
			viewTable();
			break;
		case 2:
			System.out.println("\nUpdate Menu:");
			updateRecord();
			break;
		case 3:
			System.out.println("\nDelete Menu:");
			deleteRecord();
			break;
		case 4:
			System.out.println("\nExiting Program. Program coded by Carmisis, Cayde, Colonia from 2BSIT-2.");
			ifProgramRun = false;
			break;
		default:
			System.out.println("\nInvalid Input. Please choose only from numbers 1 to 4.");
		}
	}
	
	/* averageCalc() - A method that calculates the average of every student.
	 * Makes use of a nested loop that goes through every student in the outer loop, and goes through every quiz of a student in the inner loop
	 * The method makes use of double array average[] to store the average of every student's quiz.
	 * The double sum holds the sum of every quiz of a student by adding up the quizzes to the current value of sum. 
	 * The values of average[row] is then assigned by dividing sum to the given quizIndex. */
	static void averageCalc() {
		average = new double[studIndex]; 
		
		for(int row = 0; row < studIndex; row++) {
			double sum = 0;
			for(int col = 0; col < quizIndex; col++) {
				sum += gradeBook[row][col];
			}
			if(row>0) { 
				average[row] = sum/quizIndex;
			}
			
		}
	}
	
	/* remarkChecker() - method that checks if the calculated average of a student is passed or failed.
	 * Makes use of a for-loop to go through the average of every student.
	 * The String array remarks[] stores the remarks of every student (Passed or Failed).
	 * The integer passed stores the amount of students with a passing grade.
	 * The integer failed stores the amount of students with a failing grade. 
	 * If-Else statement checks if the average of students stored in average[] has a passing grade or not. */
	static void remarkChecker() {
		remarks = new String[studIndex];
		passed=0;
		failed=0; 
		
		for(int row = 0; row < studIndex; row++) { /* for-loop that goes through every student (row) */
			if(average[row] >= 75 && row > 0) {
				passed++; // increments current value of students passed
				remarks[row] = "Passed"; // stores "Passed" to current student
			}
			else if(average[row] < 75 && average[row] >= 0 && row > 0){
				failed++; // increments current value of students failed
				remarks[row] ="Failed"; // stores "failed to current student
			}
		}
	}
	
	/* userInput() - method that contains code for taking in the initial input of students and quizzes.
	 * Makes use of of a nested loop that goes through every student in the outer loop, and goes through every quiz of a student in the inner loop.
	 * While-loop inside of the nested-loop checks if input quizScore is valid or not.
	 * The integer studIndex stores the given number of students from user input. 
	 * The integer quizIndex stores the given number of quizzes from user input. 
	 * gradeBook[][] and recordToDelete[][] stores all of the records of every student and every quiz grade they have.
	 * The double quizScore stores the input grade of the user for the specified quiz number. */
	static void userInput() {
		System.out.print("Number of Students: ");
		studIndex = input.nextInt();
		studIndex+=1; // adds 1 to current studIndex value 
		// This is done because index 0 of studIndex will serve as the header/title row for table, and thus should not store values 

		System.out.print("Number of Quizzes: ");
		quizIndex = input.nextInt(); 
		
		gradeBook = new double[studIndex][quizIndex];
		recordToDelete = new double[studIndex][quizIndex];
		
		for(int insertRow = 0; insertRow < studIndex; insertRow++) { 
			
			double quizScore = 0.0;
			
			if(insertRow > 0) {
				System.out.println("\nStudent #" + insertRow);
				for(int insertCol = 0; insertCol < quizIndex; insertCol++) {
					inputIsValid = false;
					while(inputIsValid == false) {
						System.out.print("Quiz " + (insertCol+1) + ":\t\t");
						quizScore = input.nextDouble(); 
						
						if(quizScore >= 0) {
							gradeBook[insertRow][insertCol] = quizScore; // sets quizScore value inside gradeBook[][]
							recordToDelete[insertRow][insertCol] = quizScore; // sets quizScore value inside recordToDelete[][]
							inputIsValid = true;
						}
						else {
							System.out.println("Invalid input. Please only input a number greater than or equal to 0");
							inputIsValid = false;
						}
						
					}
				}
				averageCalc();
				remarkChecker();
				System.out.println("Average:\t" + df.format(average[insertRow])); // prints out the average of a student
				System.out.println("Remarks:\t" + remarks[insertRow]); // prints out the remarks given to a student
			}
		}
		
		System.out.println("\nNumber of students passed: " + passed); // displays number of passed students
		System.out.println("Number of students failed: " + failed); // displays number of failed students
	}
	
	/* viewTable() - method containing code that prints out gradeBook[][] in table format inside Console .
	 * the code from printTable is exactly the same, only this method prints out on the Console.
	 * the method only prints out the available values, deleted values are not printed out. */
	static void viewTable(){
		System.out.print("\t");
		for(int printRow = 0; printRow < studIndex; printRow++) {
			if(printRow > 0 && average[printRow] >= 0) {
				System.out.print("Student #" + (printRow)); // prints out current student number
			}
			else {
				System.out.print("");
			}
			for(int printCol = 0; printCol < quizIndex; printCol++) {
				if(printRow == 0) { 
					System.out.print("\tQuiz " + (printCol+1) + "\t"); // prints out title of every quiz number column
				}
				else if(gradeBook[printRow][printCol] < 0){
					System.out.print("");
				}
				else {
					System.out.print("\t" + df.format(gradeBook[printRow][printCol]) + "\t"); // prints out the grade for the current quiz column it corresponds with
				}
			}
			if(printRow==0) {
				System.out.print("\tAverage\t" + "\tRemarks\t\n"); // prints out the title for average and remarks column
			}
			else if(average[printRow] < 0) {
				System.out.print("");
			}
			else {
				System.out.print("\t" + df.format(average[printRow]) + "\t" + "\t" + remarks[printRow] + "\t"  + "\n"); // prints out the average and remarks of a student
			}
		}
		System.out.println("\nNumber of students passed: " + passed); // prints out number of passed students
		System.out.println("Number of students failed: " + failed); // prints out number of failed students
	}
	
	/* printTable() - method containing code that prints out gradeBook[][] in table format in Student.txt.
	 * the code from viewTable is exactly the same, only this method prints out on Student.txt.
	 * the method only prints out the available values, deleted values are not printed out. */
	static void printTable(){
		outputFile.print("\t");
		for(int printRow = 0; printRow < studIndex; printRow++) {
			if(printRow > 0 && average[printRow] >= 0) {
				outputFile.print("Student #" + (printRow)); // prints out current student number
			}
			else {
				outputFile.print("");
			}
			for(int printCol = 0; printCol < quizIndex; printCol++) {
				if(printRow == 0) {
					outputFile.print("\tQuiz " + (printCol+1) + "\t"); // prints out title of every quiz number column
				}
				else if(gradeBook[printRow][printCol] < 0){
					outputFile.print("");
				}
				else {
					outputFile.print("\t" + df.format(gradeBook[printRow][printCol]) + "\t"); // prints out the grade for the current quiz column it corresponds with
				}
			}
			if(printRow==0) {
				outputFile.print("\tAverage\t" + "\tRemarks\t\n"); // prints out the title for average and remarks column
			}
			else if(average[printRow] < 0) {
				outputFile.print("");
			}
			else {
				outputFile.print("\t" + df.format(average[printRow]) + "\t" + "\t" + remarks[printRow] + "\t"  + "\n"); // prints out the average and remarks of a student
			}
		}
		outputFile.println("\nNumber of students passed: " + passed); // prints out number of passed students
		outputFile.println("Number of students failed: " + failed); // prints out number of failed students
	}
	
	/* updateRecord() - method containing code used to update a specified student's quiz record.
	 * The integer studNum stores the input student number given by the user.
	 * If-else statement checks if given student number is valid and if the student number is a deleted record. 
	 * Makes use of a for-loop that goes through every quiz in the specified student number.
	 * While-loop inside of the for-loop checks if input quizScore is valid or not.
	 * The double quizScore stores the input grade of the user for the specified quiz number. */
	static void updateRecord() {
		System.out.print("Input Student Number: ");
		studNum = input.nextInt();
		
		double quizScore = 0.0;
			
		if(studNum > 0 && studNum < studIndex && average[studNum] >= 0) {
			System.out.println("\nStudent #" + studNum);
			for(int insertCol = 0; insertCol < quizIndex; insertCol++) {
				inputIsValid = false;
				while(inputIsValid == false) {
					System.out.print("Quiz " + (insertCol+1) + ":\t\t");
					quizScore = input.nextDouble(); 
					
					if(quizScore >= 0) {
						gradeBook[studNum][insertCol] = quizScore; // sets quizScore value inside gradeBook[][]
						recordToDelete[studNum][insertCol] = quizScore; // sets quizScore value inside recordToDelete[][]
						inputIsValid = true;
					}
					else {
						System.out.println("Invalid input. Please only input a number greater than or equal to 0");
						inputIsValid = false;
					}
					
				}
			}
				averageCalc();
				remarkChecker();
				
				System.out.println("Average:\t" + df.format(average[studNum]));
				System.out.println("Remarks:\t" + remarks[studNum]);
				
				System.out.println("\nNumber of students passed: " + passed);
				System.out.println("Number of students failed: " + failed);
			}
		else {
			System.out.println("\nRecord not Found");
		}
	}
	
	/* deleteRecord : method containing code used to delete a specified student's record from gradeBook[][].
	 * The integer studNum accepts the student number to be deleted from the user.
	 * If-else statement checks if given student number is valid and if the student number is a deleted record. 
	 * Makes use of a for-loop and a nested loop.
	 * First for-loop assigns a negative value to every quiz in the specified student record to delete.
	 * First nested loop assigns all values in recordToDelete[][] to gradeBook[][] (including record with negative values). */
	static void deleteRecord() {
		System.out.print("Input Student Number: ");
		studNum = input.nextInt();
		
		if(studNum > 0 && studNum < studIndex && average[studNum] >= 0) { 
			for(int deleteCol = 0; deleteCol < quizIndex; deleteCol++) {
				recordToDelete[studNum][deleteCol] = -50;
			}
			
			gradeBook = new double[studIndex][quizIndex];
			
			for(int newRow = 0; newRow < studIndex; newRow++) {
				for(int newCol = 0; newCol < quizIndex; newCol++) {
					gradeBook[newRow][newCol] = recordToDelete[newRow][newCol];
				}
			}
			
			averageCalc();
			remarkChecker();
			
			System.out.println("Deleted Student " + studNum + "'s Record");
		}
		else {
			System.out.println("\nRecord not Found"); 
		}
		
	}
	
	/* Program Coded by:
	 * Carmisis, Jelly Mae
	 * Cayde, Jeremee Carreon
	 * Colonia, Kurt Robin
	 * 2BSIT-2, A.Y. 2022-2023 */
	
}