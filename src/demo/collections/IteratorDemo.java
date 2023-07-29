package demo.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
	Used for all collection - Universal Cursor
	Perform remove operation
	Can't perform add or set operation
*/
public class IteratorDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			if(element % 2 == 0) {
				System.out.println(element);
			}
			else {
				iterator.remove();
			}
		}
		System.out.println(list);
	}
}
