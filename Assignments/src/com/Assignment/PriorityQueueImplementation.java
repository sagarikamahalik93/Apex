package com.Assignment;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueImplementation {

	public static void main(String[] args) { 
		PriorityQueue<String> queue = new PriorityQueue<String>(); 
		queue.add("four"); 
		queue.add("one"); 
		queue.add("two"); 
		queue.add("three"); 
		queue.add("five");
		queue.add("eight"); 

		System.out.println("Head element : "  + queue.peek()); 

		System.out.println("PriorityQueue elements:"); 
		Iterator<String> it = queue.iterator(); 
		while (it.hasNext()) 
			System.out.print(it.next() + " "); 

		queue.poll(); 
		System.out.println("\nAfter removing an element"); 
		Iterator<String> itr = queue.iterator(); 
		while (itr.hasNext()) 
			System.out.print(itr.next() + " "); 

		queue.remove("two"); 
		System.out.println("\nElement 'two' with"
				+ " remove function:"); 
		Iterator<String> itr1 =queue.iterator(); 

		while (itr1.hasNext()) 
			System.out.print(itr1.next() + " "); 

		boolean ret_val = queue.contains("five"); 
		System.out.println("\nPriority queue contains 'five' "
				+ "or not?: " + ret_val); 

		Object[] arr = queue.toArray(); 
		System.out.println("Array Contents: "); 
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i].toString() + " "); 
	}
}
