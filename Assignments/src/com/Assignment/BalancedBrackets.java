package com.Assignment;

public class BalancedBrackets {

	public static boolean isBalanced(String brackets) {
		boolean flag=true;
		int count=0;
		for(int i=0;i<brackets.length();i++) {
			if(brackets.charAt(i)=='(') {
				count++;
			}else {
				count--;
			}
			if(count<0) {
				flag=false;
				break;
			}
		}
		if(count!=0) {
			flag=false;
		}
		return flag;
	}

	public static void main(String[] args) {
		String bracket1="((())()())";
		if(isBalanced(bracket1)) {
			System.out.println("Balanced Brackets");
		}else {
			System.out.println("Not balanced");
		}
		String bracket2="((())()(())";
		if(isBalanced(bracket2)) {
			System.out.println("Balanced Brackets");
		}else {
			System.out.println("Not balanced");
		}
	}
}