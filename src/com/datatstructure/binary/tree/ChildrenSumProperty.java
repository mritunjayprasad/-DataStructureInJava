package com.datatstructure.binary.tree;

public class ChildrenSumProperty {

	 Node root;
	 
	 public boolean isSumProperty(Node root) {
		   
		 if( root==null || (root.left==null && root.right==null) ) {
			 return true;
		 }
		 int left =0;
		 int right = 0;
		 if(root.left!=null) {
			 left = root.left.key;
		 }
		 if(root.right!=null) {
			 right=root.right.key;
		 }
		 if(root.key==left+right && (isSumProperty(root.left) && isSumProperty(root.right))) {
			 return true;
		 }
		 return false;
	 }
	public static void main(String[] args) {
	}

}
