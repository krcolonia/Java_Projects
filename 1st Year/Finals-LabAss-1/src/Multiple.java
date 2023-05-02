import java.util.Scanner;
public class Multiple {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int firstInt=0, secondInt=0, multipleDetermine;
		
		System.out.print("Enter first integer: ");
		firstInt = input.nextInt();
		
		System.out.print("Enter 2nd integer: ");
		secondInt = input.nextInt();
		
		multipleDetermine = isMultiple(firstInt, secondInt);
		
		System.out.println();
		
		if(multipleDetermine==0)
		{
			System.out.println(secondInt + " is multiple of " + firstInt);
		}
		else
		{
			System.out.println(secondInt + " is not multiple of " + firstInt);
		}
		
		input.close();
	}

	public static int isMultiple(int first, int second) {
		int multiple;
		
		multiple=second%first;
		return multiple;
	}
}
