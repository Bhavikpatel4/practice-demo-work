package demo.threading;

// Recommended way to use multi-threading 
public class MultiThreadingUsingRunnableDemo {

	public static void main(String[] args) {
		Runnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("Calling from main method : " + i);
		}
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Calling from MyThread class method : " + i);
		}
	}
}