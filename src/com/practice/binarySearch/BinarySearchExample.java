package com.practice.binarySearch;

import org.junit.Test;

public class BinarySearchExample {
	
	@Test
	public void eg1() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=21;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println("Output for Eg1 is: "+ targetIndex);
	}

	@Test
	public void eg2() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=2;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println("Output for Eg2 is: "+ targetIndex);
	}
	
	@Test
	public void eg3() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=1;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println("Output for Eg3 is: "+ targetIndex);
	}
	
	@Test
	public void eg4() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=34;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println("Output for Eg4 is: "+ targetIndex);
	}
	
	@Test
	public void eg5() {
		int [] arr= {1,4,6,10,14,17,21,28,34};
		int target=14;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println("Output for Eg5 is: "+ targetIndex);
	}
	
	@Test
	public void eg6() {
		int [] arr= {1,1,1,1,1,1,1,1,1};
		int target=1;
		int targetIndex=findTargetUsingBS(arr, target);
		System.out.println("Output for Eg5 is: "+ targetIndex);
	}
	
	public static int findTargetUsingBS(int[] arr, int target) {
		int start=0,end=arr.length-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]>target) end=mid-1;
			else if(arr[mid]<target) start=mid+1;
			else return mid;
		}
		
		return -1;
	}

}
