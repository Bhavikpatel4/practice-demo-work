package demo.dsa;

import java.util.HashMap;

public class NumberOfIdenticalPairs {
	public static void main(String[] args) {
		int[] nums = {1,1,1,1};
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i : nums) {
			int numCount = map.getOrDefault(i, 0);
			count += numCount;
			map.put(i, numCount+1);
		}
		
		System.out.println("Number of Identical Pairs : " + count);
	}
}
