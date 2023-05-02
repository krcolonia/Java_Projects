import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=0;
		int row, col;
		int print=0;
		
		System.out.print("Enter matrix to generate (n by n): "); // sysout 1
		num = input.nextInt();
		
		for(row=1;row<=num;row++)
		{
			for(col=1;col<=num;col++)
			{
				if(col==1 && row==1)
				{
					print=num*num;
				}
				else if((row%2)==0 && col==1)
				{
					print=print-num;
				}
				else if((row%2)==0 && col>1)
				{
					print++;
				}
				else if((row%2)!=0 && col==1)
				{
					print=print-num;
				}
				else
				{
					print--;
				}

				System.out.print(print + "\t"); // sysout 2
			}
			System.out.println(); //sysout 3
		}
		
		// only 3 sysout were used
		
		input.close();
	}

}
