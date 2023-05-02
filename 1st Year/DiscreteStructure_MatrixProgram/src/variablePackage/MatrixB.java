package variablePackage;

import java.util.Scanner;

public class MatrixB {
	public static Scanner sc = new Scanner(System.in);
	
	public static int[][] matrix, multipliedMatrix, transposedMatrix;
	public static int rowRange=0, colRange=0, rowIndex=0, colIndex=0;
	public static int multiple;
	
	public static void rangeOfRowsAndColumns() {
		if(rowRange < 2 && colRange < 2) {
			System.out.println("\nMatrix B has " + rowRange + " Row and " + colRange + " Column\n");
		}
		else if(rowRange >= 2 && colRange < 2) {
			System.out.println("\nMatrix B has " + rowRange + " Rows and " + colRange + " Column\n");
		}
		else if(rowRange < 2 && colRange >=2) {
			System.out.println("\nMatrix B has " + rowRange + " Row and " + colRange + " Columns\n");
		}
		else {
			System.out.println("\nMatrix B has " + rowRange + " Rows and " + colRange + " Columns\n");
		}
	}
	
	public static void matrixInput() {
		matrix = new int[colRange][rowRange];
		
		for(rowIndex=0;rowIndex<rowRange;rowIndex++)
		{
			for(colIndex=0;colIndex<colRange;colIndex++)		
			{
				System.out.print("Enter value of Row " + (rowIndex+1) + ", Column " + (colIndex+1) + ": ");
				matrix[colIndex][rowIndex] = sc.nextInt();
			}
		}	
		
		System.out.println("\nMatrix B:");
		for(int r=0;r<rowRange;r++)
		{
			for(int c=0;c<colRange;c++)
			{
				System.out.print(" " + matrix[c][r] + " ");
			}
			System.out.println();
		}
		System.out.println();
		/*
		System.out.println("Transposed Matrix B:");
		for(int c=0;c<colRange;c++)
		{
			for(int r=0;r<rowRange;r++)
			{
				System.out.print("\t" + matrix[c][r] + "\t");
			}
			System.out.println();
		}
		*/
	}
	
	public static void matrixMultiple() {
		multipliedMatrix = new int[colRange][rowRange];
		
		for(rowIndex=0;rowIndex<rowRange;rowIndex++)
		{
			for(colIndex=0;colIndex<colRange;colIndex++)		
			{
				multipliedMatrix[colIndex][rowIndex] = matrix[colIndex][rowIndex];
			}
		}	
		
		for(rowIndex=0;rowIndex<rowRange;rowIndex++)
		{
			for(colIndex=0;colIndex<colRange;colIndex++)		
			{
				matrix[colIndex][rowIndex] = (multiple*multipliedMatrix[colIndex][rowIndex]);
			}
		}
	}
	
	public static void matrixTranspose() {
		transposedMatrix = new int[rowRange][colRange];
		
		for(rowIndex=0;rowIndex<rowRange;rowIndex++)
		{
			for(colIndex=0;colIndex<colRange;colIndex++)		
			{
				transposedMatrix[colIndex][rowIndex] = matrix[rowIndex][colIndex];
			}
		}
		
		for(rowIndex=0;rowIndex<rowRange;rowIndex++)
		{
			for(colIndex=0;colIndex<colRange;colIndex++)		
			{
				matrix[colIndex][rowIndex] = transposedMatrix[colIndex][rowIndex];
			}
		}
	}
}
