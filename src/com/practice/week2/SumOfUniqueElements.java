package com.practice.week2;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.*;

public class SumOfUniqueElements {
	
	/**
	 * https://leetcode.com/problems/sum-of-unique-elements/
	 * 
	 * You are given an integer array nums. The unique elements of an array are the
	 * elements that appear exactly once in the array.
	 * 
	 * Return the sum of all the unique elements of nums.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,2,3,2] Output: 4 Explanation: The unique elements are [1,3],
	 * and the sum is 4. Example 2:
	 * 
	 * Input: nums = [1,1,1,1,1] Output: 0 Explanation: There are no unique
	 * elements, and the sum is 0. Example 3:
	 * 
	 * Input: nums = [1,2,3,4,5] Output: 15 Explanation: The unique elements are
	 * [1,2,3,4,5], and the sum is 15.
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 100 
	 * 1 <= nums[i] <= 100
	 * 
	 */
	
	
	@Test
	public void eg1() {
		int[] nums= {1,2,3,2};
		Assert.assertEquals(4, findUniqueSum(nums));
		Assert.assertEquals(4, findSumOfUnique(nums));
	}

	
	@Test
	public void eg2() {
		int[] nums= {1,1,1,1,1};
		Assert.assertEquals(0, findUniqueSum(nums));
		Assert.assertEquals(0, findSumOfUnique(nums));
	}

	
	@Test
	public void eg3() {
		int[] nums= {1,2,3,4,5};
		Assert.assertEquals(15, findUniqueSum(nums));
		Assert.assertEquals(15, findSumOfUnique(nums));
	}

	
	/**
	 * Approach:
	 * 1. Declare an array of size 101 since 
	 * 2. Declare sum as 0
	 * 3. Iterate from 0 to len-1 of input array
	 * 4. Add the number of occurence against the nums array
	 * 5. Iterate through the declared array and if value equals 1, add it to sum
	 * 6. return sum
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	
	private int findUniqueSum(int[] nums) {
		int sum=0;
		int[] arr = new int[101];
		
		for(int i=0;i<nums.length;i++) {
			arr[nums[i]]++;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) sum+=i;
		}
		
		return sum;
		
	}
	
	
	/**
	 * Approach using Map
	 * 
	 * 1. Declare a hashmap
	 * 2. Iterate through the array and add the interger and the number of occurence
	 * 3. Iterate through the map and if the value equals 1, add the keys to sum
	 * 4. return the sum
	 * 
	 * 
	 */
	
	
	private int findSumOfUnique(int[] nums) {
		int sum=0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) sum+=entry.getKey();
		}
		
		return sum;
		
	}

}
