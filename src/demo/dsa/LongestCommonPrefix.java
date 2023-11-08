package demo.dsa;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "flith"};
		
		System.out.println("Longest Common Prefix : " + longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		
		int length = strs.length;
		String common = strs[0];
		
		for(int i=1; i<length; i++) {
			while(strs[i].indexOf(common) != 0) {
				common = common.substring(0, common.length()-1);
				
				if(common.isEmpty()) {
					return "";
				}
			}
		}
		
		return common;
	}
}
