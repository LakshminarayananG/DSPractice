package week2;

import java.util.Arrays;
import org.junit.Test;

public class ProductOfArrayExceptSelf {
	
	
	/**
	 * Given an Integer Array, find the product of the array except self
	 * 
	 * Example:
	 * Input : [1,2,3,4]
	 * Output: [24,12,8,6]
	 * 
	 */
	
	
	@Test
	public void eg1() {
		int[] arr= {1,2,3,4};
		System.out.println(Arrays.toString(multiplyExceptSelf(arr)));
		System.out.println(Arrays.toString(multiplyExceptCurrentElement(arr)));
		System.out.println(Arrays.toString(productexceptSelf(arr)));
	}
	
	@Test
	public void eg2() {
		int[] arr= {1,-2,3,5};
		System.out.println(Arrays.toString(multiplyExceptSelf(arr)));
		System.out.println(Arrays.toString(multiplyExceptCurrentElement(arr)));
		System.out.println(Arrays.toString(productexceptSelf(arr)));
	}
	
	@Test
	public void eg3() {
		int[] arr= {1,0,3,4};
		System.out.println(Arrays.toString(multiplyExceptSelf(arr)));
		System.out.println(Arrays.toString(multiplyExceptCurrentElement(arr)));
		System.out.println(Arrays.toString(productexceptSelf(arr)));
	}
	
	@Test
	public void eg4() {
		int[] arr= {-1,2,3,4};
		System.out.println(Arrays.toString(multiplyExceptSelf(arr)));
		System.out.println(Arrays.toString(multiplyExceptCurrentElement(arr)));
		System.out.println(Arrays.toString(productexceptSelf(arr)));
	}
	
	
	/**
	 * Brute Force Approach:
	 * 
	 * 1. Declare an Integer array of the same size as input array
	 * 2. Use 2 for loops, 
	 * 		Outer for loop for Iterating from 0 to arr.len-1 and for each iteration assign temp=1
	 * 		Inner for loop to multiply the elements of the array except current element
	 * 3. Return the Output Array
	 * 
	 * Time Complexity: O[N^2]
	 * 
	 * 
	 */
	
	
	private int[] multiplyExceptSelf(int[] arr) {
		int[] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int temp = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i != j)
					temp = temp * arr[j];
			}
			output[i] = temp;
		}

		return output;
	}
	
	
	
	
	private int[] multiplyExceptCurrentElement(int[] arr) {
		int[] output= new int[arr.length];
		int[] left= new int[arr.length];
		int[] right=new int[arr.length];
		left[0]=1;
		right[arr.length-1]=1;
		
		for(int i=0;i<arr.length-1;i++) {
			left[i+1]=left[i]*arr[i];
		}
		
		for(int i=arr.length-1;i>0;i--) {
			right[i-1]=right[i]*arr[i];
		}
		
		for(int k=0;k<arr.length;k++) {
			output[k]=left[k]*right[k];
		}
		
		return output;
	}
	
	//[1,2,3,4]
	private int[] productexceptSelf(int[] nums) {
		int[] output= new int[nums.length];
		output[0]=1;
		for(int i=1;i<nums.length;i++) {
			output[i]=output[i-1]*nums[i-1];
		}
		
		int prod=1;
		for(int i=nums.length-1;i>=0;i--) {
			output[i]=output[i]*prod;
			prod=prod*nums[i];
		}
		
		return output;
	}

}
