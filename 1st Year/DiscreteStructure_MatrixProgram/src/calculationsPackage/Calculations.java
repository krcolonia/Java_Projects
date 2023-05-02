package calculationsPackage;

import variablePackage.MatrixA;
import variablePackage.MatrixB;
import java.util.Scanner;

public class Calculations {
	public static int operIndex=0;
	public static String operationInput;
	public static String operCalc[] = new String[operIndex];
	public static int multMatrix[][];
	
	public static void Addition() {
		MatrixA A = new MatrixA();
		MatrixB B = new MatrixB();
		
		if(A.rowRange == B.rowRange && A.colRange == B.colRange) {
			for(int rows = 0; rows<A.rowRange;rows++) {
				for(int cols=0; cols<A.colRange;cols++) {
					System.out.print(" " + (A.matrix[cols][rows]+B.matrix[cols][rows]) + " ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("Not Possible, the two arrays do not have the same range.");
		}
	}
	
	public static void Subtraction() {
		MatrixA A = new MatrixA();
		MatrixB B = new MatrixB();

		if(A.rowRange == B.rowRange && A.colRange == B.colRange) {
			for(int rows = 0; rows<A.rowRange;rows++) {
				for(int cols=0; cols<A.colRange;cols++) {
					System.out.print(" " + (A.matrix[cols][rows]-B.matrix[cols][rows]) + " ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("Not Possible, the two arrays do not have the same range.");
		}
		
	}
	
	public static void Multiplication() {
		MatrixA A = new MatrixA();
		MatrixB B = new MatrixB();
		
		multMatrix = new int[A.colRange][B.rowRange];
		
		if(A.colRange == B.rowRange) {
			for (int colA = 0; colA < B.rowRange; colA++) {
	            for (int rowB = 0; rowB < B.rowRange; rowB++) {
	                for (int colB = 0; colB < A.colRange; colB++)
	                    multMatrix[colA][rowB] += A.matrix[colB][rowB] * B.matrix[colA][colB];
	            }
	        }
			
			for(int rows = 0; rows<A.rowRange;rows++) {
				for(int cols = 0; cols<B.rowRange;cols++) {
					System.out.print(" " + multMatrix[cols][rows] + " ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("Not Possible, Column");
		}
		
	}
}
