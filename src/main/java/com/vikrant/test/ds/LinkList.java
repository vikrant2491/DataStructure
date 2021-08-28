package com.vikrant.test.ds;

public class LinkList {
//	-------Types
//	Single Linked List
//	Double Linked List
//	Circular Linked List
//	node
//	-------Operations
//	insert a node at start, at end and between nodes
//	delete a node at start, at end and between nodes
//	get node with index
//	get node with value
//	Update node with index
//	Update node with value
//	size
//	Traverse and print
//	lastIndexOf
//	firstIndexOf
	
//	-------Additional
//	Info
//	Complexities - Space and Time
//	Advantage/Disadvantage
//	Usage
	
	Node first;
	Node last;
	int size;
	
	public void linkFirst(String val){
		Node temp = first;
		Node elem = new Node(null, val, temp);
		first = elem;
		if(first== null){
			last = elem;
		}else{
			temp.prev = elem;
		}
		size++;
	}
	
	public void linkLast(String val){
		Node temp = last;
		Node newNode = new Node(temp, val, null );
		last = newNode;
		if(last==null){
			first=newNode;
		}else{
			temp.next=newNode;
		}
		size++;
	}
	
	public void unlinkFirst(){
		Node temp = first.next;
		first.next=null;
		first.item=null;
		
		first = temp;
		if(temp==null){
			last = null;
		}else{
			temp.prev = null;
		}
		size--;
	}
	
	public void unlinkLast(){
		Node temp = last.prev;
		last.prev=null;
		last.item = null;
		last = temp;
		if(temp==null)
			first=null;
		else
			temp.next=null;		
		size--;			
	}
	
	public Node getNode(int i){
		Node current = first;
		if(i>size){
			System.out.println("Invalid index");
			return null;
		}else if(i==size){
			return last;
		}else if(i==1){
			return first;
		}else{
			for(int j=1;j<i;j++){
				current=current.next;				
			}
			return current;
		}
	}
	
	public Node getNode(String val){
		Node current = first;
		for(int i=1;i<=size;i++){
			if(current.item.equalsIgnoreCase(val)){
				return current;
			}else{
				current=current.next;
			}
		}
		return null;
	}
	
	public void unlink(Node e){
		 Node prev = e.prev;
		 Node next = e.next;
		 
		 if(prev==null){
			 first=next;
		 }else{
			 e.prev=null;
			 prev.next=next;
		 }
		 
		 if(next==null){
			 last=prev;
		 }else{
			 e.next=null;
			 next.prev=prev;
		 }
		 size++;
	}
	
	public void linkBefore(Node e, Node newNode){
		Node x = e.prev;
		e.prev=newNode;
		if(x==null){
			first = newNode;			
		}else{
			x.next=newNode;			
		}
		size++;
	}
}



class Node{
	String item;
	Node prev;
	Node next;
	
	public Node(){
		
	}
	public Node(Node prev, String val, Node next){
		this.item = val;
		this.prev = prev;
		this.next = next;		
	}
}
