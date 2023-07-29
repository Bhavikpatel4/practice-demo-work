package demo.java;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultithreadingWithCollectionDemo {
	
	public static void main(String[] args) throws InterruptedException 
	{
		List<Integer> list1 = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
		
		// Normal Collection
//		Runnable r1 = () -> {
//			list1.forEach(i -> System.out.println("Print : " + i));
//		};
//		
//		Runnable r2 = () -> {
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			list1.add(1000);
//			System.out.println("Adding ");
//		};
//		
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		
//		t1.start();
//		t2.start();
		
		// Concurrent Collection
		List<Integer> synchronizedList = Collections.synchronizedList(list1);
		
		synchronized (synchronizedList) {
			Runnable r1 = () -> {
				for(int i=0; i<synchronizedList.size(); i++) {
					System.out.println("Print : " + synchronizedList.get(i));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			Runnable r2 = () -> {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronizedList.add(1000);
				synchronizedList.remove(200);
				System.out.println("Adding ");
			};
			
			Runnable r3 = () -> {
				for(int i=0; i<synchronizedList.size(); i++) {
					System.out.println("Square : " + synchronizedList.get(i)*synchronizedList.get(i));
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);
			Thread t3 = new Thread(r3);
			
			t1.start();
			t1.join(1000);
			t3.start();
			t2.start();
			
		}
		
	}
}
