package com.practice.week1;

import org.junit.Assert;
import org.junit.Test;

public class SecondMaxElementInArray {

	
	/*
	 * Given an Integer array, find the second minimum value
	 * 
	 * Input:
	 * Array ={2, 4, 1, 3, 7, 11, -1}
	 * Output: 7
	 * 
	 */
	
	@Test
	public void example1() {
		int[] nums = { 2, 4, 1, 3, 7, 11, -1 };
		Assert.assertEquals(7, findSecondMax(nums));
		}

	@Test
	public void example2() {
		int[] nums = { 2, 4, 1, 3, -1, 11, -1 };
		Assert.assertEquals(4, findSecondMax(nums));
		}

	@Test
	public void example3() {
		int[] nums = { 6, 4, 2, 8, -5, 6, 1 };
		Assert.assertEquals(6, findSecondMax(nums));
		}

	@Test(expected = RuntimeException.class)
	public void example4() {
		int[] nums = { 1, 1, 1, 1, 1 };
		Assert.assertEquals(0, findSecondMax(nums));
		}
	
	
	
	/**
	 * Approach: Linear Scan
	 * 
	 * 1. Declare 2 variables, first and second max
	 * 2. Iterate from array index 0 to len-1
	 * 3. For each Iteration, check if index value is > first max
	 * 		Yes --> Assign second value to first max
	 * 				Assign first max to index value
	 * 4. If index value < first max and > second max
	 * 		Yes --> Assign index value to second max
	 * 
	 * 5. Return second max
	 * 
	 * 
	 * Time Complexity: O[N]
	 * 
	 * @param nums
	 * @return
	 */
	
		private int findSecondMax(int[] nums) {
			int firstmax = Integer.MIN_VALUE, secmax = Integer.MIN_VALUE;

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > firstmax) {
					secmax = firstmax;
					firstmax = nums[i];
				} else if (nums[i] > secmax && nums[i] < firstmax)
					secmax = nums[i];
			}

			if (secmax == Integer.MIN_VALUE)
				throw new RuntimeException("No second max found");

			return secmax;
		}
	
}
