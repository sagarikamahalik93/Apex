package com.Assignment;

import java.util.HashSet;

public class LongestConsecutiveNumbers {
	
	public static int findLongestConsecutive(int[] arr) {
		HashSet<Integer> hs=new HashSet<Integer>();
		int result=0;
		for(int i=0;i<arr.length;++i) {
			hs.add(arr[i]);
		}
		
		for(int i=0;i<arr.length;++i) {
			if(!hs.contains(arr[i]-1)) {
				int j=arr[i];
				while(hs.contains(j))
					j++;
				if(result<j-arr[i])
					result=j-arr[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr= {14,5,6,7,99,95,38,57,88,23,54};
		System.out.println("Longest Consecutive "+findLongestConsecutive(arr));
	}
}