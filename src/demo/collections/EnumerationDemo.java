package demo.collections;

import java.util.Enumeration;
import java.util.Vector;

/*
	Used for legacy class
	Can't perform manipulation operation
*/
public class EnumerationDemo {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>();
		for(int i=1; i<=10; i++) {
			vector.addElement(i);
		}
		System.out.println(vector);
		
		Enumeration<Integer> enumeration = vector.elements();
		while(enumeration.hasMoreElements()) {
			Integer element = enumeration.nextElement();
			if(element % 2 == 0) {
				System.out.println(element);
			}
		}
		
		System.out.println(vector);
	}
}
