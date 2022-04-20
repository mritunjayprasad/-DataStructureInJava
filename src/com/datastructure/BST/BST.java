package com.datastructure.BST;

public class BST {

	 Node root;
	 
	 public BST() {
		root=null; 
	 }
	 public void insert(int data) {
		 this.root=insert(this.root,data);
	 }
	 public Node insert(Node root,int data) {
		   
		 if(root==null) {
			 root = new Node(data);
			 return root;
		 }
		 if( root.key>data) {
			 root.left=insert(root.left, data);
		 }else {
			 root.right=insert(root.right,data);
		 }
		 return root;
	 }
	 
	 public void display(Node root) {
		 
		  if(root!=null) {
			  display(root.left);
			  System.out.println(root.key);
			  display(root.right);
			  
		  }
	 }
	 public void delete( int data) {
		 delete(this.root,data);
	 }
	 public Node delete(Node root,int data) {
		 
		  if(root==null) {
			  return null;
		  }else {
			    
			  if(root.key>data) {
				   root.left=delete(root.left,data);
			  }
			  else if(root.key<data) {
				  root.right=delete(root.right,data);
			  }else {
				  
				   if(root.left==null && root.right==null) {
					   root=null;
				   }
				   else if(root.left==null) {
					   root=root.right;
				   }else if(root.right==null) {
					   root=root.left;
				   }else {
					    root.key=findeMinFromRight(root.right);
					    delete(root.right,root.key);
				   }
				   
			  }
			  return root;
		  }
	 }
	 public int findeMinFromRight(Node root) {
		  int temp =root.key;
		  
		  while(root.left!=null) {
			  root=root.left;
			  temp=root.key;
		  }
		  return temp;
	 }
}
