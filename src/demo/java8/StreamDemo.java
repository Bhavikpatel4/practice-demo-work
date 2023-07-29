package demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		List<String> temp = new ArrayList<String>();
		temp.add("31");
		temp.add("32");
		temp.add("33");
		temp.add("34");
		temp.add("35");
		List<String> jobCards = new ArrayList<String>();
		jobCards.add("31");
		jobCards.add("32");
		jobCards.add("35");
		
		System.out.println(temp);
		
		temp.retainAll(jobCards);
//		for(String id : temp) {
//			boolean flag = jobCards.contains(id);
//			if(!flag) {
//				temp.remove(id);
//			}
//		}
		
		System.out.println(temp);
	}
}
