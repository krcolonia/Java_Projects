import java.util.Scanner;

public class OddSquareCube {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num, num2=2, ctr, sqr, cbd, sqrTotal=0, cbdTotal=0;
		String ctrStr;
		
		System.out.print("Enter number: "); // sysout 1
		num = input.nextInt();
		
		System.out.println("\nNumber\tSquare\tCube"); // sysout 2
		
		num2 += num;
		
		for(ctr=1;ctr<=num2;ctr+=2){
			ctrStr = Integer.toString(ctr);
			
			sqr = ctr * ctr;
			cbd = sqr * ctr;
			
			
			
			if(ctr > num)
			{
				ctrStr = "TOTAL";
				sqr = sqrTotal;
				cbd = cbdTotal;
			}
			
			System.out.println(ctrStr + "\t" + sqr + "\t" + cbd); // sysout 3
			
			sqrTotal = sqrTotal + sqr;
			cbdTotal = cbdTotal + cbd;
		}
		
		// Only 3 sysout were used
		
		input.close();
	}

}
