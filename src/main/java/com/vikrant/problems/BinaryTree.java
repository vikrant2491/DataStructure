package com.vikrant.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	Node() {
	}
}

public class BinaryTree {
	public static List<Integer> tree = new ArrayList<>();

	public static void main(String[] args) {
		Object[] arr = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		Node root = new Node(3);
		createBinaryTree(root, arr);

		// preOrderTraversalWithRecursion(root);
		// inorderWithrecursion(root);
		postOrderWithRecursion(root);
		System.out.println(tree);
		System.out.println(preOrderWithoutRecursion(root));
		System.out.println(inorderWithoutRecursion(root));
		System.out.println(postOrderWithoutRecursion(root));
	}

	public static void createBinaryTree(Node root, Object[] arr) {
		int current = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);

		Node elem = queue.poll();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == null) {
				if (current == 0) {
					elem.left = null;
					current = 1;
				} else {
					elem.right = null;
					current = 0;
					elem = queue.poll();
				}
			} else {
				if (current == 0) {
					elem.left = new Node((int) (arr[i]));
					queue.offer(elem.left);
					current = 1;
				} else {
					elem.right = new Node((int) arr[i]);
					queue.offer(elem.right);
					current = 0;
					elem = queue.poll();
				}
			}
		}

	}

	public static void preOrderTraversalWithRecursion(Node root) {
		if (root != null) {
			tree.add(root.data);
			preOrderTraversalWithRecursion(root.left);
			preOrderTraversalWithRecursion(root.right);
		}
	}

	public static List<Integer> preOrderWithoutRecursion(Node root) {
		List<Integer> res = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			res.add(temp.data);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		return res;
	}

	public static void inorderWithrecursion(Node root) {
		if (root != null) {
			inorderWithrecursion(root.left);
			tree.add(root.data);
			inorderWithrecursion(root.right);
		}
	}

	public static List<Integer> inorderWithoutRecursion(Node root) {
		List<Integer> res = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		Node current = root;
		boolean status = true;
		while (status) {
			if (current == null) {
				if (st.isEmpty()) {
					status = false;
				} else {
					current = st.pop();
					res.add(current.data);
					current = current.right;
				}
			} else {
				if (current.left != null) {
					st.push(current);
					current = current.left;
				} else {
					res.add(current.data);
					current = current.right;
				}
			}

		}
		return res;
	}

	public static void postOrderWithRecursion(Node root) {
		if (root != null) {
			postOrderWithRecursion(root.left);
			postOrderWithRecursion(root.right);
			tree.add(root.data);
		}
	}

	public static List<Integer> postOrderWithoutRecursion(Node root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<Node> st = new Stack<>();
		if(root!=null)
			st.push(root);
		Node prev = null;
		while (!st.isEmpty()) {
			Node current = st.peek();
			if (prev == null || prev.left == current || prev.right == current) {
				if(current.left!=null){
					st.push(current.left);	
				}else if(current.right!=null){
					st.push(current.right);
				}
			} else if (current.left == prev) {
				if(current.right!=null){
					st.push(current.right);
				}
			} else  {
				res.add(current.data);
				st.pop();
			}
			prev = current;
		}
		return res;
	}

	public Node lowestCommonAncestorInBST(Node root, int data1, int data2) {
		if (root == null) {
			return null;
		}
		if (data1 < root.data && data2 < root.data) {
			return lowestCommonAncestorInBST(root.left, data1, data2);
		} else if (data1 > root.data && data2 > root.data) {
			return lowestCommonAncestorInBST(root.right, data1, data2);
		} else {
			return root;
		}
	}

	public Node lowestcommonAncestorInBT(Node root, int data1, int data2) {
		return root;
	}

}
