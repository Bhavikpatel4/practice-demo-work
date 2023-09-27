package demo.dsa;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		String s = "dvdf";
		
		int length = s.length();
		int maxLength = 0;
		int left = 0;
		Set<Character> charSet = new HashSet<>();
		
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
		
		System.out.println("Length of longest substring : " + maxLength);
	}
}
