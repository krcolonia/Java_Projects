package package1;
import java.util.Scanner;

public class MidtermsExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter 3 numbers: ");
		String nums = sc.nextLine();
		int num1 = Integer.valueOf(nums.charAt(0));
		int num2 = Integer.valueOf(nums.charAt(2));
		int num3 = Integer.valueOf(nums.charAt(4));

		int highest=0;
		
		if((num1>num2) && (num1>num3))
		{
			highest = num1;
		}
		else if(num2>num3)
		{
			highest = num2;
		}
		else
		{
			highest = num3;
		}
		
		int lowest=0;
		
		if((num1<num2) && (num1<num3))
		{
			lowest = num1;
		}
		else if(num2<num3)
		{
			lowest = num2;
		}
		else
		{
			lowest = num3;
		}
		
		
		if(highest>lowest)
		{
			System.out.println(highest);
			
			System.out.println(lowest);
			
			int difference = highest-lowest;
			System.out.println("Difference: " + difference);
		}
		else if (num1==num2 && num1==num3)
		{
			System.out.println("Numbers are equal");
		}
		
	}

}
