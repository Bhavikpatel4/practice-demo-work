package demo.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//	Input : {1, 0, 3, 5, 0, 2, 0}
//	Output : {1, 3, 5, 2, 0, 0, 0}

public class MoveZeroElementLast {
	public static void main(String[] args) {
		int[] arr = {1, 0, 0, 0, 3, 0, 5, 0, 2, 0};
		printArr(arr);
		
//		method1(arr);
		method2(arr);
		
		printArr(arr);
	}
	
	// single for loop
	public static void method1(int[] arr) {
		int count = 0;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] == 0) {
				if(arr[i+1] == 0) {
					count++;
				}
				else {
					arr[i-count] = arr[i+1];
					arr[i+1] = 0;
				}
			}
		}
	}
	
	// for loop(size of array) + while loop(no of zeros)
	public static void method2(int[] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count < arr.length) {
			arr[count++] = 0;
		}
	}
	
	public static void printArr(int[] arr) {
		Arrays.stream(arr)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(", ", "{", "}"))
			.chars()
			.mapToObj(c -> Character.valueOf((char)c))
			.forEach(System.out::print);
		System.out.println();
	}
}
