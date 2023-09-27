package demo.threading;

public class PriorityTest {

	public static void main(String[] args) {
		Runnable r1 = new GreetingRunnable1();
		Runnable r2 = new GreetingRunnable2();
		
		Thread thread1 = new Thread(r1);
		thread1.setPriority(6);
		
		Thread thread2 = new Thread(r2);
		thread2.setPriority(10);
		
		System.out.println("Started threads by main...");
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end of threads by main...");
	}
}

class GreetingRunnable1 implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello from GreetingRunnable1 - " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class GreetingRunnable2 implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Hello from GreetingRunnable2 - " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}