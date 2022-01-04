package com.practice.binarySearch;

public class BinarySearchExample {
	
	public static void main(String[] args) {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=21;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println(targetIndex);
		
	}
	
	public static int findTargetUsingBS(int[] arr, int target) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			
			if(arr[mid]<target) start=mid+1;
			else if(arr[mid]>target) end=mid-1;
			else return mid;
		}
		return -1;
	}

}
