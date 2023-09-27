package demo.java8;

import java.util.ArrayList;
import java.util.Random;

public class Java8Practice2 {
	public static void main(String[] args) {
		
		// 1. Write a program to print 5 random numbers using forEach in Java 8
		System.out.println("Random number using java 8 : ");
		new Random().ints(5).forEach(System.out::println);
		new Random().ints().limit(5).forEach(System.out::println);
		
		ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
		int sum = list.stream().mapToInt(i->i).sum();
		System.out.println(sum);
	}
}
