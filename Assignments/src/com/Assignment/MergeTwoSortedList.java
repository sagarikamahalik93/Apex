package com.Assignment;

public class MergeTwoSortedList {
	
	static class Node{
		int data;
		Node next;
	};
	
	static Node newNode(int key) {
		Node temp=new Node();
		temp.data=key;
		temp.next=null;
		return temp;
	}
	
	static void printLists(Node node) {
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
	}
	
	public static Node mergeLists(Node n1, Node n2) {
		if(n1==null) {
			return n2;
		}
		if(n2==null) {
			return n1;
		}
		if(n1.data<n2.data) {
			n1.next=mergeLists(n1.next, n2);
			return n1;
		}else {
			n2.next=mergeLists(n1, n2.next);
			return n2;
		}
	}

	public static void main(String[] args) {
		Node n1=newNode(1);
		n1.next=newNode(3);
		n1.next.next=newNode(7);
		
		Node n2=newNode(0);
		n2.next=newNode(4);
		n2.next.next=newNode(5);
		System.out.println("Merged lists : ");
		Node mergeLists=mergeLists(n1, n2);
		printLists(mergeLists);
	}
}
