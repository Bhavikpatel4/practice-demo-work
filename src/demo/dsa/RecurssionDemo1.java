package demo.dsa;

public class RecurssionDemo1 {
	
	public static void main(String[] args) {
		int n = 10;
		
//		printNumDesc(n);
		
//		int sum = calSum(n);
//		System.out.println(sum);
		
//		int pow = calPow(2, 3);
//		System.out.println(pow);
		
//		int powNew = calPowWithlognTimeComplexity(2, 8);
//		System.out.println(powNew);
		
//		int fact = calFactorial(n);
//		System.out.println(fact);
		
		printFibonacciSeries(0, 1, n-2);
	}
	
	//Print n numbers in descending order 
	public static void printNumDesc(int n) {
		if(n==0)
			return;
		printNumDesc(n-1);
		System.out.println(n);
	}
	
	//Calculate sum of first n numbers
	public static int calSum(int n) {
		if(n==1)
			return 1;
		return n + calSum(n-1);
	}
	
	//Calculate power of x to n
	public static int calPow(int x, int n) {
		if(n==0)
			return 1;
		return x * calPow(x, n-1);
	}
	
	//Calculate power of x to n with log(n) time complexity
	public static int calPowWithlognTimeComplexity(int x, int n) {
		if(n==0)
			return 1;
		
		if(n % 2 == 0)
			return calPowWithlognTimeComplexity(x,n/2) * calPowWithlognTimeComplexity(x,n/2);
		else
			return calPowWithlognTimeComplexity(x,n/2) * calPowWithlognTimeComplexity(x,n/2) * x;
	}
	
	//Calculate factorial of number n
	public static int calFactorial(int n) {
		if(n==1 || n==0)
			return 1;
		return n * calFactorial(n-1);
	}
	
	//Print fibonacci series upto nth term
	public static void printFibonacciSeries(int a, int b, int n) {
		if(a==0 && b==1) {
			System.out.print(a+" "+b+" ");
		}
		if(n==0)
			return;
		System.out.print((a+b)+" ");
		printFibonacciSeries(b, a+b, n-1);;
	}
}
