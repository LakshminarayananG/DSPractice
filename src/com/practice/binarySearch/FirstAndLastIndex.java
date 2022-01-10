package com.practice.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FirstAndLastIndex {
	
	/**
	 * 
	 * Given an array of integers nums sorted in non-decreasing order, find the
	 * starting and ending position of a given target value.
	 * 
	 * If target is not found in the array, return [-1, -1].
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
	 * 
	 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] Example 3:
	 * 
	 * Input: nums = [], target = 0 Output: [-1,-1]
	 * 
	 * 
	 */
	
	
	@Test
	public void eg1() {
		int [] arr= {1,4,6,10,17,17,17,21,28,34};
		int target=17;
		int[] indices=getFirstAndLastIndex(arr, target);
		System.out.println("Output for Eg1 using list is: "+ Arrays.toString(indices));
		System.out.println("Output for Eg1 using Binary search is: "+ Arrays.toString(getIndexUsingBS(arr,target)));
	}
	
	@Test
	public void eg2() {
		int [] arr= {1,4,6,10,17,17,17,21,28,34};
		int target=1;
		int[] indices=getFirstAndLastIndex(arr, target);
		System.out.println("Output for Eg2 using list is: "+ Arrays.toString(indices));
		System.out.println("Output for Eg2 using Binary search is: "+ Arrays.toString(getIndexUsingBS(arr,target)));
	}
	
	@Test
	public void eg3() {
		int [] arr= {1,4,6,10,17,17,17,21,28,34};
		int target=4;
		int[] indices=getFirstAndLastIndex(arr, target);
		System.out.println("Output for Eg3 using list is: "+ Arrays.toString(indices));
		System.out.println("Output for Eg3 using Binary search is: "+ Arrays.toString(getIndexUsingBS(arr,target)));
	}
	
	@Test
	public void eg4() {
		int [] arr= {5,7,7,8,8,10};
		int target=8;
		int[] indices=getFirstAndLastIndex(arr, target);
		System.out.println("Output for Eg4 using list is: "+ Arrays.toString(indices));
		System.out.println("Output for Eg4 using Binary search is: "+ Arrays.toString(getIndexUsingBS(arr,target)));
	}
	
	@Test
	public void eg5() {
		int [] arr= {5,7,7,8,8,10};
		int target=6;
		int[] indices=getFirstAndLastIndex(arr, target);
		System.out.println("Output for Eg5 using list is: "+ Arrays.toString(indices));
		System.out.println("Output for Eg5 using Binary search is: "+ Arrays.toString(getIndexUsingBS(arr,target)));
	}
	
	@Test
	public void eg6() {
		int [] arr= {};
		int target=0;
		int[] indices=getFirstAndLastIndex(arr, target);
		System.out.println("Output for Eg6 using list is: "+ Arrays.toString(indices));
		System.out.println("Output for Eg6 using Binary search is: "+ Arrays.toString(getIndexUsingBS(arr,target)));
	}
	
	/*
	 * Approach Using List
	 * 1. Add elements of the array to a list
	 * 2. Using Inbuilt function, get the first & last index of the target
	 * 3. return the target indices
	 * 
	 * Time Complexity --> O[N]
	 * 
	 * 
	 */
	private int[] getFirstAndLastIndex(int[] arr,int target) {
		List<Integer> list = new ArrayList<>();
		for(int val:arr) {
			list.add(val);
		}
		
		return new int[] {list.indexOf(target), list.lastIndexOf(target)};
		
	}
	
	
	/*
	 * Alternate Approach using Binary Search
	 * 1. Declare boolean variable 
	 * 2. Using Binary search, iterate through the array
	 * 3. declare start=0,end=arr len-1
	 * 4. Iterate until start is less than or equal to end and for each iteration, find mid = (start+end)/2
	 * 5. If arr[mid] equals target and flag equals true, iterate further left => end=mid-1 to find first occurence
	 * 6. If arr[mid] equals target and flag equals false, iterate further right to find last index => start=mid+1
	 * 7. If arr[mid]>target, declare end=mid-1 and if arr[mid]<target, start=mid+1 to traverse right
	 * 
	 * Time Complexity => log[N]
	 * 
	 */
	private int[] getIndexUsingBS(int[] arr,int target) {
		int left=getFirstAndLastIndexUsingBS(arr, target, true);
		int right=getFirstAndLastIndexUsingBS(arr, target, false);
		return new int[] {left,right};
		
	}
	
	private int getFirstAndLastIndexUsingBS(int[] arr, int target, boolean flag) {
		int temp=-1,start=0,end=arr.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) 
			{ temp=mid;
				if(flag==true) end=mid-1;
				else start=mid+1;
			}
			
			else if(arr[mid]>target) end=mid-1;
			else start=mid+1;
			
		}
		
		return temp;
	}

}
