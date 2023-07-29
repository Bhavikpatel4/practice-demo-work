package demo.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
	Used for all list classes
	Bi-direction cursor
	Perform remove, add or set operation
*/
public class ListIteratorDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		ListIterator<Integer> listIterator = list.listIterator();
		while(listIterator.hasNext()) {
			Integer element = listIterator.next();
			if(element % 2 != 0) {
				listIterator.remove();
			}
			else if(element % 3 == 0) {
				listIterator.set(99);
			}
			else if(element == 8) {
				listIterator.add(80);
			}
		}
		System.out.println(list);
	}
}
