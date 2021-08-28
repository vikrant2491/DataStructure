package com.vikrant.test.ds;

public class SingleLinkList {
//	-------Types
//	Single Linked List
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
	
	SingleNode first;
	SingleNode last;
	long size = 0;
	
	public void linkFirst(String val){
		SingleNode item = new SingleNode(val, null);
		if(first==null){
			first = item;
			last = item;
		}else{
			SingleNode temp = first;
			item.next = temp;
			first = item;
		}
		size++;
	}
	
	public void linkLast(String val){
		SingleNode item = new SingleNode(val, null);
		if(first==null){
			first = item;
			last = item;
		}else{
			SingleNode temp = last;
			temp.next = item;
			last = item;
		}
		size++;
	}
	
	public void linkAfter(SingleNode e, String val){
		if(e==null)
			linkFirst(val);
		else{
			SingleNode newNode = new SingleNode(val, e.next);
			e.next = newNode;
		}
		
		size++;
	}
	
	public SingleNode getNode(int index){
		SingleNode temp = first;
		for(int i=0;i<index;i++){
			temp = temp.next;
			if(temp==null)
				return null;
		}
		return temp;
	}
	
	public SingleNode getNode(String value){
		SingleNode temp = first;
		while(temp!=null){
			if(temp.item.equalsIgnoreCase(value)){
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
	public String unlinkFirst(){
		if(first==null){
			size=0;
			return null;
		}else{
			SingleNode temp = first;
			String val = first.item;
			first.item = null;
			if(first.next==null){
				first = null;
				last = null;
			}else{
				first = temp.next;
				temp.next=null;
			}
			size--;
			return val;
		}				
	}
	
	public String unlinkLast(){
		if(first==null){
			size=0;
			return null;
		}else{
			SingleNode temp = first;
			String val = last.item;
			last.item=null;
			if(first.next==null){
				first = null;
				last = null;
			}else{
				while(temp.next.next!=null){
					temp=temp.next;
				}
				temp.next = null;
				last = temp;
			}
			size--;
			return val;
		}
	}
	
	public String unlink(SingleNode node){
		if(first==null){
			size=0;
			return null;
		}else{
			SingleNode temp = first;
			String val = null;
			if(first==node){
				val = unlinkFirst();
			}else if(last == node){
				val = unlinkLast();
			}else{
				while(temp!=null){
					if(temp.next==node){
						val = node.item;
						temp.next=node.next;
						node.item=null;
						node.next=null;
						break;
					}
					temp = temp.next;
				}
			}
			size--;
			return val;
		}
	}
	
	public int size(){
		return this.size();
	}
	
	public String toString(){
		SingleNode temp = first;
		String val = "";
		if(this.size==0){
			val = null;
		}else{
			while(temp!=null){
				val = val+" "+temp.item;
				temp = temp.next;
			}
		}
		return val;
	}
	
	public int firstIndexOf(String val){
		SingleNode temp = first;
		int i = 0;
		int index = -1;
		while(temp!=null){
			if(temp.item.equalsIgnoreCase(val)){
				index = i;
				break;
			}
			i++;
			temp = temp.next;
		}
		return index;
	}
	
	public int lastIndexOf(String val){
		SingleNode temp = first;
		int i = 0;
		int index = -1;
		while(temp!=null){
			if(temp.item.equalsIgnoreCase(val)){
				index = i;;
			}
			i++;
			temp = temp.next;
		}
		return index;
	}
	
	public void updateNode(int n, String newval){
		SingleNode temp = first;
		if(n<0 || n>size){
			return;
		}
		for(int i=0;i<n;i++){
			temp = temp.next;
		}
		temp.item = newval;
	}
	
	public void updateNode(String val){
		SingleNode temp = first;
		while(temp!=null){
			if(temp.item.equalsIgnoreCase(val)){
				temp.item = val;
				break;
			}
		}
	}
	
	public void updateAllNodes(String val){
		SingleNode temp = first;
		while(temp!=null){
			if(temp.item.equalsIgnoreCase(val)){
				temp.item = val;
			}
		}
	}
}

class SingleNode{
	String item;
	SingleNode next;
	
	public SingleNode(String item, SingleNode next){
		this.item = item;
		this.next = next;
	}
	
}
