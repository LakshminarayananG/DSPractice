package com.practice.week1;

import java.util.HashMap;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;

public class FindOddOneOut {
	
	/*
	 * Given a non-empty array of integers nums, every element appears twice except
	 * for one. Find that single one using Binary search.
	 * 
	 * Example 1:	 * 
	 * Input: nums = [3,3,7,7,11] Output: 11 
	 * 
	 * Example 2: 
	 * Input: nums = [3,3,7,7,10,11,11] Output: 10
	 */
	
	
	@Test
	 public void eg1()
	 {
	  int[] input= {2,2,3,3,7,7,11};
	  Assert.assertEquals(11, findOddOneOutUsingMap(input));
	  Assert.assertEquals(11, findOddOneOutUsingBinarySearch(input));
	 }
		
	 @Test
	 public void eg2()
	 {
	  int[] input= {2,2,3,7,7};
	  Assert.assertEquals(3, findOddOneOutUsingMap(input));
	  Assert.assertEquals(3, findOddOneOutUsingBinarySearch(input));
	 }
		
	 @Test
	 public void eg3()
	 {
	  int[] input= {2,3,3,7,7,11,11};
	  Assert.assertEquals(2, findOddOneOutUsingMap(input));
	  Assert.assertEquals(2, findOddOneOutUsingBinarySearch(input));
	 }
		
	 @Test
	 public void eg4()
	 {
	  int[] input= {2,2,3,7,7,11,11};
	  Assert.assertEquals(3, findOddOneOutUsingMap(input));
	  Assert.assertEquals(3, findOddOneOutUsingBinarySearch(input));
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void eg5()
	 {
	  int[] input= {2,2,3,3,7,7,11,11};
	  Assert.assertEquals(0, findOddOneOutUsingMap(input));
	  Assert.assertEquals(0, findOddOneOutUsingBinarySearch(input));
	 }
	 
	 
	 
	 /**
	  * Approach: Linear Scan
	  *
	  * 1. Iterate from 0 to len-1 of array and add all elements to map as key & occurence as value
	  * 2. Iterate through the map
	  * 3. If remainder of value of map divided by 2 not equals 0
	  * 	Yes --> Return the key of the map
	  * 4. Throw an exception if no element is occuring once in the input
	  *
	  * 
	  * Time Complexity: O[N]
	  * 
	  * @param input
	  * @return
	  */
	 
	 private int findOddOneOutUsingMap(int[] input) {
		 HashMap<Integer,Integer> map = new HashMap<>();
		 for(int val: input) {
			 map.put(val, map.getOrDefault(val, 0)+1);
		 }
		 
		 for (Entry<Integer, Integer> mapentry : map.entrySet()) {
			if((mapentry.getValue())%2!=0) return mapentry.getKey();
		}
		 
		throw new RuntimeException("No unique elements found");
		 
	 }
	 
	 
	 
	 
	 
	 /**
	  * Approach: Binary Search
	  * 
	  * 1. Declare 3 variables left=0,right=arr.len-1 and mid
	  * 2. Iterate until left<=right
	  * 3. For each iteration, calculate mid=(left+right)/2
	  * 4. Check for neighbouring elements to the mid to see if there are unique elements
	  * 5. Check if remainder of right-mid is not equal to 0
	  * 		Yes --> Assign left=mid+1
	  * 6. Check if remainder of mid-left is not equal to 0
	  * 		Yes --> Assign right=mid-1
	  * 7. Return the unique element
	  * 
	  * 
	  * 
	  * Time Complexity: O[logN]
	  * 
	  * @param array
	  * @return
	  */
		
		private int findOddOneOutUsingBinarySearch(int[] array) {
			int low = 0;
			int high = array.length - 1;
			int mid = 0;
			while (low <= high) {
				mid = (low + high) / 2;
				if ((mid == array.length - 1 || array[mid] != array[mid + 1])
						&& (mid == 0 || array[mid] != array[mid - 1]))
					return array[mid];
				else if ((array[mid] == array[mid - 1]) && ((high - mid) % 2 != 0))
					low = mid + 1;
				else if ((array[mid] == array[mid + 1]) && ((mid - low) % 2 != 0)) {
					high = mid - 1;
				}

			}
			throw new RuntimeException("No match");
		}

}

