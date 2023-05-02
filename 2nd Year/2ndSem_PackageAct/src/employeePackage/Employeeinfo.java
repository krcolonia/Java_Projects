package employeePackage;

import mainPackage.*;

public class Employeeinfo {
	/* Array Element Index */
	public static int employArray;
	
	/* Employee Info */
	public static String[] employeeName = {"",""};
	public static String[] employeeDesignation = {"",""};
	public static String[] employeeAcadPos = {"",""};
	
	public static void display_Employee() {
		System.out.println("EMPLOYEE'S DETAILS");
		System.out.println("Student Name: " + employeeName[employArray]);
		System.out.println("Student Name: " + employeeDesignation[employArray]);
		System.out.println("Student Name: " + employeeAcadPos[employArray]);
		System.out.println();
	}
}
