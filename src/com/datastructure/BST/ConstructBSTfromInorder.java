package com.datastructure.BST;

public class ConstructBSTfromInorder {
      Node root;
      
      public ConstructBSTfromInorder() {
    	  root=null;
      }
	public  Node implementsBST( Node root,int val) {
		
		   if(root==null) {
			   root = new Node(val);
			   return root;
		   }
		   if(root.key>val) {
			   root.left=implementsBST(root.left, val);
		   }else {
			   root.right=implementsBST(root.right, val);
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
	public Node BST(Node root,int preorder[],int index,int val,int size,int min,int max) {
		
		    if(index>=size) {
		    	return null;
		    }
		    if(root==null) {
		    	root=new Node(val);
		    	index++;
		    	return root;
		    }
		    if(root.key>val) {
              root.left=BST(root.left,preorder,index,preorder[index],size,min,root.key);		    	
		    }
	}
	public static void main(String[] args) {

		 int preodr[] = {10, 5, 1, 7, 40, 50};
		 ConstructBSTfromInorder obj = new ConstructBSTfromInorder();
		 for(int i=0;i<preodr.length;i++) {
			 obj.root=obj.implementsBST(obj.root,preodr[i]); 	 
		 }
		 obj.display(obj.root);
		 int size=preodr.length;
		 int index=1;
		 if(size<=0) {
			 obj.root=null;
		 }
		 else {
			 obj.root=new Node(preodr[0]);
			 obj.root=obj.BST(obj.root,preodr,index,preodr[1],size,Integer.MAX_VALUE,Integer.MIN_VALUE);
		 }
	}

}
