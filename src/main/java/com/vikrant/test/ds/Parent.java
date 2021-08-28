package com.vikrant.test.ds;

abstract public class Parent {
	static int id;
	static String name;
	
	public void display(){
		System.out.println(id+name);
	}
	
	static public void print(){
		System.out.println("Parent print");
	}

}
