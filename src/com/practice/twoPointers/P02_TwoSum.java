package com.practice.twoPointers;

import org.junit.Assert;
import org.junit.Test;

public class P02_TwoSum {
	
	/**
	 * Given an array of integers nums in increasing and an integer target, return indices of the
	 * two numbers such that they add up to target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice.
	 * 
	 * You can return the answer in any order.
	 * 
	 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
	 * nums[1] == 9, we return [0, 1].
	 * 
	 * Input: nums = [3,2,4], target = 6 Output: [1,2]
	 * 
	 * Input: nums = [3,3], target = 6 Output: [0,1]
	 * 
	 * 
	 */
	
	@Test
	public void testcase1() {
		int[] input = { 2, 7, 11, 15 };
		int target = 9;
		Assert.assertArrayEquals(new int[] { 0, 1 }, findTargetSum(input, target));
		Assert.assertArrayEquals(new int[] { 0, 1 }, findTargetUsing2Pointer(input, target));
	}

	@Test
	public void testcase2() {
		int[] input = { 2, 7, 11, 15 };
		int target = 17;
		Assert.assertArrayEquals(new int[] { 0, 3 }, findTargetSum(input, target));
		Assert.assertArrayEquals(new int[] { 0, 3 }, findTargetUsing2Pointer(input, target));
	}

	@Test
	public void testcase3() {
		int[] input = { 2, 7, 11, 15 };
		int target = 6;
		Assert.assertArrayEquals(new int[] { -1, -1 }, findTargetSum(input, target));
		Assert.assertArrayEquals(new int[] { -1, -1 }, findTargetUsing2Pointer(input, target));
	}

	@Test
	public void testcase4() {
		int[] input = { 2,3, 4 };
		int target = 6;
		Assert.assertArrayEquals(new int[] { 0, 2 }, findTargetSum(input, target));
		Assert.assertArrayEquals(new int[] { 0, 2 }, findTargetUsing2Pointer(input, target));
	}

	@Test
	public void testcase5() {
		int[] input = { 2, 5, 5, 11 };
		int target = 10;
		Assert.assertArrayEquals(new int[] { 1, 2 }, findTargetSum(input, target));
		Assert.assertArrayEquals(new int[] { 1, 2 }, findTargetUsing2Pointer(input, target));
	}
	
	
	/**
	 * Approach: Brute Force
	 * 
	 * 1. Use 2 for loops, one outer for loop and 1 inner loop
	 * 2. For every outer loop starting from 0 to arr.len-1, iterate from next index using inner for loop till len-1
	 * 3. If any 2 indices have matching sum, return the indices
	 * 4. If none of the indices have matching sum, return {-1,-1}
	 * 
	 * Time Complexity: O[N^2]
	 * 
	 * 
	 * @param input
	 * @return
	 */
	
	private int[] findTargetSum(int[] input, int target) {
		for(int i=0;i<input.length;i++) {
			for(int j=i+1;j<input.length;j++) {
				if(input[i]+input[j]==target) return new int[] {i,j};
			}
		}
		return new int[] {-1,-1};
	}
	
	
	/**
	 * Approach : 2 Pointer
	 * 
	 * 1. Declare 2 pointers left=0, right=arr.len-1
	 * 2. Iterate until left<right
	 * 3. Since array is in increasing order, 
	 * 		arr[left]+arr[right] > target sum --> Decrement right
	 * 		arr[left]+arr[right] < target sum --> Increment left
	 * 		arr[left]+arr[right] = target sum --> return left & right indices
	 * 
	 * 4. If none of the indices match, return {-1,-1}
	 * 
	 * Time Complexity: O[N/2]
 	 * 
	 * 
	 * @param input
	 * @param sum
	 * @return
	 */
	
	private int[] findTargetUsing2Pointer(int[] input, int target) {
		int left=0, right=input.length-1;
		
		while(left<=right) {
			if(input[left]+input[right]==target) return new int[] {left,right};
			else if(input[left]+input[right]<target) left++;
			else right--;
		}
		
		return new int[] {-1,-1};
	}

}
