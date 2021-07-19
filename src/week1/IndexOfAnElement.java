package week1;

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
		System.out.println(indexOfElementUsingBinarySearch(nums, target));
		}
	
	
	@Test
	public void eg2() {
		int[] nums= {1,3,5,6};
		int target=7;
		System.out.println(indexOfElementUsingBinarySearch(nums, target));
	}
	
	@Test
	public void eg3() {
		int[] nums= {1,3,5,6};
		int target=0;
		System.out.println(indexOfElementUsingBinarySearch(nums, target));	
	}
	
	
	@Test
	public void eg4() {
		int[] nums= {1};
		int target=0;
		System.out.println(indexOfElementUsingBinarySearch(nums, target));
	}
	
	
	@Test
	public void eg5() {
		int[] nums= {5};
		int target=7;
		System.out.println(indexOfElementUsingBinarySearch(nums, target));
	}
	
	/**
	 * Pseudo Code
	 * 
	 * 1. Declare 3 variables low 0 & high- nums.length-1 & mid=0
	 * 2. Iterate until left<=right
	 * 3. Mid=(left+right)/2
	 * 4. If mid equals target, return mid
	 * 5. else if arr[mid-1] < target & arr[mid] > target, return mid
	 * 6. else if arr[mid]<target, assign left=mid+1
	 * 7. else assign right=mid-1
	 * 8. return 0
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
