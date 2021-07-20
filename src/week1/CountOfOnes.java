package week1;

import org.junit.Assert;
import org.junit.Test;

public class CountOfOnes {
	
	/**
	 * Given an sorted array of 0's & 1's, count the number of 1's
	 * 
	 * Constraint: Try solving it in less than O[N]
	 */
	
	
	@Test
	public void eg1() {
		int[] nums= {0,0,0,1,1,1};
		Assert.assertEquals(3, findOnesUsingLinearScan(nums));
		Assert.assertEquals(3, countOnesUsingBinarySearch(nums,0,nums.length-1));
		Assert.assertEquals(3, findOnesCountUsingTwoPointer(nums));
		}
	
	@Test
	public void eg2() {
		int[] nums= {0,0,0};
		Assert.assertEquals(0, findOnesUsingLinearScan(nums));
		Assert.assertEquals(0, countOnesUsingBinarySearch(nums,0,nums.length-1));
		Assert.assertEquals(0, findOnesCountUsingTwoPointer(nums));
		}
	
	@Test
	public void eg3() {
		int[] nums= {1,1,1};
		Assert.assertEquals(3, findOnesUsingLinearScan(nums));
		Assert.assertEquals(3, countOnesUsingBinarySearch(nums,0,nums.length-1));
		Assert.assertEquals(3, findOnesCountUsingTwoPointer(nums));
		}
	
	
	@Test
	public void eg4() {
		int[] nums= {0,1,1,1};
		Assert.assertEquals(3, findOnesUsingLinearScan(nums));
		Assert.assertEquals(3, countOnesUsingBinarySearch(nums,0,nums.length-1));
		Assert.assertEquals(3, findOnesCountUsingTwoPointer(nums));
		}
	
	
	/**
	 * 1. Check if arr[0] equals 1
	 * 		Yes --> return arr.length since all elements would be 1 to the right of it
	 * 2. Check if arr[arr.len-1] equals 0
	 * 		Yes --> return 0 since all elements to the left of it would be 0
	 * 3. Iterate from left to the right of array
	 * 		If arr[incrementer] equals 1
	 * 			Yes --> return arr.len-i
	 * 			No	--> Continue Iteration
	 * 
	 * Time Complexity: O[N]
	 * 
	 * @param nums
	 * @return
	 */
	private int findOnesUsingLinearScan(int[] nums) {
		if (nums[0] == 1)
			return nums.length;
		else if (nums[nums.length-1] == 0)
			return 0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==1) return nums.length-i;
		}
		
		return 0;
	}
	
	/**
	 * Approach: Using Binary Search
	 * 
	 * 1. 3 variables passed as parameters, array, left =0 and right =arr.len-1 as initial parameters
	 * 2. Check if arr[left] equals 1
	 * 		Yes --> return right-left+1 since all elements would be 1 to the right of it
	 * 3. Check if arr[right] equals 0
	 * 		Yes --> return 0 since all elements to the left of it would be 0
	 * 
	 * 4. Iterate recursively passing the array, left, mid and array, mid+1 & right
	 * 
	 * 
	 * Time Complexity: O[logN]
	 * 
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	
	private int countOnesUsingBinarySearch(int[] nums,int left, int right) {
		if(nums[left]==1) return right-left+1;
		else if(nums[right]==0) return 0;
		
		int mid=(left+right)/2;
		return countOnesUsingBinarySearch(nums, left, mid) + countOnesUsingBinarySearch(nums, mid+1, right);
	}
	
	
	/**
	 * Approach: Using 2 Ptr
	 * 
	 * 1. Declare 2 variables, left=0 & right=nums.length-1
	 * 2. Iterate until left<right
	 * 		If nums[left]==1 --> return nums.length-left;
	 * 		If nums[right]==0 --> return nums.length-right
	 *    Increment left & right for each iteration
	 * 
	 * Finally return nums.length-left
	 * 
	 * Time Complexity: O[N/2]
	 * 
	 * 
	 * @param nums
	 * @return
	 */
	
	private int findOnesCountUsingTwoPointer(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		if (nums[left] == 1)
			return right - left + 1;
		else if (nums[right] == 0)
			return 0;

		while (left < right) {
			if (nums[left] == 1)
				return nums.length - left;

			if (nums[right] == 0)
				return nums.length - right - 1;

			left++;
			right--;

		}
		return nums.length - left;
	}
	
	

}
