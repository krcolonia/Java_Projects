package reviewAct6;

import java.util.Scanner;

public class MainClass {
	
	 // Personal Data
	static String lastName;
	static String firstName;
	static String midInit;
	static int age;
	static String gender;
	static String birthDate;
	static String placeOfBirth;
	static String religion;
	static String civStat;
	
	// Contact Information
	static String strtBrgy;
	static String cityMunicipal;
	static String province;
	static String emailAdd;
	static String contactNo;
	
	// Government ID
	static String sssNum;
	static String tinNum;
	static String pagibigNum;
	static String philhealthNum;
	
	static boolean willRun = true, isValid = false;
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(willRun) {
			
			inputs();
			
			Employee newEmp = new Employee(lastName, firstName, midInit, age, gender, birthDate, placeOfBirth, religion, civStat,
					   strtBrgy, cityMunicipal, province, emailAdd, contactNo,
					   sssNum, tinNum, pagibigNum, philhealthNum);
			
			newEmp.printPersonalData();
			newEmp.printContactInfo();
			newEmp.printGovtId();
			
			isValid = false;
			
			while(!isValid) {
				System.out.print("Would you like to enter new data? [Y / N]: ");
				String continueInpt = input.nextLine().toUpperCase();
				
				switch(continueInpt) {
					case "Y":
						System.out.println("\n");
						isValid = true;
						break;
					case "N":
						System.out.println("\nExiting Program.\n"
										 + "Programmed by Kurt Colonia, 2BSIT-2.");
						isValid = true;
						willRun = false;
						break;
					default:
						System.out.println("Input is invalid, please only enter either Y or N");
				}
			}
		}
		
		input.close();
		
	}
	
	static void inputs() {
		System.out.println(
		"----------------------------------------------------------------------------------------------------------\n"
	  + "EMPLOYEE'S DATA ENTRY: Programmed by Kurt Colonia, 2BSIT-2\n"
	  + "----------------------------------------------------------------------------------------------------------"
		);
				
		// Personal Data
		System.out.print("Last Name: ");
		lastName = input.nextLine();
				
		System.out.print("First Name: ");
		firstName = input.nextLine();
		
		System.out.print("MI: ");
		midInit = input.nextLine();
			
		while(true) {
			try {
				System.out.print("Age: ");
				age = input.nextInt();
				input.nextLine(); // Used to clear any previous integer input
				break;
			}
			catch(Exception e) {
				System.out.println("Please only enter an integer value ");
				input.nextLine(); // Used to clear any previous integer input
			}
		}
				
		System.out.print("Gender: ");
		gender = input.nextLine();
				
		System.out.print("Birth Date: ");
		birthDate = input.nextLine();
				
		System.out.print("Place of Birth: ");
		placeOfBirth = input.nextLine();
				
		System.out.print("Religion: ");
		religion = input.nextLine();
				
		System.out.print("Civil Status: ");
		civStat = input.nextLine();
		
		// Contact Information
		System.out.println();
			
		System.out.print("Street/Barangay: ");
		strtBrgy = input.nextLine();
				
		System.out.print("City/Municipality: ");
		cityMunicipal = input.nextLine();
				
		System.out.print("Province: ");
		province = input.nextLine();
			
		System.out.print("E-Mail Address: ");
		emailAdd = input.nextLine();
				
		System.out.print("Contact No.: ");
		contactNo = input.nextLine();
		
		// Government ID
		System.out.println();
				
		System.out.print("SSS#: ");
		sssNum = input.nextLine();
				
		System.out.print("Tin#: ");
		tinNum = input.nextLine();
				
		System.out.print("Pagibig#: ");
		pagibigNum = input.nextLine();
			
		System.out.print("Philhealth#: ");
		philhealthNum = input.nextLine();
				
		System.out.println("\n");
	}
}
