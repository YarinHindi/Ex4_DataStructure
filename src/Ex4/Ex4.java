package Ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;
//yarin hindi
//lll
public class Ex4 {
	private static List<int[]> functionhelper(int a[],int s,int start,int end,List<int[]> v,int j) {
		while(start<a.length&&end>0&&start<end) {
			if(a[start]+a[end]==s) {
				int[] ans = new int[3];
				ans[0]=j;
				ans[1]=(a[start]);
				ans[2]=(a[end]);
				v.add(ans);
				start++;
				end--;

			}
			else if(a[start]+a[end]>s) {
				end--;
			}else if(a[start]+a[end]<s) {
				start++;
			}

		}

		return v;

	}

	public static List<int[]> ThreeSum(int[] arr, int target) {
		HashSet<Integer> myhash = new HashSet<Integer>(); 
		for(int i=0; i<arr.length;i++) {
			myhash.add(arr[i]);
		}
		int[] arrans= new int[myhash.size()];
		int p=0;
		for(int IN:myhash) {
			arrans[p]=IN;
			p++;
		}		
		Arrays.sort(arrans);
		List<int[]> v= new ArrayList<>();
		List<int[]> ans= new ArrayList<>();
		for(int i=0; i<arrans.length;i++) {
			int j=arrans[i];
			v=functionhelper(arrans, target-j, i+1, arrans.length-1,v,j);
		}
		return v;

	}
	public static int[] highestMult(int[]arr) {
		int ans[] = new int[2];
		int max2;
		int min1;
		int min2;
		int max1 = arr[0];
		int j=0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>max1) {
				max1=arr[i];
				j=i;
			}
		}
		arr[j]=0;
		max2 = arr[0];
		for(int p=0; p<arr.length;p++) {
			if(arr[p]>max2) {
				max2=arr[p];
				j=p;
			}

		}

		min1 = arr[0];

		for(int i=0; i<arr.length;i++) {
			if(arr[i]<min1) {
				min1=arr[i];
				j=i;
			}
		}
		arr[j]=0;
		min2 = arr[0];
		for(int p=0; p<arr.length;p++) {
			if(arr[p]< min2) {
				min2=arr[p];
				j=p;
			}
		}
		if(max1*max2>min1*min2) {
			ans[0]=max1;
			ans[1]=max2;

		}else {
			ans[0]=min1;
			ans[1]=min2;
		}
	

	return ans;

}


public static void main(String[] args) {  
	HashMap<Integer,Integer> myhash = new HashMap<>();
	int [] ss = {0,0,-1,0,0,-2,3};
	System.out.println(Arrays.toString(highestMult(ss)));
	int target= 8;
	//	List<int[]> ans= new ArrayList<>();
	//	ans=ThreeSum(ss, 5);  
	//	for(int i=0; i<ans.size();i++) {
	//		System.out.println(Arrays.toString(ans.get(i)));
}
int  A = 1;
int  B = 1;
int  C = 1;
int  D = 1;
int  bs = 1;
int anSSs=0; 

}




