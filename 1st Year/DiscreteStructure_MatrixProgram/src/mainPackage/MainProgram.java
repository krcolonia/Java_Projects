package mainPackage;

import java.util.Scanner;
import variablePackage.*;
import calculationsPackage.*;

public class MainProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MatrixA A= new MatrixA();
		MatrixB B= new MatrixB();
		Calculations calc = new Calculations();
		
		boolean isDone = false;
		int aMultiple = 0;
		int bMultiple = 0;
		
		/* Title of the Program */
		
		System.out.println("█▀▄▀█ ▄▀█ ▀█▀ █▀█ █ ▀▄▀   █▀▀ ▄▀█ █░░ █▀▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█\n"
						 + "█░▀░█ █▀█ ░█░ █▀▄ █ █░█   █▄▄ █▀█ █▄▄ █▄▄ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄");
		
		System.out.println("  Programmed by Kurt Robin Colonia | 1-BSIT-2 | A.Y. 2021-2022" + "\n\n");
			
			/* Inputs for Matrices */
			
			System.out.println("Enter the number of Rows and Columns for Matrix A:\n");
			
			System.out.print("Rows: ");
			A.rowRange = sc.nextInt();
			
			System.out.print("Cols: ");
			A.colRange = sc.nextInt();
			
			sc.nextLine();
			
			A.rangeOfRowsAndColumns();
			A.matrixInput();
			
			System.out.println("Enter the number of Rows and Columns for Matrix B:\n");
			
			System.out.print("Rows: ");
			B.rowRange = sc.nextInt();
			
			System.out.print("Cols: ");
			B.colRange = sc.nextInt();
			
			sc.nextLine();
			
			B.rangeOfRowsAndColumns();
			B.matrixInput();
			
			calc.operIndex=0;
			while(calc.operCalc.length<2 ) {
				System.out.print("Input the Operation to be done (Ex: A + B): ");
				String operationInput = sc.nextLine();
				calc.operCalc = operationInput.split(" ");
				
				if(calc.operCalc[0].length()>1 && calc.operCalc[0].contains("A")) {
						
						calc.operCalc[0] = calc.operCalc[0].replace("A", "");
						A.multiple = Integer.parseInt(calc.operCalc[0]);
						
						//multString = operCalc[0].charAt(0);
						//A.multiple = Character.getNumericValue(multString);
						A.matrixMultiple();
						//System.out.println(multString);
				}
				
				if(calc.operCalc[2].length()>1 && calc.operCalc[2].contains("B")) {
					
						calc.operCalc[2] = calc.operCalc[2].replace("B", "");
						B.multiple = Integer.valueOf(calc.operCalc[2]);
						
						//char multString = operCalc[2].charAt(0);
						//B.multiple = Character.getNumericValue(multString);
						B.matrixMultiple();
						//System.out.println(multString);
				}
				
				System.out.println();
				
				System.out.print("Transpose Matrix A? (Y/N): ");
				String transposeA = sc.nextLine();
				
				switch(transposeA.charAt(0)) {
					case 'Y': A.matrixTranspose();
							System.out.println("Transposing A\n");
							break;
					case 'y': A.matrixTranspose();
							System.out.println("Transposing A\n");
							break;
					case 'N': System.out.println("Not Transposing A\n");
							break;
					case 'n': System.out.println("Not Transposing A\n");
							break;
					default: System.out.println("Input Invalid, Not Transposing A\n");
				}
				
				System.out.print("Transpose Matrix B? (Y/N): ");
				String transposeB = sc.nextLine();
				
				switch(transposeB.charAt(0)) {
					case 'Y': B.matrixTranspose();
							System.out.println("Transposing B\n");
							break;
					case 'y': B.matrixTranspose();
							System.out.println("Transposing B\n");
							break;
					case 'N': System.out.println("Not Transposing B\n");
							break;
					case 'n': System.out.println("Not Transposing B\n");
							break;
					default: System.out.println("Input Invalid, Not Transposing B\n");
				}
				
				if(calc.operCalc.length < 2) {
					System.out.println("Input Invalid, add spaces between your input (Ex. A + B)\n");
				}
				else if(calc.operCalc.length > 2) {
					switch(calc.operCalc[1]) {
					case "+": System.out.println("Addition:");
								calc.Addition();
								break;
					case "-": System.out.println("Subtraction:");
								calc.Subtraction();
								break;
					case "*": System.out.println("Multiplication:");
								calc.Multiplication();
								break;
					case "/": System.out.println("Division is not covered");
								break;	
					default : System.out.println("Input Invalid");
					}
				}
			}
		
		sc.close();
	}
}
