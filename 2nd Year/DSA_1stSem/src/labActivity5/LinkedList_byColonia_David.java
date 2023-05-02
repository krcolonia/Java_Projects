package labActivity5;

public class LinkedList_byColonia_David {
	
	linkedListNode start = null, temp = null, hold = null;
	
	class linkedListNode {
		int data;
		linkedListNode next;
		
		linkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	void insertBeginning(int data) {
		linkedListNode newNode = new linkedListNode(data);
		
		if(start == null) {
			newNode.next = null;
		}
		else {
			newNode.next = start;
		}
				
		start = newNode;
		
		System.out.println("\nInsertion of ( " + data  + " ) at the Beginning Successful");
		
		return;
	}
	
	void insertEnd(int data) {
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
		
		System.out.println("\nInsertion of ( " + data + " ) at the End Successful");
		
		return;
	}
	
	void insertAnyPosition(int data, int pos) {
		if(start == null) {
			System.out.println("Linked List is currently Empty. Cannot continue with INSERTION.");
			return;
		}
		
		if(pos < 1) {
			System.out.println("Input is invalid. This option does not support insertion at the beginning.");
			return;
		}
		
		temp = start;
		
		int k = 1;
		
		while(k < pos) {
			temp = temp.next;
			if(temp==null) {
				System.out.println("Nodes in list are less than position");
				return;
			}
			k += 1;
		}
		linkedListNode newNode = new linkedListNode(data);
		newNode.data = data;
		newNode.next = temp.next;
		temp.next = newNode;	
		
		System.out.println("\nInsertion of ( " + data + " ) at the Specified Position of ( " + pos + " ) Successful");
		
		return;
	}
	
	void deleteBeginning() {
		
		if(start == null) {
			System.out.println("Linked List is currently empty. Cannot continue with DELETION.");
			return;
		}
		
		temp = start;
		start = start.next;
		temp = null;
		
		System.out.println("\nDeletion at the Beginning Successful");
		
		return;
	}
	
	void deleteEnd() {
		if(start == null) {
			System.out.println("Linked List is currently empty. Cannot continue with DELETION.");
			return;
		}
		
		temp = start;
		
		while(temp.next.next != null) {
			temp = temp.next;
		}
		
		temp.next = null;
		
		System.out.println("\nDeletion at the End Successful");
		
		return;
	}
	
	void deleteAtSpecificData(int data) {
		if(start == null) {
			System.out.println("Linked List is currently Empty. Cannot continue with DELETION.");
			return;
		}
		
		if(start.data == data) {
			temp = start;
			start = start.next;
			temp = null;
			
			System.out.println("\nDeletion of Specified Data ( " + data + " ) Successful");
			
			return;
		}
		
		hold = start;
		
		while(hold.next.next != null) {
			if(hold.next.data == data) {
				temp = hold.next;
				hold.next = temp.next;
				temp = null;
				
				System.out.println("\nDeletion of Specified Data ( " + data + " ) Successful");
				
				return;
			}
			hold = hold.next;
		}
		
		if(hold.next.data == data) {
			temp = hold.next;
			temp = null;
			hold.next = null;
			
			System.out.println("\nDeletion of Specified Data ( " + data + " ) Successful");
			
			return;
		}
		
		System.out.println("\nData not found. Cannot continue with DELETION.");
		return;
	}
	
	void displayLinkedList() {
		if(start == null) {
			System.out.println("Linked List is currently empty");
			return;
		}
		
		temp = start;
		
		while (temp != null) {
			System.out.print("( " + temp.data + " )" + " => ");
			temp = temp.next;
		}
		System.out.println(temp);
		return;
	}
}
