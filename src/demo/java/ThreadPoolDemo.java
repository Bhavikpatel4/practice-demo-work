package demo.java;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {

	private String name;
	private int loop;
	
	public Task(String name, int loop) {
		this.name = name;
		this.loop = loop;
	}

	@Override
	public void run() {
		try {
			for(int i=1; i<=loop*2; i++) {
				LocalTime localTime = LocalTime.now();
				if(i == 1) {
					System.out.println("Initialization Time for task name - "+ name +" = " + localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"))); 
				}
				else {
					System.out.println("Executing Time for task name - "+ name +" = " + localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
				}
				Thread.sleep(1000);
			}
			System.out.println(name+" complete");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ThreadPoolDemo {

	public static void main(String[] args) {
		// creates five tasks
        Runnable r1 = new Task("task 1", 1);
        Runnable r2 = new Task("task 2", 2);
        Runnable r3 = new Task("task 3", 3);
        Runnable r4 = new Task("task 4", 4);
        Runnable r5 = new Task("task 5", 5);
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        
        pool.shutdown();
	}
}
