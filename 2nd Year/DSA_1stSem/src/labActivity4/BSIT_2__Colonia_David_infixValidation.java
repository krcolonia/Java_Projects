package labActivity4;

import java.util.Scanner;

	public class BSIT_2__Colonia_David_infixValidation {
		
		static Scanner input = new Scanner(System.in);
		static String infix;
		static String splitElements[];
		static Integer elementPrecedence[];
				
		static Integer size, operandCount, operatorCount, openParentheses, closeParentheses, nonOpSymbol, elementInParentheses, pairParenthesis=0;
		static boolean isValid = false;
		
		public static void main(String[] args) {
			
			System.out.println("\nData Structures and Algorithms | Infix Validation Program"
					+ "\nProgrammed by Colonia and David from 2BSIT-2, A.Y. 2022-2023\n");
			
			while(!isValid) {
				
				System.out.print("Input Infix Notation: ");
				infix = input.nextLine();
				
				infixInput(infix);
				
				System.out.println(infixValidation(splitElements, elementPrecedence) + "\n");
			}
			System.out.println("Exiting Program. Program coded by Colonia and David from 2BSIT-2.");
		}
		
		static void infixInput(String infix) {
			
			splitElements = infix.split(" ");
			size = splitElements.length;
			elementPrecedence = new Integer[size];
			
			operandCount=0;
			operatorCount=0;
			openParentheses=0;
			closeParentheses=0;
			nonOpSymbol=0;
			elementInParentheses=0;
			
			for(int i = 0; i < size; i++) {
				elementPrecedence[i] = assignPrecedence(splitElements[i]);
			}
			
			parenthesesChecker(splitElements, elementPrecedence);
		}
		
		static Integer assignPrecedence(String element) {
			switch(element) {
			case "+":
			case "-":
				operatorCount += 1;
				return 2;
			case "*":
			case "/":
				operatorCount += 1;
				return 4;
			case "^":
				operatorCount += 1;
				return 6;
			case "(":
				openParentheses += 1;
				return 7;
			case ")":
				closeParentheses += 1;
				return 7;
			default:
				if (element.matches("\\w*")) {
					operandCount += 1;
					return 1;
				} 
				else {
					nonOpSymbol += 1;
					return null;
				}
			}
		}
		
		static void parenthesesChecker(String[] splitElements, Integer[] elementPrecedence) {
			for(int element=0; element < size; element++) {
				if(splitElements[element].equals("(")) {
					elementPrecedence[element]+=pairParenthesis*10;
					pairParenthesis+=1;
				}
				else if(splitElements[element].equals(")")) {
					pairParenthesis-=1;
					elementPrecedence[element]+=pairParenthesis*10;
					if(pairParenthesis>1) {
						elementInParentheses+=1;
					}
				}
				else if(pairParenthesis>=1){
					elementPrecedence[element]+=pairParenthesis*10;
					elementInParentheses+=1;
				}
			}
		}
		
		static String infixValidation(String[] splitElements, Integer[] elementPrecedence) {
			String validation="";
			for(int i = 0; i < size; i++) {
				try {
					if((splitElements[0].matches("^[- +  * / ^]+$")) // checks if input is prefixed
							|| (splitElements[size-1].matches("^[- +  * / ^]+$")) // checks if input is postfixed
							|| (elementPrecedence[i] % 2 == 0 && elementPrecedence[i+1] % 2 == 0) // checks if there are consecutive operators
							|| (splitElements[i].equals("(") && elementPrecedence[i+1] % 2 !=1) // checks if an element after an opening parenthesis is an operator
							|| (splitElements[i].equals(")") && elementPrecedence[i-1] % 2 !=1) // checks if an element after a closing parenthesis is an operator
							|| ((elementInParentheses <= 2 && elementInParentheses !=0)) // checks if number of elements inside parenthesis is valid
							|| (operatorCount >= operandCount) // checks if operators are more than number of operands
							|| (operatorCount < operandCount-1) // checks if operators are less than expected number
							|| (nonOpSymbol > 0) // checks if there are any non-operator symbols
							|| (openParentheses != closeParentheses) // checks if parentheses in input are paired
							){
								validation = "Input is Invalid";
								isValid = false;
								break;
							}
							else {
								validation = "Input is Valid";
								isValid = true;
							}
				}
				catch (NullPointerException e) {
					validation = "Input is Invalid";
				}
			}
			return validation;
		}
		
}
