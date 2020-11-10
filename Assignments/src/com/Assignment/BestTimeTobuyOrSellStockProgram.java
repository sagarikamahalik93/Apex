package com.Assignment;

public class BestTimeTobuyOrSellStockProgram {
	
	public static int bestTimeTobuyOrSellStock(int[] prices) {
		if(prices==null || prices.length<=1) {
			return 0;
		}
		int min=prices[0];
		int result=0;
		for(int i=1;i<prices.length;i++) {
			result=Math.max(result, prices[i]-min);
			min=Math.min(min, prices[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] prices= {12,34,45,23,67,10};
		System.out.println("Best time to buy or sell stock : "+bestTimeTobuyOrSellStock(prices));
	}
}
