package com.practice.week1;

import org.junit.Assert;
import org.junit.Test;

public class IndexOfAnElement {
	
	/**
	 * Given a sorted array of distinct integers and a target value, return the
	 * index if the target is found. If not, return the index where it would be if
	 * it were inserted in order. You must write an algorithm with O(log n) runtime
	 * complexity.
	 * 
	 * Example 1: Input: nums = [1,3,5,6], target = 5 Output: 2 Example 2: Input:
	 * nums = [1,3,5,6], target = 2 Output: 1 Example 3: Input: nums = [1,3,5,6],
	 * target = 7 Output: 4 Example 4: Input: nums = [1,3,5,6], target = 0 Output: 0
	 */
	
	@Test
	public void eg1() {
		int[] nums= {1,3,5,6};
		int target=5;
		Assert.assertEquals(2, indexOfElementUsingBinarySearch(nums, target));
		Assert.assertEquals(2, indexofElementUsingLinearApproach(nums, target));
		}
	
	
	@Test
	public void eg2() {
		int[] nums= {1,3,5,6};
		int target=7;
		Assert.assertEquals(4, indexOfElementUsingBinarySearch(nums, target));
		Assert.assertEquals(4, indexofElementUsingLinearApproach(nums, target));
	}
	
	@Test
	public void eg3() {
		int[] nums= {1,3,5,6};
		int target=0;
		Assert.assertEquals(0, indexOfElementUsingBinarySearch(nums, target));
		Assert.assertEquals(0, indexofElementUsingLinearApproach(nums, target));
	}
	
	
	@Test
	public void eg4() {
		int[] nums= {1};
		int target=0;
		Assert.assertEquals(0, indexOfElementUsingBinarySearch(nums, target));
		Assert.assertEquals(0, indexofElementUsingLinearApproach(nums, target));
	}
	
	
	@Test
	public void eg5() {
		int[] nums= {5};
		int target=7;
		Assert.assertEquals(1, indexOfElementUsingBinarySearch(nums, target));
		Assert.assertEquals(1, indexofElementUsingLinearApproach(nums, target));
	}
	
	@Test
	public void eg6() {
		int[] nums= {1,3,5,6};
		int target=6;
		Assert.assertEquals(3, indexOfElementUsingBinarySearch(nums, target));
		Assert.assertEquals(3, indexofElementUsingLinearApproach(nums, target));
	}
	
	
	/**
	 * Approach: Linear Scan
	 * 
	 * 1. Check if target > array length
	 * 		Yes --> return array length+1
	 * 2. Check if target < array[0]
	 * 		Yes --> return 0
	 * 3. Iterate through the array
	 * 4. Check if array[i] equals target
	 * 		Yes --> return index
	 * 5. Check if array[i] < target and array[i+1] > target
	 * 		Yes --> return iterator +1
	 * 
	 * Time Complexity: O[N]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	
	private int indexofElementUsingLinearApproach(int[] nums, int target) {
		if(target>nums[nums.length-1]) return nums.length;
		if(target<nums[0]) return 0;
		if(target==nums[nums.length-1]) return nums.length-1;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==target) return i;
			else if (nums[i] < target && nums[i+1] > target) return i+1;
		}
		
		return 0;
	}
	
	
	
	/**
	 * * Approach: Using Binary Search
	 * 
	 * 1. Declare 3 variables low 0 & high- nums.length-1 & mid=0
	 * 2. Iterate until left<=right
	 * 3. Mid=(left+right)/2
	 * 4. If mid equals target, return mid
	 * 5. else if arr[mid-1] < target & arr[mid] > target, return mid
	 * 6. else if arr[mid]<target, assign left=mid+1
	 * 7. else assign right=mid-1
	 * 8. return 0
	 * 
	 * Time Complexity: O[logN]
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	
	
	private int indexOfElementUsingBinarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		int mid = 0;
		if (nums.length == 0 || nums[0] >= target) {
			return 0;
		}
		if (nums[nums.length - 1] < target) {
			return nums.length;
		}
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (mid > 0 && nums[mid - 1] < target && nums[mid] > target) {
				return mid;
			}

			else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}

}
