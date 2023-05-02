import java.util.Scanner;
public class TwoDime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[][] matrix;
		int row=0, col=0, indexRow=0, indexCol=0;
		
		System.out.println("Enter number of rows and columns in the matrix:");
		row = input.nextInt();
		col = input.nextInt();
		
		System.out.println();
		
		matrix = new int[col][row];
		
		for(indexRow=0;indexRow<row;indexRow++)
		{
			for(indexCol=0;indexCol<col;indexCol++)		
			{
				System.out.print("Enter element:");
				matrix[indexCol][indexRow] = input.nextInt();
			}
		}
		
		System.out.println();
		
		System.out.println("Matrix input:");
		for(int r=0;r<row;r++)
		{
			for(int c=0;c<col;c++)
			{
				System.out.print("\t" + matrix[c][r] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Transposed matrix:");
		for(int c=0;c<col;c++)
		{
			for(int r=0;r<row;r++)
			{
				System.out.print("\t" + matrix[c][r] + "\t");
			}
			System.out.println();
		}
		
		input.close();
	}

}
