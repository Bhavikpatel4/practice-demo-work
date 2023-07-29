package demo.dsa;

import java.util.HashSet;

public class RecursionDemo2 {

	public static void main(String[] args) {
		String str = "abc";
		HashSet<String> set = new HashSet<String>();
//		subSequences(str, 0, "", set);
		
//		printPalindrome(str, 0, "", set);
		
		printSubString(str, 0, 1);
	}
	
	//print all subsequences of given string
	public static void subSequences(String str, int idx, String seq, HashSet<String> set) {
		if(idx == str.length()) {
			if(!set.contains(seq)) {
				System.out.println(seq);
				set.add(seq);
			}
			return;
		}
		
		char c = str.charAt(idx);
		subSequences(str, idx+1, seq+c, set);
		subSequences(str, idx+1, seq, set);
	}
	
	//Print all substring
	public static void printSubString(String str,int start, int end) {
		if(start >= str.length() && end >= str.length()) {
			return;
		}
		else {
			if(end == str.length()+1) {
				printSubString(str, start+1, start+2);
			}
			else {
				System.out.println(str.substring(start, end));
				printSubString(str, start, end+1);
			}
		}
	}
	
	//Print all possible palindrome of given string
	public static void printPalindrome(String str, int idx, String seq, HashSet<String> set) {
		if(idx == str.length()) {
			if(!set.contains(seq)) {
				if(isPalindrome(seq))
					System.out.println(seq);
				set.add(seq);
			}
			return;
		}
		
		char c = str.charAt(idx);
		printPalindrome(str, idx+1, seq+c, set);
		printPalindrome(str, idx+1, seq, set);
	}
	
	//Check if string is palindrome
	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str);
		String revStr = sb.reverse().toString();
		if(str.equals(revStr))
			return true;
		return false;
	}

}
