import java.util.Scanner;
public class OneDime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter size of the 1st array: ");
		int num1 = input.nextInt();
		
		System.out.print("Enter size of the 2nd array: ");
		int num2 = input.nextInt();
		
		System.out.print("Enter size of the 3rd array: ");
		int num3 = input.nextInt();
		
		input.nextLine();
		
		String[] stringArr1 = new String[num1];
		String[] stringArr2 = new String[num2];
		String[] stringArr3 = new String[num3];
		
		System.out.println();
		
		System.out.print("Enter value of the 1st array: ");
		
		String line1 = input.nextLine();
		stringArr1 = line1.split(" ");
		int[] arr1 = new int[stringArr1.length];
		for(int i =0;i<stringArr1.length;i++)
		{
			arr1[i] = Integer.parseInt(stringArr1[i]);
		}
		
		System.out.print("Enter value of the 2nd array: ");

		String line2 = input.nextLine();
		stringArr2 = line2.split(" ");
		int[] arr2 = new int[stringArr2.length];
		for(int i =0;i<stringArr2.length;i++)
		{
			arr2[i] = Integer.parseInt(stringArr2[i]);
		}
		
		System.out.print("Enter value of the 3rd array: ");

		String line3 = input.nextLine();
		stringArr3 = line3.split(" ");
		int[] arr3 = new int[stringArr3.length];
		for(int i =0;i<stringArr3.length;i++)
		{
			arr3[i] = Integer.parseInt(stringArr3[i]);
		}

		System.out.println();
		
		System.out.println("Output:");
		System.out.println("Value of arrays:");
		
		System.out.print("Array1: ");
		for(int i=0;i<arr1.length;i++)
		{
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		System.out.print("Array2: ");
		for(int i=0;i<arr2.length;i++)
		{
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		System.out.print("Array3: ");
		for(int i=0;i<arr3.length;i++)
		{
			System.out.print(arr3[i] + " ");
		}
		System.out.println("\n");
		
		System.out.print("Common elements in sorted arrays: ");
		for(int a=0; a<arr1.length;a++)
		{
			for(int b=0; b<arr2.length;b++)
			{
				for(int c=0; c<arr3.length;c++)
				{
					if(arr1[a] == arr2[b] && arr1[a] == arr3[c])
					{
						System.out.print(arr1[a] + " ");
					}
				}
			}
		}
		input.close();
	}

}
