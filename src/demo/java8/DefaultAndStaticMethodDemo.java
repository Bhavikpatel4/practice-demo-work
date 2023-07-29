package demo.java8;

interface StaticMethodExampleInJava8 {

	// normal abstract method
    public abstract void print();
 
    // default method
    public default void display() {
        System.out.println("Hello World inside default method");
    }
 
    // static method
    public static void show() {
        System.out.println("Hello World inside static method");
    }
}

class StaticMethodExampleInJava8Impl implements StaticMethodExampleInJava8 {
	
	@Override
	public void print() {
		System.out.println("Hello World inside Override Method");
	}
	
	// Hiding static method
    public static void show() {
        System.out.println("Hello World inside static hide method");
    }
}

public class DefaultAndStaticMethodDemo {
	
	public static void main(String[] args) {
		StaticMethodExampleInJava8 demo = new StaticMethodExampleInJava8Impl();
		
		demo.print();
		demo.display();
		StaticMethodExampleInJava8.show();
		StaticMethodExampleInJava8Impl.show();
	}

}
