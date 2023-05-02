package reviewAct1;

import java.util.Scanner;

public class Colonia2BSIT2ReviewAct1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		String[] idNum = {"2022-001", "2022-002", "2022-003", "2022-004"},
				 studName = {"James Cooper", "Princess Smith", "Dianna Ross", "James Butler"},
				 collegeProgram = {"BSIT", "BSCS", "BSIS", "BSEMC"},
				 sports = {"Basketball", "Badminton", "Swimming", "Baseball"},
				 contact = {"0920864756", "09178765454", "09167657382", "09108877635"};
		
		System.out.print("Students Name: ");
		for(int i=0; i < 4; i++) {
			System.out.print(studName[i]);
			if(i<3)
				System.out.print(", ");
		}
		System.out.print("\nEnter Student Index: ");
		int inpNum = input.nextInt();
		
		System.out.println("\nIndex Number\t: " + inpNum
						 + "\nStudent ID\t: " + idNum[inpNum]
						 + "\nName of Student\t: " + studName[inpNum]
						 + "\nCourse\t\t: " + collegeProgram[inpNum]
						 + "\nSports\t\t: " + sports[inpNum]
						 + "\nContact No.\t: " + contact[inpNum]);
		
	}
}
