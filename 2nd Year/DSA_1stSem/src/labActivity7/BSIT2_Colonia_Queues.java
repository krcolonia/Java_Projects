package labActivity7;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BSIT2_Colonia_Queues {
	
	static Integer arrayQueue[]; // Declares Queue array
	static Integer size, front, rear; // Queue variables
	static Integer menuInput, enqueueInput; // Menu variables
	
	static Scanner input = new Scanner(System.in); // Imported Scanner method
	
	static boolean canTry = true, canContinue = true; // Program Looping variables
	
	public static void main(String[] args) {
		System.out.println("\nData Structures and Algorithms | Queues"
				+ "\nProgrammed by Colonia, Kurt Robin from 2BSIT-2, A.Y. 2022-2023");
		
		mainMenu();
	}
	
	// Main Menu Methods
	
	static void mainMenuInput() {
		do {
			try {
				System.out.print("\nEnter Choice [1-3]: ");
				menuInput = input.nextInt();
				
				canTry = false;
			}
			catch(InputMismatchException e){
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		} while (canTry);
	}
	
	static void mainMenu() {
		System.out.println("\nMain Menu:"
				 + "\n1. Array Implementation"
				 + "\n2. Linked List Implementation"
				 + "\n3. Exit");
		
		mainMenuInput();
		
		switch(menuInput) {
		case 1:
			arrayQueueSizeInput();
			
			while(canContinue) {
				arrayQueueMenu();
			}
			break;
		case 2:
			linkedListInitialization();
			
			while(canContinue) {
				linkedListQueueMenu();
			}
			break;
		case 3:
			System.out.println("\nExiting Program. Program Coded by Colonia, Kurt from 2BSIT-2");
			break;
		default:
			System.out.println("\nInput Invalid. Please only enter an Integer value between 1 and 3");
		}
	}
	
	// Array Implementation Methods
	
	static void arrayQueueSizeInput() {
		do {
			try {
				System.out.print("Enter the size of the Queue: ");
				size = input.nextInt();
				
				arrayQueue = new Integer[size];
				front = rear = -1;
				
				canTry=false;
			} 
			catch(InputMismatchException e) {
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		} while(canTry);
	}
	
	static void arrayQueueMenuInput() {
		do {
			try {
				System.out.print("\nEnter Choice [1-4]: ");
				menuInput = input.nextInt();
				
				canTry = false;
			}
			catch(InputMismatchException e){
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		} while (canTry);
	}
	
	static void enqueueInput() {
		do {
			try {
				System.out.print("\nEnter Data to be inserted: ");
				enqueueInput = input.nextInt();
				
				canTry=false;
			}
			catch(InputMismatchException e) {
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
		} while(canTry);
	}
	
	static void arrayEnqueue(int data) {
		if(rear == size-1) {
			System.out.println("\nQueue Overflow");
			return;
		}
		else {
			rear += 1;
			arrayQueue[rear] = data;
		}
		System.out.println("\nEnqueueing of ( " + data + " ) Successful");
		
		arrayDisplayQueue();
		
		return;
	}
	
	static void arrayDequeue() {
		if(front == rear) {
			System.out.println("\nQueue Underflow");
			return;
		}
		else {
			front += 1;
			arrayQueue[front] = null;
		}
		System.out.println("\nDequeueing Successful");
		
		arrayDisplayQueue();
		
		return;
	}
	
	static void arrayDisplayQueue() {
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		
		if(front == -1 && rear == -1) {
			System.out.println("\nQueue is Empty");
			return;
		}
		
		System.out.print("\nQueue: ");
		
		for(int i=0; i < size; i++) {
			System.out.print(arrayQueue[i] + " ");
		}
		
		System.out.println("\nFront: " + (front+1)
						 + "\nRear: " + rear);
	}
	
	static void arrayQueueMenu() {
		System.out.println("\nArray Queue Menu:"
						 + "\n1. Enqueue"
						 + "\n2. Dequeue"
						 + "\n3. Display Queue"
						 + "\n4. Exit");
		
		arrayQueueMenuInput();
		
		switch(menuInput) {
		case 1:
			System.out.println("\n[Array Queue] Enqueue");
			
			enqueueInput();
			arrayEnqueue(enqueueInput);
			
			break;
		case 2:
			System.out.println("\n[Array Queue] Dequeue");
			
			arrayDequeue();
			
			break;
		case 3:
			System.out.println("\n[Array Queue] Display Queue");
			
			arrayDisplayQueue();
			
			break;
		case 4:
			System.out.println("\nExiting Program. Program Coded by Colonia, Kurt from 2BSIT-2");
			canContinue=false;
			break;	
		default:
			System.out.println("\nInput Invalid. Please only enter an Integer value between 1 and 4");
		}
	}
	
	// Linked List Implementation Methods
	
	static linkedListNode start = null, temp = null, hold = null; // Linked List Variables
	
	static class linkedListNode {
		int data;
		linkedListNode next;
		
		linkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static void linkedListInitialization() {
		front = rear = -1;
	}
	
	static void linkedListEnqueue(int data) {
		linkedListNode newNode = new linkedListNode(data);
		
		linkedListNode temp = null;
		
		newNode.data = data;
		newNode.next = null;
		
		if(start == null) {
			start = newNode;
		}
		else {
			temp = start;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		
		rear += 1;
		System.out.println("\nEnqueueing of ( " + data + " ) Successful");
		
		linkedListDisplayQueue();
		
		return;
	}
	
	static void linkedListDequeue() {
		
		if(start == null) {
			System.out.println("\nQueue Underflow");
			return;
		}
		
		front += 1;
		temp = start;
		start = start.next;
		temp = null;
		
		System.out.println("\nDequeueing Successful");
		
		linkedListDisplayQueue();
		
		return;
	}

	static void linkedListDisplayQueue() {
		if(start == null) {
			System.out.println("\nQueue is empty");
			return;
		}
		
		temp = start;
		
		System.out.print("\nQueue: ");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println("\nFront: " + (front+1)
						 + "\nRear: " + rear);
		return;
	}
	
	static void linkedListQueueMenuInput() {
		do {
			try {
				System.out.print("\nEnter Choice [1-4]: ");
				menuInput = input.nextInt();
				
				canTry = false;
			}
			catch(InputMismatchException e){
				System.out.println("\nInput Invalid, not an Integer. Please try again\n");
			}
			finally {
				if(front == rear) {
					front = -1;
					rear = -1;
				}
			}
		} while (canTry);
	}
	
	static void linkedListQueueMenu() {
		System.gc(); // Garbage collector. Collects all unused (null) objects and deletes them.
		
		System.out.println("\nLinked List Queue Menu:"
				 + "\n1. Enqueue"
				 + "\n2. Dequeue"
				 + "\n3. Display Queue"
				 + "\n4. Exit");
		
		linkedListQueueMenuInput();
		
		switch(menuInput) {
		case 1:
			System.out.println("\n[Linked List Queue] Enqueue");
			
			enqueueInput();
			linkedListEnqueue(enqueueInput);
			
			break;
		case 2:
			System.out.println("\n[Linked List Queue] Dequeue");
			
			linkedListDequeue();
			
			break;
		case 3:
			System.out.println("\n[Linked List Queue] Display Queue");
			
			linkedListDisplayQueue();
			
			break;
		case 4:
			System.out.println("\nExiting Program. Program Coded by Colonia, Kurt from 2BSIT-2");
			canContinue=false;
			break;
		default:
			System.out.println("\nInput Invalid. Please only enter an Integer value between 1 and 4");
		}
	}
}
