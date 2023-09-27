package demo.dsa;

/*Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.*/

public class NumberOfSubstringsWithOnly1s {
	public static void main(String[] args) {
		String s = "0110111";
		int count = 0;
		int ans = 0;
		int mod = 1_000_000_007;
		
		for(char c : s.toCharArray()) {
			count = c == '1' ? count+1 : 0;
			ans = (ans + count) % mod;
		}
		
		System.out.println("Number of substring with only 1s : "+ ans);
	}
}
