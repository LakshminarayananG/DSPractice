package com.practice.binarySearch;

import org.junit.Test;

public class FindTargetInMountainArray {
	
	
	/**
	 * https://leetcode.com/problems/find-in-mountain-array/
	 */
	
	@Test
	public void eg1() {
		int [] arr= {1,2,3,4,5,3,1};
		int target=3;
		int targetIndex=findInMountainArray(target,arr);
		System.out.println("Output for Eg1 is: "+ targetIndex);
	}
	
	
	@Test
	public void eg2() {
		int [] arr= {0,5,3,1};
		int target=1;
		int targetIndex=findInMountainArray(target,arr);
		System.out.println("Output for Eg2 is: "+ targetIndex);
	}
	
	
	@Test
	public void eg3() {
		int [] arr= {0,1,2,4,2,1};
		int target=1;
		int targetIndex=findInMountainArray(target,arr);
		System.out.println("Output for Eg3 is: "+ targetIndex);
	}
	
	@Test
	public void eg4() {
		int [] arr= {0,1,2,4,2,1};
		int target=6;
		int targetIndex=findInMountainArray(target,arr);
		System.out.println("Output for Eg4 is: "+ targetIndex);
	}
	
	
	
	
	/**
	 * Approach: => Using Binary Search
	 * 
	 * 1. Since this is a mountain array, it would be increasing & then decreasing
	 * 2. Find the peak element of the array
	 * 3. Iterate from 0 to peak to find if the element is present using usual Binary search algo
	 * 4. If element is not present, iterate from peak+1 to end of array
	 * 5. Return the element if found if not, return -1
	 * 
	 *  Time Complexity => O[logn]
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	 public int findInMountainArray(int target, int[] mountainArr) {
	        int peak=findPeakElement(mountainArr);
	        int output = orderAgnosticBinarySearch(mountainArr,target,0,peak);
	        
	       return output!=-1 ? output :orderAgnosticBinarySearch(mountainArr,target,peak+1,mountainArr.length-1) ;
	        
	    }
	    
	    public int findPeakElement(int[] arr){
	        int start=0,end=arr.length-1;
	        
	        while(start<end){
	            int mid=start+(end-start)/2;
	            if(arr[mid]>arr[mid+1]) end=mid;
	            else start=mid+1;
	        }
	        
	        return start;
	    }
	    
	    public int orderAgnosticBinarySearch(int[] arr,int target,int start,int end){
	        boolean isAscending = arr[start]<arr[arr.length-1];
	        while(start<=end){
	            int mid=start+(end-start)/2;
	            if(arr[mid]==target) return mid;
	            if(isAscending) {
					if(arr[mid]>target) end=mid-1;
					else start=mid+1;
				}
				
				else if(!isAscending){
					if(arr[mid]>target) start=mid+1;
					else end=mid-1;
				}
	        }
	        
	        return -1;
	        
	    }

}
