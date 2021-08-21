package com.practice.twoPointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P02_MoveAllZerosToRight {
	
	/* Move all zeros to right 
	 * int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };
	 */
	
	@Test
	public void testcase1() {
		int[] intarr= {1, 2, 0, 4, 3, 0, 5, 0};
		moveZerosToLast(intarr);
	}
	
	
	@Test
	public void testcase2() {
		int[] intarr= {0,5,1,0,0,4,4};
		moveZerosToLast(intarr);
	}
	
	@Test
	public void testcase3() {
		int[] intarr= {};
		moveZerosToLast(intarr);
	}
	
	@Test
	public void testcase4() {
		int[] intarr= {4};
		moveZerosToLast(intarr);
	}
	
	


	@Test
	public void testcase5() {
		int[] intarr= {2,8,0,0,0,0,6,7};
		moveZerosToLast(intarr);
	}
	
	
	/**
	 * Approach : 2 Pointer
	 * 
	 * 1. Declare 2 variables left=0 & right=arr.len-1
	 * 2. Iterate until left<right
	 * 3. If array[right]==0, decrement right since the element is already 0 in the right side
	 * 4. If array[left]==0, 
	 * 		Yes 
	 * 			--> Swap left & right variables
	 * 		No --> Increment left
	 * 5. Return the array
	 * 
	 * 
	 * @param intarr
	 */
	
	
	private int[] moveZerosToLast(int[] intarr) {
		if(intarr.length==0 || intarr.length==1) return intarr;
		
		int left=0,right=intarr.length-1;
		while(left<right) {
			if(intarr[right]==0) right--;
			else if(intarr[left]==0) {
				int temp=intarr[left];
				intarr[left++]=intarr[right];
				intarr[right--]=temp;
			}
			
			else left++;			
		}
		System.out.println(Arrays.toString(intarr));
		return intarr;
		
	}

}
