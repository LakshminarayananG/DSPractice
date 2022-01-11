package com.practice.binarySearch;

import org.junit.Test;

public class PeakIndex {
	
	//https://leetcode.com/problems/peak-index-in-a-mountain-array/
	
	
	@Test
	public void eg1() {
		int[] arr= {0,1,0};
		int index=findPeakIndex(arr);
		System.out.println("Index for Eg1 is: "+index);
	}
	
	@Test
	public void eg2() {
		int[] arr= {0,2,1,0};
		int index=findPeakIndex(arr);
		System.out.println("Index for Eg2 is: "+index);
	}
	
	@Test
	public void eg3() {
		int[] arr= {0,10,5,2};
		int index=findPeakIndex(arr);
		System.out.println("Index for Eg3 is: "+index);
	}
	
	@Test
	public void eg4() {
		int[] arr= {3,4,5,1};
		int index=findPeakIndex(arr);
		System.out.println("Index for Eg4 is: "+index);
	}
	
	
	
	/**
	 * Using Linear Search
	 * 
	 * 1. Iterate through the array from 1 to arr.len-1
	 * 2. Check if current element > next element & current element > previous element
	 *    Yes --> return current index
	 * 3. return -1 if no peak element is present
	 */
	public int findPeakIndexUsingLinearSearch(int [] arr) {
		for(int i=1;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1] && arr[i]>arr[i-1]) return i;
		}
		
		return -1;
	}
	
	
	//[1,2,3,5,6,4,3,2]
	/**
	 * Approach using Binary search
	 * 
	 * 
	 * Based on above example
	 * Index Positions
	 * start=0, end=7, mid=3
	 * 
	 * Values
	 * start=1, end=2, mid=5
	 * 
	 * since mid<mid+1 => This is in ascending part and hence new start=mid+1
	 * Index Positions
	 * start=4, end=7, mid=5
	 * 
	 * Values
	 * start=6,end=2, mid=4
	 * 
	 * since arr[mid]>arr[mid+1] => This is in descending part and hence the peak element could be in left side
	 * new end=mid
	 * 
	 * Index Positions
	 * start=4, end=5 mid=4
	 * 
	 * Values
	 * start=6,end=4,mid=6
	 * arr[mid]>arr[mid+1] => This is in descending part & hence the peak element could be in left side
	 * new end=mid
	 * 
	 * Index positions
	 * start=4,end=4 => Condition breaks here and hence can return either start or end
	 * 
	 **/
	
	private int findPeakIndex(int[] arr) {
		int start=0,end=arr.length-1;
		
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>arr[mid+1]) end=mid;
			else start=mid+1;
		}
		return start;
	}

}
