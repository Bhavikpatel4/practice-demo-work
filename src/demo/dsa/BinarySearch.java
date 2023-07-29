package demo.dsa;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3, 3, 3, 3, 3, 3, 6, 65, 656, 6556, 7878 };
		int[] arr1 = { -1, -1 };
		arr1[0] = binarySearch(arr, 3, true);
		arr1[1] = binarySearch(arr, 3, false);
		System.out.println(arr1[0] + " " + arr1[1]);
	}

	public static int binarySearch(int arr[], int targetElement, boolean searchFirstIndex) {
		int s = 0, e = arr.length - 1, ans = 0;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (arr[mid] < targetElement) {
				s = mid + 1;
			} else if (arr[mid] > targetElement) {
				e = mid - 1;
			} else {
				ans = mid;
				if (searchFirstIndex) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			}
		}
		return ans;
	}
}
