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
		List<int[]> ans= new ArrayList<>();
		int [] help = new int[3];
		for(int i=0; i<arr.length-2;i++) {
			for(int j=i+1;j<arr.length;j++)
				for(int k=j+1;j<arr.length;k++) {
					
				}
			help[0]=arr[i];
			help[1]=arr[i+1];
			help[2]=arr[i+2];
			int temp = help[0]+help[1]+help[2];
			if(help[0]!=help[1]&&help[1]!=help[2]&&help[0]!=help[2]&&temp==target) {
				ans.add(help);
			}
			help[0]=0;
			help[1]=0;
			help[2]=0;	
			temp=0;
		}
		return ans;
	
	}

	public static void main(String[] args) {
		// Update your code below (here you can test you solution)
	}
}
