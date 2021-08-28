package com.vikrant.problems;

import com.vikrant.problems.BinarySearchTree.Node;

public class BST2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 1, 6, 2, 0, 8, 7, 4 };
		Node root = null;
		for(int i=0;i<arr.length;i++){
			root = insert(root, arr[i]);
		}
		inOrder(root);
		System.out.println();
		System.out.println(search(root, 6).right.data);
		System.out.println(lca(root, 2, 0).data);
		System.out.println(isBST(root));

	}
	
	public static Node insert(Node root, int data){
		Node node = new Node(data);
		if(root==null){
			return node;
		}else{
			if(data<root.data){
				root.left = insert(root.left, data);
			}else if(data>root.data){
				root.right = insert(root.right, data);
			}
		}
		return root;
	}
	
	public static void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	public static Node search(Node root, int data){
		if(root==null)
			return null;
		else if(root.data<data){
			return search(root.right, data);
		}else if(root.data>data){
			return search(root.left, data);
		}else
			return root;
	}
	
	public static Node lca(Node root, int data1, int data2){
		if(root==null)
			return null;
		else{
			if(data1<root.data && data2 < root.data){
				return lca(root.left, data1, data2);
			}else if(data1>root.data && data2>root.data){
				return lca(root.right, data1, data2);
			}else{
				return root;
			}
		}
	}
	
	public static boolean isBST(Node root){
		return isBST_util(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST_util(Node root, int min, int max){
		if(root==null){
			return true;
		}
		if(root.data>max || root.data<min){
			return false;
		}else{
			return isBST_util(root.left, min, root.data-1) && isBST_util(root.right, root.data+1, max);
		}
	}

}
