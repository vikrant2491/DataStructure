package com.vikrant.problems;

public class BinarySearchTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,1,6,2,0,8,7,4};
		Node root = null;
		for(int i=0;i<arr.length;i++){
			root = insertInBST(root, arr[i]);
		}
		inOrder(root);
		Node node = search(root, 1);
		System.out.println();
		System.out.println(node.data);
		System.out.println(node.left.data);
		System.out.println(node.right.data);
		System.out.println(lca_BST(root, 2, 0).data);
	}
	
	public static Node insertInBST(Node root, int data){
		if(root==null){
			root = new Node(data);
		}else{
			if(data>root.data){
				root.right = insertInBST(root.right, data);				
			}else{
				root.left = insertInBST(root.left, data);
			}
		} 
		return root;
	}
	
	//Sorting
	public static void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	//Searching using BST
	
	public static Node search(Node root, int data){
		if(root==null){
			return null;
		}else{
			if(data<root.data){
				return search(root.left, data);
			}else if(data>root.data){
				return search(root.right, data);
			}else{
				return root;
			}
		}
	}
	
	public static Node lca_BST(Node root, int data1, int data2){
		if(data1<root.data && data2<root.data){
			return lca_BST(root.left, data1, data2);
		}else if(data1>root.data && data2>root.data){
			return lca_BST(root.right, data1, data2);
		}else{
			return root;
		}
	}
	
	public static boolean isBST(Node root){
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBSTUtil(Node root, int min, int max){
		if(root==null){
			return true;
		}
		if(root.data<min || root.data>max){
			return false;
		}
		return isBSTUtil(root.left, min, root.data-1) && isBSTUtil(root.right, root.data+1, max);		
	}
	


}
