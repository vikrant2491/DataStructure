package com.vikrant.problems;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList1 {
	
	static class SinglyLinkedListNode{
		int data;
		SinglyLinkedListNode next;
		
		public SinglyLinkedListNode(int data) {
			this.data = data;
		}
		
		public boolean equals(Object o){
			SinglyLinkedListNode ob = (SinglyLinkedListNode)o;
			if(this.data==ob.data && this.next==ob.next){
				return true;
			}else
				return false;
		}
		
		public int hashCode(){
			return this.data/9;
		}
	}
	
	static class DoublyLinkedListNode{
		int data;
		DoublyLinkedListNode prev;
		DoublyLinkedListNode next;
		
		public DoublyLinkedListNode(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args){
		int[] arr = {3, 9, 10, 7, 9};
		SinglyLinkedListNode head = null;
		for(int i=0;i<arr.length;i++){
			head = insertInSingly(head, arr[i]);
		}
		display(head);
		head = insertNodeAtPosition(head, 20, 2);
		display(head);
		
		DoublyLinkedListNode head1 = null;
		for(int i=0;i<arr.length;i++){
			head1 = insertSorted(head1, arr[i]);
		}
		
		display(head1);
		head1 = reverse(head1);
		display(head1);
		
		System.out.println(hasCycle(head));
	}
	
	public static SinglyLinkedListNode insertInSingly(SinglyLinkedListNode head, int data){
		SinglyLinkedListNode elem = new SinglyLinkedListNode(data);
		if(head==null){
			return elem;
		}else{
			SinglyLinkedListNode pointer = head;
			while(pointer.next!=null){
				pointer = pointer.next;
			}
			pointer.next=elem;
		}
		return head;
	}
	
	public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		SinglyLinkedListNode elem = new SinglyLinkedListNode(data);
		if(head==null){
			return elem;
		}else if(position==0){
			elem.next= head;
			return elem;
		}		
		else{
			SinglyLinkedListNode pointer = head;
			while(position>1 && pointer.next!=null){
				pointer = pointer.next;
				position--;
			}
			SinglyLinkedListNode temp = pointer.next;
			pointer.next = elem;
			elem.next=temp;
		}
		return head;
	}
	
	public static void display(SinglyLinkedListNode head){
		while(head!=null){
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	public static void display(DoublyLinkedListNode head){
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static DoublyLinkedListNode insertSorted(DoublyLinkedListNode head, int data){
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if(head == null){
			return node;
		}else if(head.data>data){
			node.next= head;
			head.prev = node;
			return node;
		}else{
			DoublyLinkedListNode curr = head;
			while(curr.next!=null && curr.next.data<data){
				curr = curr.next;
			}
			DoublyLinkedListNode temp = curr.next;
			curr.next = node;
			node.prev = curr;
			node.next = temp;
			if(temp!=null)
				temp.prev = node;
			
		}
		return head;
	}
	
	public static DoublyLinkedListNode reverse(DoublyLinkedListNode head){
		DoublyLinkedListNode prev=null;
		while(head!=null){
			DoublyLinkedListNode temp = head.next;
			head.next = head.prev;
			head.prev = temp;
			prev = head;
			head = temp;			
		}
		return prev;
	}
	
	public static boolean hasCycle(SinglyLinkedListNode head){
		HashSet<SinglyLinkedListNode> set = new HashSet<>();
		
		while(head!=null){
			if(set.contains(head)){
				return true;
			}else{
				set.add(head);
			}
			head = head.next;
		}
		return false;
	}

}
