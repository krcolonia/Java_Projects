package reviewAct3;

import java.util.*;

public class Colonia2BSIT2ReviewAct3 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		boolean willContinue = true, isValid, isInvalid;
		
		String idInput, nameInput, deptInput, progInput;
		
		ArrayList<String> idNum = new ArrayList();
		ArrayList<String> name = new ArrayList();
		ArrayList<String> collDept = new ArrayList();
		ArrayList<String> collProg = new ArrayList();
		
		ArrayList<ArrayList<String>> studList = new ArrayList();
		
		studList.add(idNum);
		studList.add(name);
		studList.add(collDept);
		studList.add(collProg);
		
		while(willContinue) {
			
			willContinue = true;
			isValid = true;
			
			while(isValid) {
				System.out.println("Enter ID Number: ");
				idInput = input.nextLine();
				if(idInput.isEmpty()) {
					System.out.println("ID Number is required to continue.\n");
				}
				else {
					idNum.add(idInput);
					isValid = false;
				}
			}
			
			isValid = true;
			
			while(isValid) {
				System.out.println("Enter Student Full Name: ");
				nameInput = input.nextLine().toUpperCase();
				if(nameInput.isEmpty()) {
					System.out.println("Student's Full Name is required to continue.\n");
				}
				else {
					name.add(nameInput);
					isValid = false;
				}
			}		
			
			isValid = true;
				
			while(isValid) {
				System.out.println("Enter Student College: ");
				deptInput = input.nextLine().toUpperCase();
				if(deptInput.isEmpty()) {
					System.out.println("Student College Dept. is required to continue.\n");
				}
				else {
					collDept.add(deptInput);
					isValid = false;
				}
			}
			
			isValid = true;
			
			while(isValid) {
				System.out.println("Enter Student Program: ");
				progInput = input.nextLine().toUpperCase();
				if(progInput.isEmpty()) {
					System.out.println("Student program is required to continue.\n");
				}
				else {
					collProg.add(progInput);
					isValid = false;
				}
			}
			
			isInvalid = true;
			
			while(isInvalid) {
				System.out.println("\nDo you want to add more participants? YES / NO: ");
				String contInput = input.nextLine().toUpperCase();
				System.out.println();
				switch(contInput) {
				case "YES":
					willContinue = true;
					isInvalid = false;
					break;
				case "NO":
					willContinue = false;
					isInvalid = false;
					break;
				default:
					System.out.println("Invalid input, please only enter YES / NO");
					isInvalid = true;
				}
			}
		}
		
		System.out.println("ID NUMBER\t\tSTUDENT NAME\t\t\tCOLLEGE\t\t\tPROGRAM");
		
		for(int i = 0; i < studList.get(i).size(); i++) {
			for(int j = 0; j < studList.size(); j++) {
				System.out.print(studList.get(j).get(i) + "\t\t\t");
			}
			System.out.println();
		}
		
		input.close();
	}
}
