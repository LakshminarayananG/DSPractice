package com.practice.binarySearch;

import org.junit.Test;

public class TargetPositionInfiniteSortedArray {
	
	/**
	 * 
	 * Given an infinite sorted array, find the position of the target without using the arr.len to find size of array
	 * 
	 */
	
	@Test
	public void eg1() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=21;
		int targetIndex=findTargetPosition(arr, target);
		System.out.println("Output for Eg1 is: "+ targetIndex);
	}

	@Test
	public void eg2() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=5;
		int targetIndex=findTargetPosition(arr, target);
		System.out.println("Output for Eg2 is: "+ targetIndex);
	}
	
	@Test
	public void eg3() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=1;
		int targetIndex=findTargetPosition(arr, target);
		System.out.println("Output for Eg3 is: "+ targetIndex);
	}
	
	@Test
	public void eg4() {
		int [] arr= {1,4,6,10,14,17,21,28,34,41,43,45,56};
		int target=34;
		int targetIndex=findTargetPosition(arr, target);
		System.out.println("Output for Eg4 is: "+ targetIndex);
	}
	
	
	
	/*
	 * Approach using Binary Search
	 * 
	 * 1. Since we can't use the arr.len to determine end value, assign start=0,end=1
	 * 2. Iterate in small blocks of the array and check if the target value is greater than arr[end]
	 * 3. If target value > arr[end]
	 * 		Yes -> This means that value is to the right of end element
	 * 				* Assign start as end 
	 * 				* end = end*2 (doubling the size or the block within which target element is identified)
	 * 		No -> Target element is within start & end. Apply Binary search for this block of array and find the target element position
	 */
	
	
	
	private int findTargetPosition(int [] arr, int target) {
		int start=0,end=1;
		
		while(target>arr[end]) {
			start=end;
			end*=2;
		}
		
		return targetUsingBS(arr, target, start, end);
		
	}
	
	private int targetUsingBS(int [] arr, int target, int start, int end) {
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target>arr[mid]) start=mid+1;
			else if(target<arr[mid]) end=mid-1;
			else return mid;
		}
		
		return -1;
	}

}
