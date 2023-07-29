package demo.dsa;

class CustomLinkedList<E> {
	Node<E> head;
	int size = 0;
	
	class Node<E> {
		E data;
		Node<E> next;
		
		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node<E> getNode(int index) {
		Node<E> x = this.head;
		for(int i=0; i<index; i++)
			x = x.next;
		return x;
	}
	
	public void add(E data) {
		Node<E> node = new Node<E>(data);
		this.size++;
		if(this.head == null) {
			this.head = node;
			return;
		}
		
		Node<E> currentNode = this.head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
	}
	
	public void addFirst(E data) {
		Node<E> node = new Node<E>(data);
		this.size++;
		if(this.head == null) {
			this.head = node;
			return;
		}
		
		node.next = this.head;
		this.head = node;
	}
	
	public void addLast(E data) {
		this.add(data);
	}
	
	public void add(int index, E data) {
		if(!(index >=0 && index <= this.size)) {
			System.out.println("Invalid Index!!!");
			return;
		}
		
		if(index == 0) {
			addFirst(data);
			return;
		}
		
		this.size++;
		Node<E> curNode = new Node<E>(data);
		Node<E> prevNode = this.getNode(--index);
		Node<E> nextNode = prevNode.next;
		
		prevNode.next = curNode;
		curNode.next = nextNode;
	}
	
	public void remove() {
		if(this.head == null) {
			System.out.println("List is empty!!!");
			return;
		}
		
		this.size--;
		if(this.head.next == null) {
			head = null;
			return;
		}
		
		Node<E> currentNode = this.head;
		Node<E> nextNode = this.head.next;
		
		while(nextNode.next != null) {
			nextNode = nextNode.next;
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}
	
	public void removeFirst() {
		if(this.head == null) {
			System.out.println("List is empty!!!");
			return;
		}
		
		this.size--;
		this.head = this.head.next;
	}
	
	public void remove(int index) {
		if(!(index >=0 && index < this.size)) {
			System.out.println("Invalid Index!!!");
			return;
		}
		
		if(index == 0) {
			removeFirst();
			return;
		}
		
		this.size--;
		Node<E> prevNode = this.getNode(--index);
		prevNode.next = prevNode.next.next;
	}
	
	public E get(int index) {
		if(!(index >=0 && index < this.size)) {
			System.out.println("Invalid Index!!!");
			return (E) "-1";
		}
		
		return getNode(index).data;
	}
	
	public void set(int index, E data) {
		if(!(index >=0 && index < this.size)) {
			System.out.println("Invalid Index!!!");
			return;
		}
		
		getNode(index).data = data;
	}
	
	public void reverse() {
		if(this.size == 0 || this.size == 1)
			return;
		
		Node<E> prevNode = this.head;
		Node<E> curNode = prevNode.next;
		
		while(curNode != null) {
			Node<E> nextNode = curNode.next;
			
			curNode.next = prevNode;
			
			prevNode = curNode;
			curNode = nextNode;
		}
		
		this.head.next = null;
		this.head = prevNode;
	}
	
	private Node<E> recursiveReverse(Node<E> first) {
		if(first.next == null)
			return first;
		
		Node<E> newFirst = recursiveReverse(first.next);
		first.next.next = first;
		
		return newFirst;
	}
	
	public void reverseUsingRecursion() {
		if(this.size == 0 || this.size == 1)
			return;
		
		Node<E> first = this.recursiveReverse(this.head);
		this.head.next = null;
		this.head = first;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> currentNode = this.head;
		while(currentNode != null) {
			sb.append(currentNode.data);
			currentNode = currentNode.next;
			
			if(currentNode != null)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}

public class LinkedListDemo {

	public static void main(String[] args) {
		CustomLinkedList<Integer> cl = new CustomLinkedList<Integer>();
		cl.add(2);
		cl.add(3);
		cl.addFirst(1);
		cl.addLast(4);
		System.out.println(cl + " - " + cl.size);
		
		cl.add(0, 0);
		System.out.println(cl + " - " + cl.size);
		
		cl.add(2, 10);
		System.out.println(cl + " - " + cl.size);
		
		cl.add(6, 100);
		System.out.println(cl + " - " + cl.size);
		
		cl.remove(0);
		System.out.println(cl + " - " + cl.size);
		
		cl.remove(2);
		System.out.println(cl + " - " + cl.size);
		
		cl.remove(cl.size-1);
		System.out.println(cl + " - " + cl.size);
		
		System.out.println(cl.get(3));
		
		cl.set(1, 2);
		System.out.println(cl + " - " + cl.size);
		
		cl.reverse();
		System.out.println(cl + " - " + cl.size);
		
		cl.reverseUsingRecursion();
		System.out.println(cl + " - " + cl.size);
	}

}
