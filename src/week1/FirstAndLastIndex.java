package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class FirstAndLastIndex {
	
	/**
	 * Given an array of integers nums sorted in ascending order, find the starting
	 * and ending position of a given target value. If target is not found in the
	 * array, return [-1, -1]. You must write an algorithm with O(log n) runtime
	 * complexity.
	 * 
	 * Example 1: Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
	 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1] Example 3: Input:
	 * nums = [], target = 0 Output: [-1,-1]
	 */
	
	@Test
	public void eg1()
	{
		int [] nums= {5,7,7,8,8,10};
		int target=8;
		System.out.println(Arrays.toString(findTargetIndicesUsing2Ptr(nums, target)));
		System.out.println(Arrays.toString(findTargetUsingList(nums, target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(nums, target)));
	}
	
	@Test
	public void eg2()
	{
		int [] nums= {5,7,7,8,8,10};
		int target=6;
		System.out.println("2nd Example");
		System.out.println(Arrays.toString(findTargetIndicesUsing2Ptr(nums, target)));
		System.out.println(Arrays.toString(findTargetUsingList(nums, target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(nums, target)));
	}
	
	@Test
	public void eg3()
	{
		int [] nums= {7,7,7,7,7,7};
		int target=7;
		System.out.println("3rd Example");
		System.out.println(Arrays.toString(findTargetIndicesUsing2Ptr(nums, target)));
		System.out.println(Arrays.toString(findTargetUsingList(nums, target)));
		System.out.println(Arrays.toString(getFirstLastIndexUsingBinary(nums, target)));
	}
	
	@Test
	public void eg4()
	{
		int [] nums= {8,8,8,8,8,7};
		int target=7;
		System.out.println(Arrays.toString(findTargetIndicesUsing2Ptr(nums, target)));
	}
	
	/**
	 * Approach: Using 2 Pointer
	 * 1. Declare 2 variables left & right
	 * 2. Iterate until left<=right
	 * 3. If both left & right index matches target value, return indices
	 * 4. Increment left if index value not equals target
	 * 5. Decrement right if index value not equals target
	 * 
	 * Time Complexity: 
	 * Best Case: O[N/2]
	 * Worst Case: O[N]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	
	private int[] findTargetIndicesUsing2Ptr(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			if (nums[left] == target && nums[right] == target) {
				return (new int[] { left, right });
			}

			if (nums[left] != target) {
				left++;
			} else if (nums[right] != target) {
				right--;
			}
		}
		return new int[] { -1, -1 };
	}
	
	
	/**
	 * Approach: Using Inbuilt list Function
	 * 
	 * 1. Add the elements of the array into a list
	 * 2. Return the indices using the inbuilt function list.indexOf(target)
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	
	private int[] findTargetUsingList(int []nums,int target) {
		List<Integer> output=new ArrayList<>();
		
		for (Integer eachInt : nums) {
			output.add(eachInt);
		}
		
		return new int[] {output.indexOf(target), output.indexOf(target)};
	}
	
	
	
	/**
	 * Approach : Using Binary Search
	 * 1. Declare 3 variables, left=0, right=arr.length-1, temp =-1
	 * 2. Iterate until left < = right
	 * 3. Find mid value =(left+right)/2
	 * 4. If arr[mid] equals target, assign 
	 * temp=mid and flag equals true, assign right=mid-1 to travese even left
	 * 5. If arr[mid] equals target, assign 
	 * temp=mid and flag equals false, assign left=mid+1 to travese even right
	 * 6. If arr[mid] < target, left=mid+1
	 * 7. If arr[mid] > target, right=mid-1;
	 * 8. return temp
	 * 
	 * 
	 * @param input
	 * @param target
	 * @return
	 */
	
	
	public int[] getFirstLastIndexUsingBinary(int[] nums,int target) {
		
		int left=getLastOrFirstIndex(nums,target,true);
		int right=getLastOrFirstIndex(nums,target,false);
		return new int[] {left,right};
	}
	
	private int getLastOrFirstIndex(int[] nums, int target,boolean flag) {
		
		int left=0;int right=nums.length-1;
		int temp=-1;
		
		
		while(left <= right) {
			int mid=(left+right)/2;
			if(nums[mid] == target) {
				temp=mid;
				if(flag ==true)
					right=mid-1;
				else {
					left=mid+1;
				}
			}else if(nums[mid] > target) {
				right=mid-1;
			}else left=mid+1;
			
		}
		return temp;
	}

}
