import java.util.Scanner;

public class SumOfOddNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num, num1=1, cond=1, sum=0;
		
		System.out.print("Enter number: ");
		num = input.nextInt();
		
		System.out.print("Odd numbers are: ");
		do {
			System.out.print(num1 + " ");
			sum = sum + num1;
			num1+=2;
			cond++;
		}while(cond<=num);
		System.out.println();
		System.out.println("The sum of odd numbers upto term " + num + " is " + sum);
		
		//No modulo was used in the code
		
		input.close();
	}

}
