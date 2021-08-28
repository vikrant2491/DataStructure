package com.vikrant.test.runner;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.vikrant.test.ds.SingleLinkList;

public class MainRunner {

	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		list.linkLast("A");
		list.linkLast("B");
		list.linkLast("C");
		list.linkLast("B");
		list.linkLast("E");
		System.out.println(list.toString());
		list.unlinkFirst();
		System.out.println(list.toString());
		list.unlinkLast();
		System.out.println(list.toString());
		System.out.println(list.firstIndexOf("b"));
		System.out.println(list.lastIndexOf("b"));
		list.linkAfter(list.getNode(1), "z");
		System.out.println(list.toString());
	}

}
