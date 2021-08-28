package com.vikrant.test.ds;


public class StackDS {
//	-------Types
//	Stack using Static Array
//	Stack using Dynamic array/ List
//	Stack using Linked List
	
//	-------Operations
//	top
//	push
//	pop
//	peek
//	Traverse and print
//	size
	
//	-------Additional
//	Info
//	Complexities - Space and Time
//	Advantage/Disadvantage
//	Usage
	

	int top;
	int capacity;
	int incCap;	
	String[] stack;
	
	public StackDS(){
		stack = new String[10];
	}
	
	public StackDS(int cap, int inCap){			
		this(cap);
		this.incCap = inCap;
	}
	
	public StackDS(int cap){
		this.capacity = cap;
		stack = new String[capacity];
	}
	
	public void push(String elem){
		stack[++top] = elem;
	}
	
	public String pop(){
		String data = stack[top];
		stack[top--] = null;
		return data;
	}
	
	public String peek(){
		return stack[top];
	}
	
	public int size(){
		return top+1;
	}

}
