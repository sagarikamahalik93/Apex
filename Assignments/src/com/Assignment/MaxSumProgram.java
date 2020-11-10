package com.Assignment;

public class MaxSumProgram {

	public static int maxSum(int[] arr) {
		int max_all=0, current_max_sum=0;
		for(int i=0;i<arr.length;i++) {
			max_all=max_all+arr[i];
			if(max_all<0) {
				max_all=0;
			}else if(current_max_sum<max_all) {
				current_max_sum=max_all;
			}
		}
		return current_max_sum;
	}

	public static void main(String[] args) {
		int[] arr= {-9,-8,-4,-67,1,2,3,11,23,-99};
		System.out.println("Maximum sum : "+maxSum(arr));
	}
}