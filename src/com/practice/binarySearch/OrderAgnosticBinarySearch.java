package com.practice.binarySearch;

public class OrderAgnosticBinarySearch {
	
	
	/**
	 * 
	 * Binary search could be used for sorted arrays and these could be either sorted in ascending 
	 * or descending order. To have a common function for the same, we first identify if the array
	 * is ascending or descending and then have conditions for both depending on the boolean value
	 */
	
	public static void main(String[] args) {
		//int [] arr= {1,4,6,10,14,17,21,28,34};
		int[] arr= {34,28,21,17,14,10,7,5,3,-1};
		int target=7;
		boolean isAscending = arr[0]<arr[arr.length-1];
		int targetIndex=findTargetUsingBS(arr, target,isAscending);
		System.out.println(targetIndex);
	}
	
	
	public static int findTargetUsingBS(int[] arr, int target,boolean isAscending) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target==arr[mid]) return mid;
			
			if(isAscending) {
			if(arr[mid]<target) start=mid+1;
			else end=mid-1;
			}
			
			else {
				if(arr[mid]<target) end=mid-1;
				else start=mid+1;
			}
		}
		return -1;
	}

}
