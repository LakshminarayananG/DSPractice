package com.practice.binarySearch;

import java.util.Arrays;

import org.junit.Test;

public class SmallestLetterGreaterThanTarget {
	
	//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
	
	@Test
	public void eg1()
	{
		char[] ch= {'c','f','j'};
		char target='a';
		System.out.println("Example 1: Input array is: "+Arrays.toString(ch)+" and target character is: "+target);
		System.out.println("Greater character than target using linear scan is: "+greaterCharThanTargetLS(ch, target));
		System.out.println("Greater character than target using Binary Search is: "+returnGreaterCharUsingBS(ch, target));
		System.out.println();
	}
	
	@Test
	public void eg2()
	{
		char[] ch= {'c','f','j'};
		char target='c';
		System.out.println("Example 2: Input array is: "+Arrays.toString(ch)+" and target character is: "+target);
		System.out.println("Greater character than target using linear scan is: "+greaterCharThanTargetLS(ch, target));
		System.out.println("Greater character than target using Binary Search is: "+returnGreaterCharUsingBS(ch, target));
		System.out.println();
	}
	
	@Test
	public void eg3()
	{
		char[] ch= {'c','f','j'};
		char target='d';
		System.out.println("Example 3: Input array is: "+Arrays.toString(ch)+" and target character is: "+target);
		System.out.println("Greater character than target using linear scan is: "+greaterCharThanTargetLS(ch, target));
		System.out.println("Greater character than target using Binary Search is: "+returnGreaterCharUsingBS(ch, target));
		System.out.println();
	}
	
	@Test
	public void eg4()
	{
		char[] ch= {'a','b'};
		char target='z';
		System.out.println("Example 4: Input array is: "+Arrays.toString(ch)+" and target character is: "+target);
		System.out.println("Greater character than target using linear scan is: "+greaterCharThanTargetLS(ch, target));
		System.out.println("Greater character than target using Binary Search is: "+returnGreaterCharUsingBS(ch, target));
		System.out.println();
	}
	
	
	
	
	
	/**
	 * Approach using Linear Scan
	 * 
	 * 1. If the target > than the last element in array, return the first element (since this is the next greater element than
	 * 		target)
	 * 2. Iterate through the array
	 * 3. If the current index element is greater than the target, return the current index element
	 * 
	 * Time complexity => O[N]
	 * 
	 * 
	 */
	
	private char greaterCharThanTargetLS(char[] arr, char target) {
		if(target>arr[arr.length-1]) return arr[0];
		char output = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>target) {
				output=arr[i];
				break;
			}
		}
		
		return output;
		
		
	}
	
	/**
	 * Approach Using Binary Search
	 * 
	 * 1. Declare 2 variables, start=0,end=arr.len-1
	 * 2. If the target > than the last element in array, return the first element (since this is the next greater element than
	 * 		target)
	 * 3. Iterate until start<=end
	 * 4. For each iteration, find mid=start+(end-start)/2
	 * 5. if arr[mid]<=target, assign mid=start+1 (since the next greater element is in the right side
	 * 6. If arr[mid]>target, assign mid=end-1 (since the next greater element is in left side)
	 * 
	 * 
	 * Time Complexity => O[logN]
	 * 
	 * 
	 */
	
	
	private char returnGreaterCharUsingBS(char[] ch, char target) {
		if(target>ch[ch.length-1]) return ch[0];
		
		int start=0,end=ch.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			
		if(ch[mid]<=target) start=mid+1;
		else if(ch[mid]>target) end=mid-1;
		}
		
		return ch[start];
	}
}
