package demo.threading;

public class GetSetThreadNameDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); // get current running thread name
		
		MyThread myThread = new MyThread();
		System.out.println(myThread.getName());
		
		// Change main thread name
		Thread.currentThread().setName("Bhavik Thread");
		System.out.println(Thread.currentThread().getName());
		
		int divide = 5/0; // Exception in thread "Bhavik Thread" java.lang.ArithmeticException: / by zero
	}
}
