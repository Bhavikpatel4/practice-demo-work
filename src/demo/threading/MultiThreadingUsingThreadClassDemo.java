package demo.threading;

public class MultiThreadingUsingThreadClassDemo {
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		
		// A thread can be started at most once else throw java.lang.IllegalThreadStateException exception
//		myThread.start();
		
		// Work but not recommended bcoz that call empty run method of Thread Class
		EmptyThread emptyThread = new EmptyThread();
		emptyThread.start();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("Calling from main method : " + i);
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Calling from MyThread class method : " + i);
		}
	}
}

class EmptyThread extends Thread {
	
}
