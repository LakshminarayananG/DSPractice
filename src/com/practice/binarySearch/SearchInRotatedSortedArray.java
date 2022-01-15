package com.practice.binarySearch;

import org.junit.Test;

public class SearchInRotatedSortedArray {
	
	
	/*
	 * https://leetcode.com/problems/search-in-rotated-sorted-array/
	 */
	
	@Test
	public void eg1() {
		int[] arr= {4,5,6,7,0,1,2};
		int target=0;
		System.out.println("Example 1:");
		System.out.println("Index of target element: "+target+" using linear search is "+linearSearchInRotatedArray(arr, target));
		System.out.println("Index of target element: "+target+" using two pointer is "+searchUsing2Ptr(arr, target));
		System.out.println("Index of target element: "+target+" using Binary Search is "+searchUsingBS(arr, target));
		
		
	}
	
	@Test
	public void eg2() {
		int[] arr= {4,5,6,7,0,1,2};
		int target=3;
		System.out.println("Example 2:");
		System.out.println("Index of target element: "+target+" using linear search is "+linearSearchInRotatedArray(arr, target));
		System.out.println("Index of target element: "+target+" using two pointer is "+searchUsing2Ptr(arr, target));
		System.out.println("Index of target element: "+target+" using Binary Search is "+searchUsingBS(arr, target));
	}
	
	@Test
	public void eg3() {
		int[] arr= {1};
		int target=0;
		System.out.println("Example 3:");
		System.out.println("Index of target element: "+target+" using linear search is "+linearSearchInRotatedArray(arr, target));
		System.out.println("Index of target element: "+target+" using two pointer is "+searchUsing2Ptr(arr, target));
		System.out.println("Index of target element: "+target+" using Binary Search is "+searchUsingBS(arr, target));
	}
	
	@Test
	public void eg4() {
		int[] arr= {1,3};
		int target=3;
		System.out.println("Example 4:");
		System.out.println("Index of target element: "+target+" using linear search is "+linearSearchInRotatedArray(arr, target));
		System.out.println("Index of target element: "+target+" using two pointer is "+searchUsing2Ptr(arr, target));
		System.out.println("Index of target element: "+target+" using Binary Search is "+searchUsingBS(arr, target));
	}
	
	
	
	/**
	 * 
	 * Approach using Linear Scan
	 * 
	 * 1. Iterate through the array
	 * 2. Check for each  element, if the element equals target, return current index
	 * 3. return -1 if target is not found in any case
	 * 
	 * Time Complexity => O[N]
	 */
	private int linearSearchInRotatedArray(int[] arr, int target) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == target) return i;
		}
		
		return -1;
	}
	
	
	
	/**
	 * 
	 * Approach using 2 pointer
	 * 
	 * 1. Declare 2 pointers start=0,end=array len-1
	 * 2. Iterate until start is less than or equal to end
	 * 3. If either of element at start or end index equals target, return the index
	 * 4. Return -1 in case target element is not found
	 * 
	 * Time complexity => O[N/2]
	 * 
	 */
	private int searchUsing2Ptr(int [] arr, int target) {
		int start=0,end=arr.length-1;
		
		while(start<=end) {
			if(arr[start]==target) {
				return start;
			}
			else if(arr[end]==target) {
				return end;
			}
			start++;
			end--;
		}
		
		return -1;
	}
	
	
	
	//4,5,6,7,0,1,2
	
	private int searchUsingBS(int[] arr, int target) {
		if(arr.length==0) return -1;
		
		int start=0,end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) return mid;
			
			if(arr[mid]>=arr[start]) {
				if(arr[mid]>target && target>=arr[start]) end=mid-1; 
				else start=mid+1;
			}
			
			else {
				if(arr[mid]<target && target<arr[end]) start=mid+1;
				else end=mid-1;
				
			}
		}
		
        return -1;    
	}
	
	
	
	
	
	
	

}
