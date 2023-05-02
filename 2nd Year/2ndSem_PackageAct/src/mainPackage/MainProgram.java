package mainPackage;

import studentPackage.*;
import employeePackage.*;
import java.util.*;

public class MainProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Studentinfo sInf = new Studentinfo();
		Acadinfo aInf = new Acadinfo();
		Employeeinfo eInf = new Employeeinfo();
		
		
		
		/* For-Loop for Inputs */
		for(int i=0; i<2; i++) {
			System.out.println("Input for Student " + (i+1));
			
			System.out.print("Student Name: ");
			String sName = sc.nextLine();
			sInf.studentName[i] = sName;
			
			System.out.print("Age: ");
			int sAge = sc.nextInt();
			sInf.studentAge[i] = sAge;
			sc.nextLine();
			
			System.out.print("Student Gender: ");
			String sGender = sc.nextLine();
			sInf.studentGender[i] = sGender;
			
			System.out.print("Student Address: ");
			String sAddress = sc.nextLine();
			sInf.studentAddress[i] = sAddress;
			
			System.out.print("Student Contact: ");
			String sContact = sc.nextLine();
			sInf.studentContact[i] = sContact;
			
			System.out.print("Father's Name: ");
			String sFather = sc.nextLine();
			sInf.studentFather[i] = sFather;
			
			System.out.print("Mother's Name: ");
			String sMother = sc.nextLine();
			sInf.studentMother[i] = sMother;
			System.out.println();
			
			System.out.println("Input for Employee " + (i+1));
			System.out.print("Employee Name: ");
			String eName = sc.nextLine();
			eInf.employeeName[i] = eName;
			
			System.out.print("Designation: ");
			String eDesignation = sc.nextLine();
			eInf.employeeDesignation[i] = eDesignation;
			
			System.out.print("Academic Position: ");
			String eAcadPos = sc.nextLine();
			eInf.employeeAcadPos[i] = eAcadPos;
			System.out.println();
			
			System.out.println("Input for Student " + (i+1) + "'s Educational Details");
			System.out.print("Student Number: ");
			String aStudentNumber = sc.nextLine();
			aInf.acadStudentNumber[i] = aStudentNumber;
			
			System.out.print("Student Grade in Quiz 1: ");
			int aQ1 = sc.nextInt();
			aInf.acadQ1[i] = aQ1;
			sc.nextLine();
			
			System.out.print("Student Grade in Quiz 2: ");
			int aQ2 = sc.nextInt();
			aInf.acadQ2[i] = aQ2;
			sc.nextLine();
			
			System.out.print("Student Grade in Midterms: ");
			int aMT = sc.nextInt();
			aInf.acadMT[i] = aMT;
			sc.nextLine();
			
			System.out.print("Student Grade in Finals: ");
			int aFT = sc.nextInt();
			aInf.acadFT[i] = aFT;
			sc.nextLine();
			
			System.out.print("Student Attendance: ");
			int aAttendance = sc.nextInt();
			aInf.acadAttendance[i] = aAttendance;
			sc.nextLine();
			System.out.println();
		}
		
		int a=0;
		
		/* Calling methods from other classes to print out details */
		while(a<2) {
			sInf.diplay_student();
			eInf.display_Employee();
			aInf.displayEducDetails();
			if(a<1) {
				System.out.println("\nNEXT STUDENT\n");
			}
			a++;
			sInf.studArray++;
			eInf.employArray++;
			aInf.acadArray++;
		}
		
	}
}
