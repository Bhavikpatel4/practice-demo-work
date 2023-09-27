package demo.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingReentrantLock {
	public static void main(String[] args) {
		List<String> buffer = new ArrayList<>();
		ReentrantLock bufferLock = new ReentrantLock();
		
		Thread producer1 = new Thread(new ItemProducer(buffer, bufferLock));
		producer1.setName("producer1");
		
		Thread consumer1 = new Thread(new ItemConsumer(buffer, bufferLock));
		consumer1.setName("consumer1");
		
		Thread consumer2 = new Thread(new ItemConsumer(buffer, bufferLock));
		consumer2.setName("consumer2");
		
		producer1.start();
		consumer1.start();
		consumer2.start();
	}
}

class ItemProducer implements Runnable {
	private List<String> buffer;
	private ReentrantLock bufferLock;
	
	public ItemProducer(List<String> buffer, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}

	@Override
	public void run() {
		String itemName = "";
		for (int i = 1; i <= 5; i++) {
			bufferLock.lock();
			try {
				itemName = "Item - " + i;
				buffer.add(itemName);
				System.out.println(Thread.currentThread().getName() + " added " + itemName);
			} finally {
				bufferLock.unlock();
			}
			
			try {
				Thread.sleep(new Random().nextInt(2000));
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted.");
			}
		}
	}
}

class ItemConsumer implements Runnable {
	private List<String> buffer;
	private ReentrantLock bufferLock;
	
	public ItemConsumer(List<String> buffer, ReentrantLock bufferLock) {
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}

	@Override
	public void run() {
		while(true) {
			bufferLock.lock();
			try {
				if(buffer.isEmpty()) {
					continue;
				}
				else if (buffer.get(0).equals("Item - 5")) {
					System.out.println(Thread.currentThread().getName() + " consumed " + buffer.remove(0));
					break;
				}
				else {
					System.out.println(Thread.currentThread().getName() + " consumed " + buffer.remove(0));
					Thread.sleep(new Random().nextInt(2000));
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted.");
			} finally {
				bufferLock.unlock();
			}
		}
	}
}