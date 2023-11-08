package demo.dsa;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);*/

public class StringZigzagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println("Zigzag String : " + convert(s, numRows));
	}
	
	public static String convert(String s, int numRows) {
		if(numRows == 1)
			return s;
		
		StringBuilder[] listOfSb = new StringBuilder[numRows];
		for(int i=0; i<numRows; i++) {
			listOfSb[i] = new StringBuilder();
		}
		
		int k = (numRows - 1) * 2;
		
		for(int i=0; i<s.length(); i++) {
			int rest = i % k;
			int row = rest < numRows ? rest : k - rest;
			listOfSb[row].append(s.charAt(i));
		}
		
		StringBuilder result = new StringBuilder();
		for(StringBuilder sb : listOfSb) {
			result.append(sb);
		}
		
		return result.toString();
    }
}
