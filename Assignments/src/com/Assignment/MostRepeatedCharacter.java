package com.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class MostRepeatedCharacter {

	public static char findMostRepeatedCharacter(String str) {
		int count[]=new int[256];
		for(int j=0;j<str.length();j++) {
			count[str.charAt(j)]++;
		}
		int max=-1;
		char result=' ';
		for(int i=0;i<str.length();i++) {
			if(max<count[str.charAt(i)]) {
				max=count[str.charAt(i)];
				result=str.charAt(i);
			}
		}
		return result;
	}

	public static void countEachCharacters(String str) {
		HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
		for(int i=str.length()-1;i>=0;i--) {
			if(hm.containsKey(str.charAt(i))) {
				int count=hm.get(str.charAt(i));
				hm.put(str.charAt(i), ++count);
			}else {
				hm.put(str.charAt(i), 1);
			}
		}
		System.out.println("Count of each characters : "+hm);
	}
	
	public static LinkedHashMap<Character,Integer> sortHashMapByValues(HashMap<Character, Integer> hm) {
	    List<Character> mapKeys = new ArrayList<>(hm.keySet());
	    List<Integer> mapValues = new ArrayList<>(hm.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<Character, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<Character> keyItr = mapKeys.iterator();

	        while (keyItr.hasNext()) {
	            Character key = keyItr.next();
	            Integer comparison1 = hm.get(key);
	            Integer comparison2 = val;

	            if (comparison1.equals(comparison2)) {
	                keyItr.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}

	public static void arrangeTheOrder(String str) {
		
		HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
		char[] ch=str.toCharArray();
		for(int i=0;i<str.length();i++) {
			if(hm.containsKey(ch[i])) {
				hm.put(ch[i], hm.get(ch[i])+1);
			}else {
				hm.put(ch[i], 1);
			}
		} 
		System.out.println(sortHashMapByValues(hm));
	}

	public static void main(String[] args) {
		String str="HELLOWORLDJAVAWORLD";
		System.out.println("Most repeated character is : "+findMostRepeatedCharacter(str));
		countEachCharacters(str);
		System.out.println("Arranged in the order of repeat ions : ");
		arrangeTheOrder(str);
	}
}
