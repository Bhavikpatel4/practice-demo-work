package demo.dsa;

import java.util.StringJoiner;

// Get middle element of singly linked list in single pass
public class MidElementOfSinglyLinkedList {

	public static void main(String[] args) {
		Node head = createSinglyList(new String[] {"a","b","c","d","e","f"});
		printList(head);
		System.out.println("Middle Element : " + middleElement(head));
	}
	
	public static String middleElement(Node head) {
		Node current = head;
		int length = 0;
		Node middle = head;
		
		while(current.next != null) {
			length++;
			if(length % 2 == 0) {
				middle = middle.next;
			}
			current = current.next;
		}
		
		// for second middle when even elements in list
		if(length % 2 == 1) {
			middle = middle.next;
		}
		
		return middle.data;
	}
	
	public static Node createSinglyList(String[] arr) {
		Node head = null;
		Node preNode = null;
		for(int i=0; i<arr.length; i++) {
			Node node = new Node(arr[i], null);
			
			if(i == 0) {
				head = node;
			}
			else {
				preNode.next = node;
			}
			
			preNode = node;
		}
		
		return head;
	}
	
	public static void printList(Node head) {
		Node dummyHead = head;
		StringJoiner strJoiner = new StringJoiner(",","[","]");
		while(dummyHead != null) {
			strJoiner.add(dummyHead.data);
			dummyHead = dummyHead.next;
		}
		System.out.println("List Data : " + strJoiner.toString());
	}
}

class Node {
	String data;
	Node next;
	
	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}
}
