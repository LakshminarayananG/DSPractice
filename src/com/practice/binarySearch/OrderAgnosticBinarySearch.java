package com.practice.binarySearch;

import org.junit.Test;

public class OrderAgnosticBinarySearch {
	
	
	/**
	 * 
	 * Binary search could be used for sorted arrays and these could be either sorted in ascending 
	 * or descending order. To have a common function for the same, we first identify if the array
	 * is ascending or descending and then have conditions for both depending on the boolean value
	 */
	
	@Test
	public void eg1() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=21;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg1 is: "+ targetIndex);
	}

	@Test
	public void eg2() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=2;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg2 is: "+ targetIndex);
	}
	
	@Test
	public void eg3() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=1;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg3 is: "+ targetIndex);
	}
	
	@Test
	public void eg4() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=34;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg4 is: "+ targetIndex);
	}
	
	@Test
	public void eg5() {
		int [] arr= {34,23,19,17,14,11,8,3,-2,-4};
		int target=14;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg5 is: "+ targetIndex);
	}
	
	@Test
	public void eg6() {
		int [] arr= {34,23,19,17,14,11,8,3,-2,-4};
		int target=-4;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg6 is: "+ targetIndex);
	}
	
	@Test
	public void eg7() {
		int [] arr= {34,23,19,17,14,11,8,3,-2,-4};
		int target=34;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg7 is: "+ targetIndex);
	}
	
	@Test
	public void eg8() {
		int [] arr= {34,23,19,17,14,11,8,3,-2,-4};
		int target=14;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg8 is: "+ targetIndex);
	}
	
	@Test
	public void eg9() {
		int [] arr= {1,1,1,1,1,1,1,1,1};
		int target=1;
		int targetIndex=findTargetUsingBS(arr, target,arr[0]<arr[arr.length-1]);
		System.out.println("Output for Eg9 is: "+ targetIndex);
	}
	
	public static int findTargetUsingBS(int[] arr, int target,boolean isAscending) {
		int start=0,end=arr.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) return mid;
			if(isAscending) {
				if(arr[mid]>target) end=mid-1;
				else start=mid+1;
			}
			
			else if(!isAscending){
				if(arr[mid]>target) start=mid+1;
				else end=mid-1;
			}
		}
		
		return -1;
	}

}
