package demo.test;

import java.util.function.Predicate;

public class Test {
	public static void main(String[] args) {
		Predicate<String> p1 = str -> str != null;
		Predicate<String> p2 = i -> !i.equals("");
		
		System.out.println(p1.and(p2).test(null));
		
		Calculation cal = (a, b) -> a * b;
		
		System.out.println(cal.multiply(7, 5));
	}
}

@FunctionalInterface
interface Calculation {
	int multiply(int a, int b);
}