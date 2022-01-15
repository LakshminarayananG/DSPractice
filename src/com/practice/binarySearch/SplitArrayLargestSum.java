package com.practice.binarySearch;

import org.junit.Test;

public class SplitArrayLargestSum {
	
	
	@Test
	public void eg1() {
		int[] arr= {7,2,5,10,8};
		int m=2;
		System.out.println("Output value is: "+splitArray(arr, m));
	}
	
	

	public int splitArray(int[] nums, int m) {

		int start = 0, end = 0, mid = 0;

		for (int val : nums) {
			start = Math.max(start, val);
			end += val;
		}

		while (start < end) {
			mid = start + (end - start) / 2;
			if (canForm(nums, mid, m)) {
				end = mid;
			} else
				start = mid+1;

		}

		return start;

	}

	private boolean canForm(int[] nums, int mid, int m) {

		int total = 0, count = 1;
		for (int val : nums) {
			total += val;
			if (total > mid) {
				total = val;
				count++;

			}

			if (count > m)
				return false;

		}

		return true;
	}

}
