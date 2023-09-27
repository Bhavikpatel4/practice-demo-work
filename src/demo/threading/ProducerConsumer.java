package demo.threading;

public class ProducerConsumer {
	public static void main(String[] args) {
		Shop shop = new Shop();
		Producer producer1 = new Producer(shop, 1);
		Consumer consumer1 = new Consumer(shop, 1);
		
		Thread pThread1 = new Thread(producer1);
		Thread cThread1 = new Thread(consumer1);
		
		pThread1.start();
		cThread1.start();
	}
}

class Shop {
	private int material;
	private boolean available;
	
	public Shop() {
		this.material = 0;
		this.available = false;
	}
	
	public synchronized int get() {
		while(!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return material;
	}
	
	public synchronized void put(int value) {
		while(available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		material = value;
		available = true;
		notifyAll();
	}
}

class Consumer implements Runnable {
	private Shop shop;
	private int id;
	
	public Consumer(Shop shop, int id) {
		this.shop = shop;
		this.id = id;
	}

	@Override
	public void run() {
		int value = 0;
		for (int i = 1; i <= 10; i++) {
			value = shop.get();
			System.out.println("Consumed value by consumer-" + this.id+ " got: " + value);
		}
	}
}

class Producer implements Runnable {
	private Shop shop;
	private int id;
	
	public Producer(Shop shop, int id) {
		this.shop = shop;
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			shop.put(i);
			System.out.println("Produced value by producer-" + this.id+ " put: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}