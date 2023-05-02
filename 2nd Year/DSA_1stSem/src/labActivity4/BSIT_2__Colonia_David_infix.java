package labActivity4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BSIT_2__Colonia_David_infix {
	
	static Scanner input = new Scanner(System.in);
	static String infix, postfixString, prefixString;
	static String splitElements[], reverseSplitElements[], operatorStack[], stringStack[];
	static Integer elementPrecedence[], reverseElementPrecedence[], operatorPrecedenceStack[];
			
	static Integer size, stackSize=0, operandCount, operatorCount, openParentheses, closeParentheses, nonOpSymbol, elementInParentheses, stackInitial, pairParenthesis=0, topVal, stringTop, opTop, opPrecTop;
	static Integer menuInput;
	static boolean isValid = false, canTry = true, ifProgramRun = true, isEmpty;
	
	public static void main(String[] args) {
		
		System.out.println("\nData Structures and Algorithms | Infix Program"
				+ "\nProgrammed by Colonia and David from 2BSIT-2, A.Y. 2022-2023");
		
		while(ifProgramRun) {
			while(!isValid) {
				System.out.print("\nInput Infix Notation: ");
				infix = input.nextLine();
				infixInput(infix);
				System.out.println(infixValidation(splitElements, elementPrecedence));
			}
			menu();
		}
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
		
		reverseInput();
		
		operatorStackInitialize();
		stringStackInitialize();
		
		
	}
	
	static void menu() {
		do {
			canTry=true;
			try {
				System.out.println("\nMAIN MENU:"
						 + "\n1. PREFIX EXPRESSION"
						 + "\n2. POSTFIX EXPRESSION"
						 + "\n3. INPUT NEW INFIX EXPRESSION"
						 + "\n4. EXIT PROGRAM\n");
				
				System.out.print("Enter Choice [1-4]: ");
				menuInput = input.nextInt();
				canTry=false;
			}
			catch(InputMismatchException e) {
				System.out.println("Input Invalid. Please only enter an Integer value ranging from 1 to 4.");
				input.nextLine();
				continue;
			}
		} while(canTry);
		
		switch(menuInput) {
		case 1:
			System.out.println("INFIX EXPRESSION TO PREFIX EXPRESSION\n");
			prefix();
			input.nextLine();
			break;
		case 2:
			System.out.println("INFIX EXPRESSION TO POSTFIX EXPRESSION\n");
			postfix();
			input.nextLine();
			break;
		case 3:
			input.nextLine();
			isValid=false;
			break;
		case 4:
			System.out.println("\nExiting Program. Program coded by Colonia and David from 2BSIT-2.");
			ifProgramRun = false;
		default:
		}
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
						|| ((elementInParentheses <= 2 && elementInParentheses !=0)
						   && (elementInParentheses !=0) )
						|| (operatorCount >= operandCount) // checks if operators are more than number of operands
						|| (operatorCount < operandCount-1) // checks if operators are less than expected number
						|| (nonOpSymbol > 0) // checks if there are any non-operator symbols
						|| (openParentheses != closeParentheses) // checks if parentheses in input are paired
						|| (splitElements[i].equals(""))
						|| (infix.equals(""))
						){
							validation = "Input is Invalid\n";
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
	
	// methods for stack initialization
	
	static void operatorStackInitialize() {
		
		stackInitial = 0;
		operatorStack = new String[operatorCount];
		operatorPrecedenceStack = new Integer[operatorCount];
		while(stackInitial < operatorCount) {
			operatorStack[stackInitial] = null;
			stackInitial++;
		}
	}
	
	static void stringStackInitialize() {
		
		stackInitial = 0;
		stringStack = new String[size];
		
		while (stackInitial < size) {
			stringStack[stackInitial] = null;
			stackInitial++;
		}
		
	}
	
	// methods for stack operations

	static void pushString(String[] stack, Integer stackLength, String pushString) {
		
		for(int pushElement = 0; pushElement < stackLength; pushElement++) {
			if(stack[pushElement] == null) {
				stack[pushElement] = pushString;
				break;
			}
		}
	}
	
	static void pushInteger(Integer[] stack, Integer stackLength, Integer pushInt) {
		
		for(int pushElement = 0; pushElement < stackLength; pushElement++) {
			if(stack[pushElement] == null) {
				stack[pushElement] = pushInt;
				break;
			}
		}
	}
	
	static void popString(String[] stack, Integer stackLength) {
		
		for(int popElement = stackLength-1; popElement >= 0; popElement--) {
			if(stack[popElement] != null) {
				stack[popElement] = null;
				break;
			}
			else if(stack[popElement] == null && popElement == 0){
				break;
			}
		}
	}
	
	static void popInteger(Integer[] stack, Integer stackLength) {
		
		for(int popElement = stackLength-1; popElement >= 0; popElement--) {
			if(stack[popElement] != null) {
				stack[popElement] = null;
				break;
			}
			else if(stack[popElement] == null && popElement == 0){
				break;
			}
		}
	}
	
	static Integer size(String[] stack, Integer stackLength) {
		for(int topElement = stackLength-1; topElement >= 0; topElement--) {
			if(stack[topElement] != null) {
				stackSize = topElement+1;
				break;
			}
			else {
				continue;
			}
		}
		
		return stackSize;
	}
	
	static Integer topString(String[] stack, Integer stackLength) {
		for(int topElement = stackLength-1; topElement >= 0; topElement--) {
			if(stack[topElement] != null) {
				topVal = topElement;
				break;
			}
			else {
				topVal=null;
				continue;
			}
		}
		return topVal;
	}
	
	static Integer topInteger(Integer[] stack, Integer stackLength) {
		for(int topElement = stackLength-1; topElement >= 0; topElement--) {
			if(stack[topElement] != null) {
				topVal = topElement;
				break;
			}
			else {
				topVal=null;
				continue;
			}
		}
		return topVal;
	}
	
	static boolean empty(String[] stack, Integer stackLength) {
		for(int emptyElement = stackLength-1; emptyElement >=0; emptyElement--) {
			if(stack[emptyElement]!=null) {
				isEmpty = false;
			}
			else {
				isEmpty = true;
			}
		}
		return isEmpty;
	}	
	
	// method for reversing infix input for prefix
	
	static void reverseInput() {
		reverseSplitElements = new String[size];
		reverseElementPrecedence  = new Integer[size];
		
		int j = 0;
		
		for(int i = size-1; i >= 0; i--) {
			
			reverseSplitElements[i] = splitElements[j];
			reverseElementPrecedence[i] = elementPrecedence[j];
			
			j+=1;
		}
	}
	
	// prefix operation method
	
	static void prefix() {
		
		operatorStackInitialize();
		stringStackInitialize();
		
		prefixString="";
		opTop = 0;
		opPrecTop = 0;

		System.out.println("Scanned Character\t"
						 + "Stack\t\t\t"
						 + "Postfix String");
		
		for(int i = 0; i < size; i++) {
			if((reverseElementPrecedence[i] % 10 == 1)
			&& (reverseElementPrecedence[i] % 10 != 7)) {
				
			pushString(stringStack, size, reverseSplitElements[i]);
				
				System.out.print(reverseSplitElements[i]
							   + "\t\t\t");
			
				for(int j=0;j<operatorCount;j++) {
					if(operatorStack[j] != null)
						System.out.print(operatorStack[j] + " ");
				}
			
				if(size(operatorStack, operatorCount) >= 4)
					System.out.print("\t\t");
				else
					System.out.print("\t\t\t");
				
				for(int j=0;j<size;j++) {
					if(stringStack[j] != null)
						System.out.print(stringStack[j] + " "); 
				}
				System.out.println();
			}
			else if (reverseElementPrecedence[i] % 10 != 1
					&& (reverseElementPrecedence[i] % 10 != 7)
					&& empty(operatorStack, operatorCount)) {
				
				pushString(operatorStack, operatorCount, reverseSplitElements[i]);
				pushInteger(operatorPrecedenceStack, operatorCount, reverseElementPrecedence[i]);
				
				opTop = topString(operatorStack, operatorCount);
				opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
				
					System.out.print(reverseSplitElements[i]
								   + "\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");
					else
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
			}
			else if (reverseElementPrecedence[i] % 10 != 1
					&& (reverseElementPrecedence[i] % 10 != 7)
					&& !empty(operatorStack, operatorCount)
					&& operatorPrecedenceStack[opTop] <= reverseElementPrecedence[i]) {
				
				pushString(operatorStack, operatorCount, reverseSplitElements[i]);
				pushInteger(operatorPrecedenceStack, operatorCount, reverseElementPrecedence[i]);
				
				opTop = topString(operatorStack, operatorCount);
				opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
				
					System.out.print(reverseSplitElements[i]
								   + "\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");
					else
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
			}
			else if (reverseElementPrecedence[i] % 10 != 1
					&& (reverseElementPrecedence[i] % 10 != 7)
					&& !empty(operatorStack, operatorCount)
					&& operatorPrecedenceStack[opTop] > reverseElementPrecedence[i]) {
				
					for(int j=operatorCount-1;j>=0;j--) {
						if (operatorPrecedenceStack[j]==null) {
							continue;
						}
						else if(operatorPrecedenceStack[opTop] > reverseElementPrecedence[i]) {
							pushString(stringStack, size, operatorStack[opTop]);
							popString(operatorStack, operatorCount);
							popInteger(operatorPrecedenceStack, operatorCount);
							opTop = topString(operatorStack, operatorCount);
							opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
						}
						else {
							break;
						}
					}
					
					pushString(operatorStack, operatorCount, reverseSplitElements[i]);
					pushInteger(operatorPrecedenceStack, operatorCount, reverseElementPrecedence[i]);
					
					opTop = topString(operatorStack, operatorCount);
					opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
			
						System.out.print(reverseSplitElements[i]
									   + "\t\t\t");
					
						for(int j=0;j<operatorCount;j++) {
							if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
						}
					
						if(size(operatorStack, operatorCount) >= 4)
							System.out.print("\t\t");
						else
							System.out.print("\t\t\t");						
					
						for(int j=0;j<size;j++) {
							if(stringStack[j] != null)
								System.out.print(stringStack[j] + " "); 
						}
						System.out.println();
			}
		}
		for(int i = 0; i < size; i++) {
			
			if(stringStack[i] == null && !empty(operatorStack, operatorCount)) {
				
				pushString(stringStack, size, operatorStack[opTop]);
				popString(operatorStack, operatorCount);
				popInteger(operatorPrecedenceStack, operatorCount);
				opTop = topString(operatorStack, operatorCount);
				opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
				
					System.out.print("\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");					
					else
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
				
			}
			
		}
		
		for(int i=size-1;i>=0;i--) {
			if(stringStack[i] != null)
				prefixString += stringStack[i] + " ";
		}
		
		System.out.println("\n" + prefixString);
	}
	
	// postfix operation method
	
	static void postfix() {
		
		operatorStackInitialize();
		stringStackInitialize();
		
		postfixString="";
		opTop = 0;
		opPrecTop = 0;
		
		System.out.println("Scanned Character\t"
						 + "Stack\t\t\t"
						 + "Postfix String");
		
		for(int i = 0; i < size; i++) {
			
			if((elementPrecedence[i] % 10 == 1)
			&& (elementPrecedence[i] % 10 != 7)) {
				
				pushString(stringStack, size, splitElements[i]);
				
					System.out.print(splitElements[i]
								   + "\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");
					else
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
			}
			else if (elementPrecedence[i] > 1
					&& (elementPrecedence[i] % 10 != 7)
					&& empty(operatorStack, operatorCount)) {
				
				pushString(operatorStack, operatorCount, splitElements[i]);
				pushInteger(operatorPrecedenceStack, operatorCount, elementPrecedence[i]);
				
				opTop = topString(operatorStack, operatorCount);
				opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
				
					System.out.print(splitElements[i]
								   + "\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");
					else
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
			}
			else if (elementPrecedence[i] > 1
					&& (elementPrecedence[i] % 10 != 7)
					&& !empty(operatorStack, operatorCount)
					&& operatorPrecedenceStack[opTop] < elementPrecedence[i]) {
				
				pushString(operatorStack, operatorCount, splitElements[i]);
				pushInteger(operatorPrecedenceStack, operatorCount, elementPrecedence[i]);
				
				opTop = topString(operatorStack, operatorCount);
				opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
				
					System.out.print(splitElements[i]
								   + "\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");
					else
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
			}
			else if (elementPrecedence[i] > 1
					&& (elementPrecedence[i] % 10 != 7)
					&& !empty(operatorStack, operatorCount)
					&& operatorPrecedenceStack[opTop] >= elementPrecedence[i]) {
				
					for(int j = operatorCount-1; j >= 0; j--) {
						if (operatorPrecedenceStack[j]==null) {
							continue;
						}
						else if(operatorPrecedenceStack[opTop] >= elementPrecedence[i]) {
							pushString(stringStack, size, operatorStack[opTop]);
							popString(operatorStack, operatorCount);
							popInteger(operatorPrecedenceStack, operatorCount);
							opTop = topString(operatorStack, operatorCount);
							opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
						}
						else {
							break;
						}
					}
					
					pushString(operatorStack, operatorCount, splitElements[i]);
					pushInteger(operatorPrecedenceStack, operatorCount, elementPrecedence[i]);
					
					opTop = topString(operatorStack, operatorCount);
					opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
			
						System.out.print(splitElements[i]
							   + "\t\t\t");
					
						for(int j=0;j<operatorCount;j++) {
							if(operatorStack[j] != null)
								System.out.print(operatorStack[j] + " ");
						}
					
						if(size(operatorStack, operatorCount) >= 4)
							System.out.print("\t\t");
						else
							System.out.print("\t\t\t");
					
						for(int j=0;j<size;j++) {
							if(stringStack[j] != null)
								System.out.print(stringStack[j] + " "); 
						}
						System.out.println();
			}
		}
		for(int i = 0; i < size; i++) {
			
			if(stringStack[i] == null && !empty(operatorStack, operatorCount)) {
				
				pushString(stringStack, size, operatorStack[opTop]);
				popString(operatorStack, operatorCount);
				popInteger(operatorPrecedenceStack, operatorCount);
				opTop = topString(operatorStack, operatorCount);
				opPrecTop = topInteger(operatorPrecedenceStack, operatorCount);
				
					System.out.print("\t\t\t");
				
					for(int j=0;j<operatorCount;j++) {
						if(operatorStack[j] != null)
							System.out.print(operatorStack[j] + " ");
					}
				
					if(size(operatorStack, operatorCount) >= 4)
						System.out.print("\t\t");
					else 
						System.out.print("\t\t\t");
				
					for(int j=0;j<size;j++) {
						if(stringStack[j] != null)
							System.out.print(stringStack[j] + " "); 
					}
					System.out.println();
			}
			
		}
		
		System.out.println();
		
		for(int i=0;i<size;i++) {
			if(stringStack[i] != null)
				postfixString += stringStack[i] + " ";
		}
		
		System.out.println(postfixString);
	}
}