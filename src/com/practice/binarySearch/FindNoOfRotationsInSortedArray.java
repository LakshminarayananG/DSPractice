package com.
practice.binarySearch;

import org.junit.Test;

public class FindNoOfRotationsInSortedArray {
	
	
	//{10,12,2,4,5,7,8,9}
	
	
	@Test
	public void eg1() {
		int[] arr= {14,2,4,5,7,8,9,10,12};
		int peakelement=findPeakElement(arr);
		System.out.println("Peak element is: "+peakelement);
		System.out.println("No of rotations is: "+(peakelement+1));
	}
	
	
	@Test
	public void eg2() {
		int[] arr= {14,17,22,34,2,4,5,7,8,9,10,12};
		int peakelement=findPeakElement(arr);
		System.out.println("Peak element is: "+peakelement);
		System.out.println("No of rotations is: "+(peakelement+1));
	}
	
	@Test
	public void eg3() {
		int[] arr= {14,17,22,4,5,7,8,9,10,12};
		int peakelement=findPeakElement(arr);
		System.out.println("Peak element is: "+peakelement);
		System.out.println("No of rotations is: "+(peakelement+1));
	}
	
	
	
	private int findPeakElement(int[] arr) {
		int start=0,end=arr.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			
			if(mid<end && arr[mid]>arr[mid+1]) return mid;
			if(mid>start && arr[mid]<arr[mid-1]) return mid-1;
			
			if(arr[mid]<=arr[start]) end=mid-1;
			else start=mid+1;
		}
		
		return -1;
	}
}
