package demo.dsa;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		String s = "dabvdf";
		
		int length = s.length();
		int maxLength = 0;
		int left = 0;
		Set<Character> charSet = new LinkedHashSet<>();
		
		for(int right=0; right<length; right++) {
			if(!charSet.contains(s.charAt(right))) {
				charSet.add(s.charAt(right));
				maxLength = Math.max(maxLength, right-left+1);
			}
			else {
				while(charSet.contains(s.charAt(right))) {
					charSet.remove(s.charAt(left));
					left++;
				}
				charSet.add(s.charAt(right));
			}
		}
		System.out.println("Longest substring : " + charSet.stream().map(c->c.toString()).collect(Collectors.joining()));
		System.out.println("Length of longest substring : " + maxLength);
	}
}
