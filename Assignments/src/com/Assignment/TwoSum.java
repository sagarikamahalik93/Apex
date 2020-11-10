package com.Assignment;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

//	public static void sum(int[] arr, int target) {
//		for(int i=0;i<arr.length;i++) {
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[i]+arr[j]==target) {
//					System.out.println(arr[i]+" "+arr[j]);
//				}
//			}
//		}
//	}
//	
	public static int[] sum(int[] arr, int target) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length;i++) {
			int complement = target - arr[i];
			if(hm.containsKey(complement)) {
				return new int[] {hm.get(complement), i};
			}else {
				hm.put(arr[i], i);
			}
		}
			return new int[] {};
	}
	
	public static void main(String[] args) {
		int[] arr= {2,3,4,5,7};
		int target=6;
		System.out.println(sum(arr, target));	
	}
}
