package com.Assignment;

public class LongestWithoutRepeatedCharacters {
	
	public static int lengthOfLongestWithoutRepeatedCharacters(String str) {
		if(str==null || str.length()==0)
			return 0;
		int[] count=new int[128];
		int max=0, start=0, current=0;
		while(current<str.length() && start<str.length()) {
			if(count[str.charAt(current)]==0) {
				count[str.charAt(current)]++;
				current++;
				max=Math.max(max, current-start);
			}else {
				count[str.charAt(start)]--;
				start++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String str="Welcome to java world";
		System.out.println("Length Of Longest Without repeated Characters : "+lengthOfLongestWithoutRepeatedCharacters(str));
	}
}
