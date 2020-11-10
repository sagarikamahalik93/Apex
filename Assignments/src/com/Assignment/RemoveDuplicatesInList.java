package com.Assignment;

public class RemoveDuplicatesInList {
	
	static class Node{
		int data;
		Node next;
	};
	
	public static Node removeDuplicates(Node node) {
		if(node==null) {
			return null;
		}
		node.next=removeDuplicates(node.next);
		if(node.next!=null && node.next.data==node.data) {
			Node result=node.next;
			return result;
		}
		return node;
	}
	
	public static Node push(Node node_ref, int new_data) {
		Node new_node=new Node();
		new_node.data=new_data;
		new_node.next=(node_ref);
		(node_ref)=new_node;
		return node_ref;
	}
	
	public static void printList(Node node) {
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		Node node=null;
		node=push(node, 2);
		node=push(node, 11);
		node=push(node, 11);
		node=push(node, 11);
		node=push(node, 52);
		node=push(node, 64);
		node=push(node, 78);
		Node n=removeDuplicates(node);
		printList(n);
	}
}
