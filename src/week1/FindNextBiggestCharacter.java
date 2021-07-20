package week1;

import org.junit.Test;
import org.junit.Assert;

public class FindNextBiggestCharacter {
	
	/**
	 * Given a sorted character array and a target character, find the next biggest
	 * character in the array. char[] cha = {‘b’, ‘d’ , ‘h’}; char k = ‘e’ 
	 * Output -> h
	 */
	
	@Test
	public void eg1() {
		char [] charr= {'b','d','h'};
		char ch='d';
		Assert.assertEquals('h', findNextBiggestUsingLinearApproach(charr, ch));
		Assert.assertEquals('h', findNextBiggestCharUsingBinarySearch(charr, ch));
	}
	
	@Test
	public void eg2() {
		char [] charr= {'b'};
		char ch='e';
		Assert.assertEquals(' ', findNextBiggestUsingLinearApproach(charr, ch));
		Assert.assertEquals(' ', findNextBiggestCharUsingBinarySearch(charr, ch));
	}
	
	@Test
	public void eg3() {
		char [] charr= {'b','d','h'};
		char ch='b';
		Assert.assertEquals('d', findNextBiggestUsingLinearApproach(charr, ch));
		Assert.assertEquals('d', findNextBiggestCharUsingBinarySearch(charr, ch));
		}
	
	@Test
	public void eg4() {
		char [] charr= {'b','d','h'};
		char ch='e';
		Assert.assertEquals('h', findNextBiggestUsingLinearApproach(charr, ch));
		Assert.assertEquals('h', findNextBiggestCharUsingBinarySearch(charr, ch));
		}
	
	@Test
	public void eg5() {
		char [] charr= {'b','d','h'};
		char ch='h';
		Assert.assertEquals(' ', findNextBiggestUsingLinearApproach(charr, ch));
		Assert.assertEquals(' ', findNextBiggestCharUsingBinarySearch(charr, ch));
		}
	
	
	/**
	 * Approach: Linear scan
	 * 
	 * 1. Check if length=1 & ASCII of target>ASCII of arr[0] && ASCII of arr[len-1]<= ASCII of target
	 * 	   Yes --> Throw exception since there is no bigger character in array
	 * 	   No  --> Continue further
	 * 2. Iterate through the character array
	 * 	 Check if the ASCII of current element is <= ASCII of target and index!=character array.length-1 (last index)
	 * 		Yes --> Return the next character from array
	 * 		No --> Continue further until loop ends
	 * 
	 * Time complexity: O[N]
	 * 
	 * 
	 * @param charr
	 * @param ch
	 * @return
	 */
	
	private char findNextBiggestUsingLinearApproach(char [] charr, char ch) {
		if ((int) charr[charr.length-1]<= (int) ch)
		{
		return ' ';
		}
		
		for(int i=0;i<charr.length;i++) {
			if((int)charr[i]>(int) ch)
				return charr[i];
		}
		
		return ' ';
	}
	
	
	/**
	 * Approach: Using Binary Search
	 * 
	 * 1. Declare 2 variables, left=0 & right=array.length-1
	 * 2. Check if length=1 & ASCII of target>ASCII of arr[0] && ASCII of arr[len-1]<= ASCII of target
	 * 	   Yes --> Throw exception since there is no bigger character in array
	 * 	   No  --> Continue further
	 * 3. Iterate until left<=right
	 * 4. Find mid value as (left+right)/2
	 * 5. Check if ASCII of mid <= ASCII of target && mid value not equals array.length
	 * 		Yes --> Return character of charr[mid+1]
	 * 	    No -->	
	 *		If ASCII of mid char > ASCII of target
	 *			Yes --> right=mid-1
	 *			No  --> left=mid+1 
	 *
	 *Time Complexity: O[logN]
	 *
	 * 
	 * @param charr
	 * @param ch
	 * @return
	 */
	
	private char findNextBiggestCharUsingBinarySearch(char[] charr, char ch) {
		int left=0,right=charr.length-1;
		
		if((int) charr[charr.length-1]<= (int) ch) return ' ';
		
		while(left<=right) {
			int mid=(left+right)/2;
			if((int) charr[mid]<= (int) ch && mid!=charr.length) return charr[mid+1];
			
			else if((int) charr[mid]>(int) ch) {
				right=mid-1;
			}
			else {
				left=mid+1;
			}
		}
		
		return ' ';
	}

}
