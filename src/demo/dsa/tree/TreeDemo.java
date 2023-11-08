package demo.dsa.tree;

import java.util.HashSet;
import java.util.Set;

public class TreeDemo {

	public static void main(String[] args) {
		
	}
}

class Node<T> {
	T key;
	Set<Node<T>> childs;
	
	Node(T key) {
		this.key = key;
	}
	
	public boolean addChild(Node<T> child) {
		if(this.childs == null)
			this.childs = new HashSet<>();
		return this.childs.add(child);
	}
}