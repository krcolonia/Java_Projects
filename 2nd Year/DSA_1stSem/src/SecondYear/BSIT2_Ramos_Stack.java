package SecondYear;

import java.util.Scanner;

public class BSIT2_Ramos_Stack {

	public static void main(String[]args) {
		
		Scanner input = new Scanner(System.in);
		
		int stackIndex; //this will be initialize the stack's index
		
		System.out.print("How many elements the stack can handle: ");
		stackIndex = input.nextInt();
		System.out.println("Stacks created!");
		
		
		int stack[] = new int [stackIndex];  //this will be initialize the stack or the array
		int x = 0;    //this will be initialize the stack for validity 
		
		boolean progStillruns = true; //declares if the program/code is still running
			
		while (progStillruns == true) { 	 //this loop will perform until user's decided to stop
			
		int options; 
		System.out.println("\n"+"\nMENU" + 
		"\n1.PUSH" + "\n2.POP" + "\n3.TOP" + "\n4.SIZE" + "\n5.EMPTY" + "\n6.DIPLAY STACK" + "\n7.EXIT");
		System.out.print("\nEnter Choice [1..7] : ");
		options = input.nextInt();
		
		switch (options) {
		
		case 1:
			    System.out.print("******************");
				System.out.println("\nPUSH OPERATION"); 
			   	try 
						{ 
			   			System.out.print("Enter integer number : ");
			   			int stackValue = input.nextInt();          //this will be initialize the stack values
			   			
			   			if ( x < stackIndex) {			       //this will be initialize the stackIndex first value
			   				stack[x] = stackValue;
			   				System.out.println("\nStack Value: " + stack[x] + " pushed sucessfully");
			   				 x++;						     //this will be increment until it satify the stackIndex
			   			}
			   			else
			   			{
			   				System.out.println("\nStack Overflow !");
			   			}
			   			} 	
			   			catch (Exception e)  
						{ 
			   				System.out.println("\nStack Overflow !");
						} 
			   	System.out.print("\n"+"******************");
				    break;
		case 2:
				System.out.print("******************");
				System.out.println("\nPOP OPERATION"); 
				System.out.println("\nPOP OPERATION generated"); 
				if (x == 0) {                 //this initialize to check if stack value of stackIndex is 0
					System.out.print("\nStack is Empty");
				}
				else 
				{
					x--;                     //this initialize to delete the certain value of stackIndex
					stack[x] = 0;
				}
				System.out.print("\n"+"******************");
			break;
		case 3:
				System.out.print("******************");
				System.out.println("\nTOP OPERATION"); 
				if (x == 0)                  //this initialize to check if stack value of stackIndex is 0
            	{           	
            		System.out.print("\nStack is Empty");
            	}
				else 
            	{
            		x--;                    //this will decrement to give the emphasis of the place value in stackIndex
            		System.out.print("\nTop Value of Stack: " + stack[x]);
            		x++;                   //this will increment to give the emphasis of the place value in stackIndex
            	}
				System.out.print("\n"+"******************");
			break;
		case 4:
				System.out.print("******************");
				System.out.println("\nSIZE OPERATION"); 
				System.out.println("Size of the stack :  " + stackIndex);
				System.out.print("\n"+"******************");
				break;
		case 5:
				System.out.print("******************");
				System.out.println("\nEMPTY OPERATION"); 
				if (x == 0)                    //this initialize to check if stack value of stackIndex is 0
            	{
            		System.out.print("\nTRUE");
            		System.out.print("\nStack is empty");
            	}
            	
            	else                           //this initialize to check if stack value of stackIndex is not 0
            	{	
            		System.out.print("\nFALSE");
            		System.out.print("\nStack is not empty");
            	}
				System.out.print("\n"+"******************");
			break;
		case 6:
				System.out.print("******************");
				System.out.println("\nDISPLAY STACK");
				System.out.println("Stack Value: ");
				for (int a = 0; a < x; a++)                    //this will loop until it will display all stack's value
				{
					
					System.out.print( "   " + stack[a]);
					
				}
				System.out.print("\n"+"******************");
			break;
		case 7:
			
			System.out.println("\nTerminate program - programmer's name: Dominic O. Ramos"); 
			progStillruns = false;                   //This line will stop while loop that contains of boolean progStillruns
			break;
		default: System.out.println("\nInvalid Option, Choose only from 1-7"); 
		}
		
	}
		input.close();
	}
}
