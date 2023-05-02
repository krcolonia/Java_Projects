package studentPackage;

import mainPackage.*;

public class Studentinfo {
	/* Array Element Index */
	public static int studArray;
	
	/* Student Info */
	public static String studentName[];
	public static int studentAge[];
	public static String studentGender[];
	public static String studentAddress[];
	public static String studentContact[];
	public static String studentFather[];
	public static String studentMother[];
	public static int studentNumber[];

	public Studentinfo() {
		studentName = new String[] {"",""};
		studentAge = new int[] {0,0};
		studentGender = new String[] {"",""};
		studentAddress = new String[] {"",""};
		studentContact = new String[] {"",""};
		studentFather = new String[] {"",""};
		studentMother = new String[] {"",""};
		studentNumber = new int[] {0,0};
	}
	
	public static void diplay_student() {
		System.out.println("STUDENT DETAILS");
		System.out.println("Student Name: " + studentName[studArray]);
		System.out.println("Age: " + studentAge[studArray]);
		System.out.println("Student Gender: " + studentGender[studArray]);
		System.out.println("Student Address: " + studentAddress[studArray]);
		System.out.println("Student Contact: " + studentContact[studArray]);
		System.out.println("Father's Name : " + studentFather[studArray]);
		System.out.println("Mother's Name: " + studentMother[studArray]);
		System.out.println();
	}
}
