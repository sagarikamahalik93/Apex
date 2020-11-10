package com.Assignment;

public class MoveAllZerosToEndProgram {
	
	public static void moveAllZerosToEnd(int[] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				arr[count++]=arr[i];
			}
		}
		while(count<arr.length) {
			arr[count++]=0;
		}
	}

	public static void main(String[] args) {
		int[] arr= {1,2,0,9,7,8,0,3,0};
		System.out.println("Original array : ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		moveAllZerosToEnd(arr);
		System.out.println("\nAfter moving all zeros to the end : ");
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
