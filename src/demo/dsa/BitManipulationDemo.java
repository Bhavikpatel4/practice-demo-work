package demo.dsa;

public class BitManipulationDemo {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,1,2,3,1,2,3};
		int arr2[] = {2,2,2,5,5,4,4,4,4,9};
		
//		findNonRepeatNo1(arr);
//		detectOppositeSigns(1, 5);
//		findOddOccurNo(arr2);
//		System.out.println(addUsingBit(26, 15));
//		System.out.println(subtractUsingBit(26,52));
		swapBitsInNo(28,0,3,2);
	}
	
	//Find non repeating no from array where element repeat thrice
	public static void findNonRepeatNo1(int[] arr) {
		int ones = 0, twos = 0;
		int common;
		
		for(int i : arr) {
			twos = twos | (ones & i);
			ones = ones ^ i;
			
			common = ~(ones & twos);
			
			ones &= common;
			twos &= common;
		}
		
		System.out.println(ones);
	}
	
	//Detect if two integers have opposite signs
	public static void detectOppositeSigns(int a, int b) {
		if((a ^ b) < 0) {
			System.out.println("Numbers have different signs.");
		}
		else {
			System.out.println("Numbers have same signs.");
		}
	}
	
	//Find the two numbers with odd occurrences in an unsorted array
	public static void findOddOccurNo(int arr[]) {
		int result = 0, set_bit_no;
		int a = 0, b = 0;
		
		for(int i : arr) {
			result ^= i;
		}
		
		set_bit_no = result & ((~result)+1);
		
		for(int i : arr) {
			if((i & set_bit_no) > 0)
				a ^= i;
			else
				b ^= i;
		}
		
		System.out.println("The two ODD elements are "+ a + " & " + b);
	}

	//Add two no without arithmatic operator
	public static int addUsingBit(int a, int b) {
		if(b==0)
			return a;
		
		return addUsingBit(a^b, (a&b)<<1);
	}
	
	//Subtract two no without arithmatic operator
	public static int subtractUsingBit(int a, int b) {
		if(b==0)
			return a;
		
		return subtractUsingBit(a^b, (~a&b)<<1);
	}
	
	//Swap bits in a given number
	public static void swapBitsInNo(int x, int p1, int p2, int n) {
		// Move all bits of first set
        // to rightmost side
        int set1 = (x >> p1) & ((1 << n) - 1);
 
        // Move all bits of second set
        // to rightmost side
        int set2 = (x >> p2) & ((1 << n) - 1);
 
        // XOR the two sets
        int xor = (set1 ^ set2);
 
        // Put the xor bits back to
        // their original positions
        xor = (xor << p1) | (xor << p2);
 
        // XOR the 'xor' with the original number
        // so that the  two sets are swapped
        int result = x ^ xor;
		System.out.println(result);
	}
}
