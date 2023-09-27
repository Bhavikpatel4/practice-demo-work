package demo.threading;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		// Default priority of main thread is 5
		// And for all remaining thread the default priority inheriting from parent to child
		System.out.println("default main thread priority : " + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(10); // changing main thread priority
		System.out.println("main thread priority after change : " + Thread.currentThread().getPriority());
		
		MyThread myThread = new MyThread();
		System.out.println("child thread priority : " + myThread.getPriority()); // inherited from parent thread
	}
}
