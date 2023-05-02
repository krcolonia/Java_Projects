package reviewAct7;

import java.util.*;

public class MainClass {
	
	// Scanner
	static Scanner input = new Scanner(System.in);
	
	// Personal Info
	static String empID;
	static String lastName;
	static String firstName;
	static String midInit;
	
	// Earnings
	static double basicSal;
	static double incentivePay;
	static double houseRentAllow;
	static double mealAllow;
		
	// Deductions
	static double providentFund;
	static double professionalTax;
	static double loan;
	
	// Array List
	static ArrayList<Employee> emp = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		
		System.out.println("LAB ACT 7\n"
						 + "By: COLONIA, KURT ROBIN P.\n"
						 + "2BSIT-2\n");
		
		userInputMethod();
		
		for(int i = 0; i < emp.size(); i++) {
			printValues(i);
		}
				
	}
	
	static void userInputMethod() {
		
		boolean willAddEmp = true;
		int currentEmp = 0;
		
		while(willAddEmp) {
			
			System.out.println("-------------------------------------------------");
			
			resetInputVals();
			
			emp.add(new Employee(empID, lastName, firstName, midInit, basicSal, incentivePay,
					houseRentAllow, mealAllow, providentFund, professionalTax, loan));
			
			// Personal Information
			String empIDTitle = "Employee ID";
			empID = inputID(empIDTitle);
			
			String lastNameTitle = "Last Name";
			lastName = inputString(lastNameTitle).toUpperCase();
			
			String firstNameTitle = "First Name";
			firstName = inputString(firstNameTitle).toUpperCase();
			
			String midInitTitle = "Middle Intial";
			midInit = inputString(midInitTitle).toUpperCase();
			
			System.out.println("-------------------------------------------------");
			
			// Earnings
			String basicTitle = "Basic";
			basicSal = inputDouble(basicTitle);
			
			String incentivePayTitle = "Incentive Pay";
			incentivePay = inputDouble(incentivePayTitle);
			
			String houseRentAllowTitle = "House Rent Allowance";
			houseRentAllow = inputDouble(houseRentAllowTitle);
			
			String mealAllowTitle = "Meal Allowance";
			mealAllow = inputDouble(mealAllowTitle);
			
			System.out.println("-------------------------------------------------");
			
			// Deductions
			String providentFundTitle = "Provident Fund";
			providentFund = inputDouble(providentFundTitle);
			
			String professionalTaxTitle = "Professional Tax";
			professionalTax = inputDouble(professionalTaxTitle);
			
			String loanTitle = "Loan";
			loan = inputDouble(loanTitle);
			
			
			setValues(currentEmp);
			currentEmp++;
			
			input.nextLine();
			
			boolean invalidYesNo = true;
			
			while(invalidYesNo) {
				System.out.print("\nDo you wish to add a new employee? [ Y / N ]: ");
				String continueInput = input.nextLine().toUpperCase();
				
				switch(continueInput) {
					case "Y":
						System.out.println();
						willAddEmp = true;
						invalidYesNo = false;
						break;
					case "N":
						System.out.println();
						willAddEmp = false;
						invalidYesNo = false;
						break;
					default:
						System.out.println("\nInput is invalid. Please only enter either Y or N.");
				}
			}
		}
		
	}
	
	static void resetInputVals() {
		
		// Personal Info
		empID = "";
		lastName = "";
		firstName = "";
		midInit = "";
		
		// Earnings
		basicSal = 0;
		incentivePay = 0;
		houseRentAllow = 0;
		mealAllow = 0;
			
		// Deductions
		providentFund = 0;
		professionalTax = 0;
		loan = 0;
		
	}
	
	static String inputID(String title) {
		
		String inputID = "";
		
		while(true) {
			try {
				System.out.print(title + ": ");
				inputID = input.nextLine();
				if(inputID.matches("[-\\d]+") && !isSpace(inputID)) { // RegEx for Employee ID. Checks if input consists of only digits
					break;
				}
 				else {
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input. Please only enter a valid ID Number");
			}
		}
		
		return inputID;
		
	}
	
	static String inputString(String title) {
		
		String inputString = "";
		
		while(true) {
			try {
				System.out.print(title + ": ");
				inputString = input.nextLine();
				if(inputString.matches("[A-Za-z\\.\s]+") && !isSpace(inputString)) { // RegEx for String inputs. Checks if input consits of only Alphabet, period, and whitespace
					break;
				}
				else {
					throw new InputMismatchException();
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please only enter Alphabetic Symbols");
			}
		}
		
		return inputString;
	}
	
	static double inputDouble(String title) {
		
		double inputDouble = 0;
		
		while(true) {
			try {
				System.out.print(title + ": ");
				inputDouble = input.nextDouble();
				break;
			}
			catch (InputMismatchException e) {
				System.out.println("test error int");
				input.nextLine();
			}
		}
		
		return inputDouble;
	}
	
	static boolean isSpace(String inputString) {
		String check = inputString.trim();
		return check.isEmpty();
	}
	
	static void setValues(int i) {
		
		// Setting Personal Info
		emp.get(i).setEmpID(empID);
		emp.get(i).setLastName(lastName);
		emp.get(i).setFirstName(firstName);
		emp.get(i).setMidInit(midInit);
		
		// Setting Earnings Info
		emp.get(i).setBasicSal(basicSal);
		emp.get(i).setIncentivePay(incentivePay);
		emp.get(i).setHouseRentAllow(houseRentAllow);
		emp.get(i).setMealAllow(mealAllow);
		
		// Setting Deductions Info
		emp.get(i).setProvidentFund(providentFund);
		emp.get(i).setProfessionalTax(professionalTax);
		emp.get(i).setLoan(loan);
		
	}
	
	static void printValues(int i) {
		
		System.out.println("\n------------------------------------------------------------------------------------\n"
						 + "------------------------------ EMPLOYEE " + (i+1) + " PAYSLIP ----------------------------------\n"
						 + "------------------------------------------------------------------------------------");
		
		// Get Personal Info
		System.out.println("Employee ID: " + emp.get(i).getEmpID() + "\n"
						 + "Employee Name: " + emp.get(i).getFullName());
		
		System.out.println("------------------------------------------------------------------------------------\n"
						 + "EARNINGS\n"
						 + "------------------------------------------------------------------------------------");
		
		// Get Earnings Info
		System.out.println("Basic:\t\t\t" + emp.get(i).getBasicSal() + "\n"
						 + "Incentive Pay:\t\t" + emp.get(i).getIncentivePay() + "\n"
						 + "House Rent Allowance:\t" + emp.get(i).getHouseRentAllow() + "\n"
						 + "Meal Allowance:\t\t" + emp.get(i).getMealAllow());
		
		System.out.println("------------------------------------------------------------------------------------\n"
				 		 + "DEDUCTIONS\n"
				 		 + "------------------------------------------------------------------------------------");
		
		// Get Deductions Info
		System.out.println("Provident Fund:\t\t" + emp.get(i).getProvidentFund() + "\n"
						 + "Professional Tax:\t" + emp.get(i).getProfessionalTax() + "\n"
						 + "Loan:\t\t\t" + emp.get(i).getLoan());
		
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println("Total Earnings =>\t" + emp.get(i).getTotalEarn() + "\n"
						 + "Total Deductions =>\t" + emp.get(i).getTotalDeduct() + "\n"
						 + "NET PAY =>\t\t" + emp.get(i).getNetPay());
		
		System.out.println("------------------------------------------------------------------------------------\n");
	}
}
