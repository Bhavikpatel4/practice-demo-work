package demo.dsa;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {6,3,9,5,2,8};
//		bubbleSort(arr);
//		selectionSort(arr);
		insertionSort(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void bubbleSort(int[] arr) {
		int len = arr.length-1;
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int sidx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[sidx] > arr[j]) {
					sidx = j;
				}
			}
			
			int temp = arr[sidx];
			arr[sidx] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j >= 0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[++j] = key;
		}
	}
}
