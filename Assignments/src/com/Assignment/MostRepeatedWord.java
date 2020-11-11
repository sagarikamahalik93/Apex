package com.Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MostRepeatedWord {

	public static String findMostRepeatedWords(String str) {
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		String[] words=str.split(" ");
		for(int i=0;i<words.length;i++) {
			if(hm.containsKey(words[i])) {
				hm.put(words[i],hm.get(words[i])+1);
			}else {
				hm.put(words[i], 1);
			}
		}
		Set<Map.Entry<String, Integer>> set=hm.entrySet();
		String key="";
		int value=0;
		for(Map.Entry<String, Integer> m:set) {
			if(m.getValue()>value) {
				value=m.getValue();
				key=m.getKey();
			}
		}
		return key;
	}

	public static void main(String[] args) {
		String str="I like programming very much and I like Java too.";
		System.out.println("Most repeated word : "+findMostRepeatedWords(str));
	}
}
