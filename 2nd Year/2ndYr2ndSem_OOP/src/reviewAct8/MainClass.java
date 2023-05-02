package reviewAct8;

import java.util.*;

public class MainClass {
	
	// Global Variables for Inputs
	static String name, major, stuID;
	static int yob, nos;
	
	static int currentStud = 0;
	
	// Boolean for While Loops
	static boolean firstStudent = true;
	static boolean willRun = true;
	
	// Scanner for Inputs
	static Scanner strInput = new Scanner(System.in);
	static Scanner intInput = new Scanner(System.in);
	
	static ArrayList<Student> stuArr = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		System.out.println("LAB ACT 8 - INHERITANCE\n"
				 		 + "By: COLONIA, KURT ROBIN P.\n"
				 		 + "2BSIT-2\n");
		while(willRun) {
			userInput();
		}
		
		for(int i = 0; i < stuArr.size(); i++) {
			stuArr.get(i).printInfo();
		}
		
	}
	
	static void userInput() {
		stuArr.add(new Student(name, yob, stuID, major, nos));
		
		String nameTitle = "Enter Student Name";
		name = inputString(nameTitle);
		
		String yobTitle = "Enter Birth Year";
		yob = inputInt(yobTitle);
		
		String stuIDTitle = "Enter ID Number";
		stuID = inputID(stuIDTitle);
		
		String majorTitle = "Enter Program";
		major = inputString(majorTitle);
		
		if(firstStudent) {
			String nosTitle = "Enter No of Student";
			nos = inputInt(nosTitle);
			firstStudent = false;
		}
		else {
			++nos;
		}
		
		setValues(currentStud);
		resetInputVals();
		
		yesNoLoop: while(true) {
			String yesNoTitle = "\nDo you want to add a new student? [ Y / N ]";
			String continueInput = inputString(yesNoTitle).toUpperCase();
			
			switch(continueInput) {
			case "Y":
				System.out.println();
				willRun = true;
				break yesNoLoop;
			case "N":
				System.out.println();
				willRun = false;
				break yesNoLoop;
			default:
				System.out.println("\nInput Invalid. Please only enter either 'Y' or 'N'.");
			}
		}
	}
	
	static void resetInputVals() {
		name = "";
		yob = 0;
		stuID = "";
		major = "";
	}
	
	static void setValues(int i) {
		stuArr.get(i).setName(name);
		stuArr.get(i).setYOB(yob);
		stuArr.get(i).setStuID(stuID);
		stuArr.get(i).setMajor(major);
		stuArr.get(i).setNos(nos);
		currentStud++;
	}
	
	static String inputID(String title) {
		
		String inputID = "";
		
		while(true) {
			try {
				System.out.print(title + ": ");
				inputID = strInput.nextLine();
				if(inputID.matches("[-\\d]+") && !isSpace(inputID)) { // RegEx for Employee ID. Checks if input consists of only digits
					break;
				}
 				else {
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input. Please only enter a valid ID Number.");
			}
		}
		
		return inputID;
		
	}
	
	static String inputString(String title) {
		
		String inputString = "";
		
		while(true) {
			try {
				System.out.print(title + ": ");
				inputString = strInput.nextLine();
				if(inputString.matches("[A-Za-z\\.\s]+") && !isSpace(inputString)) { // RegEx for String inputs. Checks if input consits of only Alphabet, period, and whitespace
					break;
				}
				else {
					throw new InputMismatchException();
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please only enter Alphabetic Symbols.");
			}
		}
		
		return inputString;
	}
	
	static int inputInt(String title) {
		
		int inputInt = 0;
		
		while(true) {
			try {
				System.out.print(title + ": ");
				inputInt = intInput.nextInt();
				break;
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please only enter Integer Values.");
			}
		}
		
		return inputInt;
	}
	
	static boolean isSpace(String inputString) {
		String check = inputString.trim();
		return check.isEmpty();
	}
	
}
