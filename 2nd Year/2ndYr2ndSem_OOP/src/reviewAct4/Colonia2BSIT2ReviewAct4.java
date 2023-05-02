package reviewAct4;

import java.util.*;

public class Colonia2BSIT2ReviewAct4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Double> grades = new ArrayList<Double>();
		
		System.out.print("Enter Student Name: ");
		String name = input.nextLine();
		
		System.out.print("Grade in ENGLISH: ");
		double engGrd = input.nextDouble();
		grades.add(engGrd);
		
		System.out.print("Grade in MATH: ");
		double mathGrd = input.nextDouble();
		grades.add(mathGrd);
		
		System.out.print("Grade in SCIENCE: ");
		double sciGrd = input.nextDouble();
		grades.add(sciGrd);
		
		System.out.print("Grade in HISTORY: ");
		double histGrd = input.nextDouble();
		grades.add(histGrd);
		
		System.out.print("Grade in PE: ");
		double peGrd = input.nextDouble();
		grades.add(peGrd);
		
		System.out.println();
		
		studName(name);
		double avg = compAvg(grades);
		avgRemarks(avg);
		rmrkCounter(grades);
		
		input.close();
	}
	
	public static void studName(String name) {
		System.out.println("Name of student: " + name.toUpperCase());
	}
	
	public static double compAvg(ArrayList<Double> grades) {
		double sum = 0;
		double total = 0;
		for(double i: grades) {
			sum += i;
			total++;
		}
		double avg = sum/total;
		System.out.println("Computed Average: " + avg);
		return avg;
	}
	
	public static void avgRemarks(double avg) {
		System.out.print("Average Remarks: ");
		if(avg < 75)
			System.out.println("Failed");
		else if(avg >= 75 && avg <= 84)
			System.out.println("Passed");
		else if(avg >= 85 && avg <= 89)
			System.out.println("Good");
		else if(avg >= 90 && avg <= 94)
			System.out.println("Very Good");
		else
			System.out.println("Excellent");
	}
	
	public static void rmrkCounter(ArrayList<Double> grades) {
		int passed = 0;
		int failed = 0;
		for(double i: grades) {
			if(i >= 75)
				passed++;
			else
				failed++;
		}
		System.out.println("Number of Passed " + passed + " Number of Failed " + failed);
	}
	
}