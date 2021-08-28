package com.vikrant.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree1 {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		// pre - 3 5 6 2 7 4 1 0 8
		// In - 6 5 7 2 4 3 0 1 8
		// Post - 6 7 4 2 5 0 8 1 3
		// Level - 3 5 1 6 2 0 8 7 4

		// ************Binary tree
		Object[] arr = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		Node root = createLevelOrderTree(arr, 0);
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		levelOrder(root);
		System.out.println(preOrderWithoutRecursion(root));
		System.out.println(inorderWithoutRecursion(root));
		System.out.println(postOrderWithoutRecursion(root));

		System.out.println(height(root));
		System.out.println(leftView(root));
		leftMost(root);
		System.out.println(rightView(root));
		rightMost(root);
		System.out.println(leafNodes(root));
		
		System.out.println(path(root, 7));
		System.out.println(path(root, 6));
		System.out.println(lca(root, 7, 6));
		
	}

	public static Node createLevelOrderTree(Object[] arr, int i) {
		Node root = null;
		if (i < arr.length) {
			if (arr[i] != null) {
				root = new Node((int) arr[i]);
				root.left = createLevelOrderTree(arr, 2 * i + 1);
				root.right = createLevelOrderTree(arr, 2 * i + 2);
			}
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

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void levelOrder(Node root) {
		int depth = 0;
		Queue<Node> q = new LinkedList<>();
		if (root != null) {
			depth++;
			q.offer(root);
			q.offer(null); // null is inserted to segregate the levels
		}
		while (!q.isEmpty()) {
			Node elem = q.poll();
			if (elem == null && !q.isEmpty()) {
				q.offer(elem);
				depth++;
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
		System.out.println(System.lineSeparator() + depth);
	}

	public static List<Integer> preOrderWithoutRecursion(Node root) {
		// Stack is used to store right and left elem so that they can be
		// backtracked
		List<Integer> res = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		if (root != null) {
			st.push(root);
		}
		while (!st.isEmpty()) {
			Node temp = st.pop();
			res.add(temp.data);
			if (temp.right != null)
				st.push(temp.right);
			if (temp.left != null)
				st.push(temp.left);
		}
		return res;
	}

	public static List<Integer> inorderWithoutRecursion(Node root) {
		// Stack is used to get to right childs
		// curr is used to deal with current and left child
		List<Integer> res = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		Node curr = root;
		boolean status = true;

		while (status) {
			if (curr == null) {
				if (st.isEmpty()) {
					status = false;
				} else {
					curr = st.pop();
					res.add(curr.data);
					curr = curr.right;
				}
			} else {
				if (curr.left != null) {
					st.push(curr);
					curr = curr.left;
				} else {
					res.add(curr.data);
					curr = curr.right;
				}
			}
		}
		return res;
	}

	public static List<Integer> postOrderWithoutRecursion(Node root) {
		// curr is to deal with current top of stack
		// prev is to determine movement of flow - parent to child or child to
		// parent
		// stack is used to store nodal elements
		List<Integer> res = new ArrayList<>();
		Node prev = null;
		Stack<Node> st = new Stack<>();
		if (root != null)
			st.push(root);
		while (!st.isEmpty()) {
			Node curr = st.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					st.push(curr.left);
				} else if (curr.right != null) {
					st.push(curr.right);
				}
			} else if (prev == curr.left) {
				st.push(curr.right);
			} else {
				res.add(curr.data);
				st.pop();
			}
			prev = curr;
		}
		return res;
	}

	public static int height(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftH = height(root.left);
			int rightH = height(root.right);
			if (leftH > rightH) {
				return leftH + 1;
			} else {
				return rightH + 1;
			}
		}
	}

	public static List<Integer> leftView(Node root) {
		List<Integer> res = new ArrayList<>();
		while (root != null) {
			res.add(root.data);
			root = root.left;
		}
		return res;
	}

	public static void leftMost(Node root) {
		if (root.left != null) {
			leftMost(root.left);
		} else {
			System.out.print(root.data + " ");
		}
	}

	public static List<Integer> rightView(Node root) {
		List<Integer> res = new ArrayList<>();
		while (root != null) {
			res.add(root.data);
			root = root.right;
		}
		return res;
	}

	public static void rightMost(Node root) {
		if (root != null) {
			if (root.right != null) {
				rightMost(root.right);
			} else {
				System.out.print(root.data + " ");
			}
		}

	}

	public static List<Integer> leafNodes(Node root) {
		List<Integer> res = new ArrayList<>();
		Node curr = root;
		boolean status = true;
		Stack<Node> st = new Stack<>();
		while (status) {
			if (curr == null) {
				if (st.isEmpty()) {
					status = false;
				} else {
					curr = st.pop();
					curr = curr.right;
				}

			} else {
				if (curr.left != null) {
					st.push(curr);
					curr = curr.left;
				} else {
					if (curr.right == null) {
						res.add(curr.data);
					}
					curr = curr.right;
				}
			}
		}
		return res;
	}

	public static int lca(Node root, int data1, int data2) {
		List<Integer> path1 = path(root, data1);
		List<Integer> path2 = path(root, data2);
		int i=0;
		while(i<path1.size() && i<path2.size()){
			if(path1.get(i)==path2.get(i)){
				i++;
			}else{
				break;
			}
		}
		return path1.get(i-1);
		}
	
	public static List<Integer> path(Node root, int data){
		List<Integer> path = new ArrayList<>();
		Node prev = null;
		boolean status = false;
		Stack<Node> st = new Stack<>();
		if (root != null)
			st.push(root);
		while (!st.isEmpty() && !status) {
			Node curr = st.peek();
			if (curr.data == data) {
				st.pop();
				status = true;
			} else {
				if (prev == null || prev.left == curr || prev.right == curr) {
					if (curr.left != null) {
						st.push(curr.left);
					}else if(curr.right!=null){
						st.push(curr.right);
					}
				}else if(curr.left==prev){
					if(curr.right!=null){
						st.push(curr.right);
					}
				}else{
					st.pop();
				}
				prev = curr;
			}
		}
		while(!st.isEmpty()){
			path.add(st.pop().data);
		}
		Collections.reverse(path);
		return path;	
	}

	// lcp in BT and BST
	// Full view
	// isBST
	// Heaping
	// delete in bst
	// delete in BT

	// How do you print common nodes in two binary search trees in Java?
	// Binary tree balanced or not

}
