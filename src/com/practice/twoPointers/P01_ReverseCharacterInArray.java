package com.practice.twoPointers;

import org.junit.Test;
import org.junit.Assert;

public class P01_ReverseCharacterInArray {
	
	/**
	 * Given an input character array, return the character array by reversing the characters
	 * 
	 * Input: s = ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
	 * 
	 * Input: s = ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
	 * 
	 * 
	 */
	
	
	@Test
	public void eg1() {
		char[] input= {'h','e','l','l','o'};
		Assert.assertArrayEquals(new char[] {'o','l','l','e','h'},reversecharArrayUsingLinear(input));
		Assert.assertArrayEquals(new char[] {'o','l','l','e','h'},reverseUsing2Pointer(input));
	}
	
	@Test
	public void eg2() {
		char[] input= {'H','a','n','n','a','h'};
		Assert.assertArrayEquals(new char[] {'h','a','n','n','a','H'},reversecharArrayUsingLinear(input));
		Assert.assertArrayEquals(new char[] {'h','a','n','n','a','H'},reverseUsing2Pointer(input));
	}
	
	@Test
	public void eg3() {
		char[] input = { 'H'};
		Assert.assertArrayEquals(new char[] {'H'}, reversecharArrayUsingLinear(input));
		Assert.assertArrayEquals(new char[] {'H'}, reverseUsing2Pointer(input));}
	
	@Test
	public void eg4() {
		char[] input = {};
		Assert.assertArrayEquals(new char[] {}, reversecharArrayUsingLinear(input));
		Assert.assertArrayEquals(new char[] {}, reverseUsing2Pointer(input));
	}
	
	
	/**
	 * Approach: Linear scan
	 * 
	 * 1. Declare an output array of the same size as that of input array and a counter variable
	 * 2. Iterate from input array.len-1 to 0
	 * 4. For each iteration, add the corresponding character into the output array of counter index
	 * 5. Return the output array
	 * 
	 * Time Complexity: O[N]
	 * 
	 */
	
	private char[] reversecharArrayUsingLinear(char[] input)
	{
		if(input.length==0) return new char[] {};
		if(input.length==1) return input;
		char[] output = new char[input.length];
		int counter=0;
		
		for(int i=input.length-1;i>=0;i--) {
			output[counter++]=input[i];
		}
		
		return output;
	}
	
	
	/**+
	 * 
	 * Approach: Using 2 pointer
	 * 
	 * 1. Declare 2 pointer left =0 & right = arr.len-1
	 * 2. Iterate until left < right
	 * 3. For each iteration
	 * 		Declare temp char and assign left char to it
	 * 		arr[left]=arr[right]
	 * 		arr[right]=temp
	 * 		Increment left & decrement right
	 * 4. return the input character array
	 * 
	 * Time Complexity: O[N/2]
	 * 
	 * 
	 */
	
	private char[] reverseUsing2Pointer(char[] input) {
		if(input.length==0) return new char[] {};
		if(input.length==1) return input;
		int left=0,right=input.length-1;
		
		while(left<right) {
			char temp=input[left];
			input[left++]=input[right];
			input[right--]=temp;
		}
		
		return input;
	}
	
	
	
}
