package com.Assignment;

public class RemoveDuplicatesProgram {
	
	public static int removeDuplicates(int[] arr) {
		if(arr.length==0 || arr.length==1) {
			return arr.length;
		}
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[j++]=arr[i];
			}
		}
		arr[j++]=arr[arr.length-1];
		return j;
	}
	
	public static void main(String[] args) {
		int[] arr= {1,1,1,2,3,44,45,45};
		System.out.println("Before removing duplicates : ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
		int result=removeDuplicates(arr);
		System.out.println("\nAfter removing duplicates :");
		for(int i=0;i<result;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
