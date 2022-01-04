package com.practice.Binary_Search;

public class BinarySearchSample {

    public static void main(String[] args) {
    
    int [] arr = {1,4,6,7,13,18,21,27,34};
    int target = 18;
    int targetIndex=findTargetUsingBS(arr, target);
    System.out.println(targetIndex);
    }

    
    


public static int findTargetUsingBS(int[] arr, int target){
    int start=0;
    int end=arr.length-1;
    int mid = start+((end-start)/2);

    while (start<=end) {
        if(arr[mid]==target) return mid;

        else if(arr[mid]>target) end=mid-1;

        else if(arr[mid]<target) start=mid+1;
        
    }

    return -1;
}

}
