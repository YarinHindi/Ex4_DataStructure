package Ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//yarin hindi
public class Ex4 {
	private static void merge(int[] A, int[] temp, int from, int mid, int to){
		int a = from;
		int i = from;
		int j = mid + 1;
		while (i<=mid&&j<= to){
			if (A[i] < A[j]) {
				temp[a++] = A[i++];
			}
			else {
				temp[a++] = A[j++];
			}
		}
		while (i <= mid) {
			temp[a++] = A[i++];
		}
		for (i=from; i<=to; i++) {
			A[i] = temp[i];
		}
	}
	public static void mergeSort2(int[] arr){
		int low = 0;
		int high = arr.length - 1;
		int[] temp = Arrays.copyOf(arr, arr.length);
		for (int l = 1; l <= high - low; l = 2*l) {

			for (int i = low; i < high; i += 2*l){

				int from = i;
				int mid = i + l - 1;
				int to = Integer.min(i + 2*l - 1, high);
				merge(arr, temp, from, mid, to);
			}
		}
	}
	public static List<int[]> ThreeSum(int[] arr, int target) {
		mergeSort2(arr);
		List<List<Integer>> a = new LinkedList<>();
		LinkedList b = new LinkedList<>();
		for(int i=0; i<arr.length-2;i++) {
			b.add(arr[i]);
			b.add(arr[i+1]);
			b.add(arr[i+2]);
			int temp = (int) b.get(0)+(int) b.get(1)+(int) b.get(2);
			if(b.get(0)!=b.get(1)&&b.get(1)!=b.get(2)&&temp==target) {
				a.add(b);
			}
			b.clear();
		}
		
		return null;
	}

	public static void main(String[] args) {
		// Update your code below (here you can test you solution)
	}
}
