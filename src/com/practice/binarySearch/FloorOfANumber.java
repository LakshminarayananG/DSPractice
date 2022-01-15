package com.practice.binarySearch;

import java.util.Arrays;

import org.junit.Test;

public class FloorOfANumber {

	
	/**
	 * 
	 * Given an sorted array in the increasing order, return the smallest greater element that is <= to the target element
	 * 
	 * Input => [2,3,5,6,7,10,11,14,17,22]
	 * Target => 15 
	 * 
	 * This should return 14
	 * 
	 * 
	 */
	
	@Test
	public void eg1() {
		int[] arr= {2,3,4,6,10,14};
		int target=12;
		System.out.println("Example 1: Input array is "+Arrays.toString(arr)+" and target value is "+target);
		System.out.println("Floor of the number using linear scan is: "+findFloorUsingLinearScan(arr, target));
		System.out.println("Floor of the number using Binary search is: "+findFloorUsingBS(arr, target));
		System.out.println();
	}
	
	@Test
	public void eg2() {
		int[] arr= {2,3,4,6,10,14,18};
		int target=6;
		System.out.println("Example 2: Input array is "+Arrays.toString(arr)+" and target value is "+target);
		System.out.println("Floor of the number using linear scan is: "+findFloorUsingLinearScan(arr, target));
		System.out.println("Floor of the number using Binary search is: "+findFloorUsingBS(arr, target));
		System.out.println();
	}
	
	@Test
	public void eg3() {
		int[] arr= {2,3,4,6,10,14};
		int target=2;
		System.out.println("Example 3: Input array is "+Arrays.toString(arr)+" and target value is "+target);
		System.out.println("Floor of the number using linear scan is: "+findFloorUsingLinearScan(arr, target));
		System.out.println("Floor of the number using Binary search is: "+findFloorUsingBS(arr, target));
		System.out.println();
	}
	
	@Test
	public void eg4() {
		int[] arr= {2,3,4,6,10,14};
		int target=9;
		System.out.println("Example 4: Input array is "+Arrays.toString(arr)+" and target value is "+target);
		System.out.println("Floor of the number using linear scan is: "+findFloorUsingLinearScan(arr, target));
		System.out.println("Floor of the number using Binary search is: "+findFloorUsingBS(arr, target));
		System.out.println();
	}
	
	@Test
	public void eg5() {
		int[] arr= {2,3,4,6,10,14,16,18,20};
		int target=15;
		System.out.println("Example 5: Input array is "+Arrays.toString(arr)+" and target value is "+target);
		System.out.println("Floor of the number using linear scan is: "+findFloorUsingLinearScan(arr, target));
		System.out.println("Floor of the number using Binary search is: "+findFloorUsingBS(arr, target));
		System.out.println();
	}
	
	
	
	/**
	 * Approach using Linear Scan
	 * 
	 * 1. Iterate through the array in reverse order
	 * 2. If the current element <=target, return the element
	 * 
	 * 
	 * Time Complexity => O[N]
	 * 
	 */
	
	
	private int findFloorUsingLinearScan(int[] arr, int target) {
		for(int i=arr.length-1;i>=0;i--) {
			if(arr[i]<= target) return arr[i];
		}
		
		return -1;
	}
	
	
	/**
	 * Approach using Binary Search
	 * 
	 * 1. Declare 2 variables start=0,end =arr.len-1
	 * 2. Iterate until start<=end
	 * 3. For each iteration, assign mid=(start+end)/2
	 * 4. If arr[mid] equals target, return mid element
	 * 5. If arr[mid] < target, output may lie in the right side, so start=mid+1
	 * 6. If arr[mid]> target, output could be in left side, so end=mid-1
	 * 7. If element is not found and loop breaks, (means start > end), return end since this could be the
	 *    next smaller element than target
	 *    
	 *    
	 *  Time Complexity => O[logN]
	 *
	 */
	
	
	private int findFloorUsingBS(int[] arr, int target) {
		int start=0,end=arr.length-1;
		
		while(start<=end) {
		int mid=start+(end-start)/2;
		
		if(arr[mid]==target) return arr[mid];
		if(arr[mid]<target) start=mid+1;
		else if(arr[mid]> target) end=mid-1;
		}
		
		return arr[end];
	}

}
