package calculationsPackage;

import variablePackage.*;

public class Addition {
	public static void Addition() {
		MatrixA A= new MatrixA();
		MatrixB B= new MatrixB();
		
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
}
