package studentPackage;

import mainPackage.*;
import java.util.*;
import java.text.*;

public class Acadinfo {
	public static int acadArray;
	public static String acadStudentNumber[];
	public static int acadQ1[];
	public static int acadQ2[];
	public static int acadMT[];
	public static int acadFT[];
	public static int acadAttendance[];
	
	public Acadinfo() {
		acadStudentNumber = new String[] {"",""};
		acadQ1 = new int[] {0,0};
		acadQ2 = new int[] {0,0};
		acadMT = new int[] {0,0};
		acadFT = new int[] {0,0};
		acadAttendance = new int[] {0,0};
	}
	
	public static void displayEducDetails() {
		DecimalFormat df = new DecimalFormat("###,###,###.00");
		
		System.out.println("STUDENT EDUCATIONAL DETAILS");
		System.out.println("Student Number: " + acadStudentNumber[acadArray]);
		System.out.println("Student Grade Average: " + df.format((acadQ1[acadArray]+acadQ2[acadArray]+acadMT[acadArray]+acadFT[acadArray])/4));
		System.out.println("Student Attendance: " + acadAttendance[acadArray] + "%");
		System.out.println();
	}
	
}
