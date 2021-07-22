package week1;

import org.junit.Test;

public class ClosestProductOfTwoNumbers {

	/**
	 * Given a Integer array and a target value, find the closest product of 2
	 * distinct numbers, that matches the target
	 * 
	 * 
	 */
	
	
	@Test
	public void eg1() {
		int[] nums= {1,2,3,4};
		int target=4;
	}
	
	@Test
	public void eg2() {
		int[] nums= {6,2,8,2,16,1};
		int target=14;
	}
	
	@Test
	public void eg3() {
		int[] nums= {6,3,2,1};
		int target=6;
	}
	
	@Test
	public void eg4() {
		int[] nums= {1,2,3,4};
		int target=6;
	}
	
	
	/**
	 * Approach: Using 2 Pointer
	 * 
	 * 1. Declare 3 variables, left=0, right=array len-1, prod =0
	 * 2. Iterate until left < right
	 * 3. Find product of left & right if both left & right values are distinct
	 * 4. If prod of left & right is closest to target, assign indices to output array
	 * 5. return output array
	 * 
	 *  Time Complexity: O[N/2]
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
}
