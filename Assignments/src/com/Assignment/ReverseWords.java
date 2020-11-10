package com.Assignment;

public class ReverseWords {

	public static void reverseWordsInString(String str) {
		//first we have to check the string whether it is null or not
		if(str==null || str.length()==0) {
			System.out.println("String is empty");
		}
		//then we have to convert it into string array so that we can reverse it
		String[] words=str.split(" ");//after every space string will split into words and store in the array
		for(int i=words.length-1;i>=0;i--) {//for reverse we will start with end word then decrement it to first
			System.out.print(words[i]+" ");
		}
	}

	public static void main(String[] args) {
		String str="I like this program very much";
		System.out.println("Before reversing : \n"+str);
		System.out.println("After Reversing words in the string : ");
		reverseWordsInString(str);
	}
}
