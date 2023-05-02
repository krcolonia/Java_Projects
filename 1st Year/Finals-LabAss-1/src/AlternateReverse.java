import java.util.Scanner;

public class AlternateReverse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2, subtrahend;
		
		System.out.print("Enter number: ");
		num1 = input.nextInt();
		subtrahend = num1-1;
		num2 = num1-subtrahend;
		
		while(subtrahend>=0) {
			System.out.print(num1 + " " + num2 + " ");
			num1--;
			num2++;
			subtrahend--;
		}
		
		input.close();
	}

}
