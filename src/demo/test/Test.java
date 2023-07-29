package demo.test;

public class Test {
	
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 6, 65, 656, 6556, 7878 };
		int[] arr1 = { -1, -1 };
		arr1[0] = binarySearch(arr, 3, true);
		arr1[1] = binarySearch(arr, 3, false);
		System.out.println(arr1[0] + " " + arr1[1]);
	}
	
	public static int binarySearch(int[] arr, int target, boolean isFirst) {
		int ans = -1;
		int start = 0, end = arr.length-1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(arr[mid] < target) {
				start = mid + 1;
			}
			else if(arr[mid] > target) {
				end = mid - 1;
			}
			else {
				ans = mid;
				if(isFirst) {
					end = mid -1;
				}
				else {
					start = mid + 1;
				}
			}
		}
		return ans;
	}
}