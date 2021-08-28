package com.vikrant.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree2 {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 1, 6, 2, 0, 8, 7, 4 };
		Node root = insertInLevelOrder(arr, 0);
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		System.out.println("Without recursion********");
		preOrderWithoutRecusrion(root);
		inOrderWithoutRecursion(root);
		postOrderWithoutRecursion(root);
		levelOrdertraversal(root);
		System.out.println(height(root));
		leftView(root);
		rightView(root);
		leafNodes(root);
		System.out.println(getHeight(root));
		postOrderWithoutRecursion(root);
		System.out.println(path(root, 4));
	}

	public static Node insertInLevelOrder(int[] arr, int i) {
		Node root = null;
		if (i < arr.length) {
			root = new Node(arr[i]);
			root.left = insertInLevelOrder(arr, 2 * i + 1);
			root.right = insertInLevelOrder(arr, 2 * i + 2);
		}
		return root;
	}

	public static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void preOrderWithoutRecusrion(Node root) {
		if (root == null)
			return;
		else {
			Stack<Node> st = new Stack<>();
			st.push(root);
			while (!st.isEmpty()) {
				Node elem = st.pop();
				System.out.print(elem.data + " ");
				if (elem.right != null)
					st.push(elem.right);
				if (elem.left != null)
					st.push(elem.left);
			}
		}
		System.out.println();
	}

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public static void inOrderWithoutRecursion(Node root) {
		Stack<Node> st = new Stack<>();
		if (root == null)
			return;
		else {
			Node curr = root;
			boolean status = true;
			while (status) {
				if (curr != null) {
					st.push(curr);
					curr = curr.left;
				} else {
					if (st.isEmpty()) {
						status = false;
					} else {
						curr = st.pop();
						System.out.print(curr.data + " ");
						curr = curr.right;
					}
				}
			}
		}
		System.out.println();
	}

	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void postOrderWithoutRecursion(Node root) {
		if (root == null)
			return;
		else {
			Stack<Node> st = new Stack<>();
			Node prev = null;

			st.push(root);
			while (!st.isEmpty()) {
				Node curr = st.peek();
				if (prev == null || prev.left == curr || prev.right == curr) {
					if (curr.left != null) {
						st.push(curr.left);
					} else if (curr.right != null) {
						st.push(curr.right);
					}
				} else if (curr.left == prev) {
					if (curr.right != null) {
						st.push(curr.right);
					}
				} else {
					Node elem = st.pop();
					System.out.print(elem.data + " ");
				}
				prev = curr;
			}
			System.out.println();
		}
	}

	public static void levelOrdertraversal(Node root) {
		Queue<Node> q = new LinkedList<>();
		if (root == null)
			return;
		else {
			q.offer(root);
			q.offer(null);
		}
		while (!q.isEmpty()) {
			Node elem = q.poll();
			if (elem == null && !q.isEmpty()) {
				q.offer(null);
				System.out.println();
			} else if (elem != null) {
				System.out.print(elem.data + " ");
				if (elem.left != null) {
					q.offer(elem.left);
				}
				if (elem.right != null) {
					q.offer(elem.right);
				}
			}
		}
		System.out.println();
	}

	public static int height(Node root) {
		Queue<Node> q = new LinkedList<>();
		int height = 0;
		if (root == null)
			return 0;
		else {
			q.offer(root);
			q.offer(null);
		}
		while (!q.isEmpty()) {
			Node elem = q.poll();
			if (elem != null) {
				if (elem.left != null)
					q.offer(elem.left);
				if (elem.right != null)
					q.offer(elem.right);
			} else {
				if (!q.isEmpty()) {
					q.offer(null);
				}
				height++;
			}
		}
		return height;
	}

	public static void leftView(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.left;
		}
		System.out.println();
	}

	public static void rightView(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
		System.out.println();
	}

	public static void leafNodes(Node root) {
		if (root == null)
			return;
		else {
			Stack<Node> st = new Stack<>();
			st.push(root);
			while (!st.isEmpty()) {
				Node elem = st.pop();
				if (elem.left == null && elem.right == null)
					System.out.print(elem.data + " ");
				else {
					if (elem.right != null)
						st.push(elem.right);

					if (elem.left != null) {
						st.push(elem.left);
					}
				}
			}
		}
		System.out.println();
	}

	public static void topview(Node root) {
		
	}
	
	public static int getHeight(Node root){
		if(root==null)
			return 0;
		else{
			int leftH = getHeight(root.left);
			int rightH = getHeight(root.right);
			if(leftH>rightH){
				return leftH+1;
			}else{
				return rightH+1;
			}
		}
	}
	
	public static List<Integer> path(Node root, int data){
		LinkedList<Integer> path = new LinkedList<>();
		boolean status = false;
		if(root!=null){
			Stack<Node> st = new Stack<>();
			Node prev = null;
			st.push(root);
			while(!st.isEmpty() && !status){
				Node curr = st.peek();
				if(prev==null || prev.left==curr || prev.right==curr){
					if(curr.left!=null)
						st.push(curr.left);
					else if(curr.right!=null)
						st.push(curr.right);
				}else if(curr.left==prev){
					if(curr.right!=null)
						st.push(curr.right);
				}else{					
					Node elem = st.pop();
					if(elem.data==data){
						status = true;
					}
				}
				prev = curr;
			}
			
			while(!st.isEmpty()){
				path.offerFirst(st.pop().data);
			}
			
		}
		return path;
		
	}

}
