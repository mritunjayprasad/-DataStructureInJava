package com.datatstructure.binary.tree;

public class ConstructTreeFromInorderAndPreorder {

	public int preOrderIndex=0;
	public static void main(String[] args) {
	
		ConstructTreeFromInorderAndPreorder tree = new ConstructTreeFromInorderAndPreorder();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.buildTree(pre, in, 0, len - 1);
	}

	public Node buildTree(char preorder[],char inorder[],int instartIndex,int inEndIndex) {
		
		
		 if(instartIndex>inEndIndex) {
			 return null;
		 }
		Node node = new Node(preorder[preOrderIndex++]);
		int rootIndex=search(inorder,instartIndex,inEndIndex,node.key);
		node.left=buildTree(preorder,inorder,instartIndex,rootIndex-1);
		node.right=buildTree(preorder,inorder,rootIndex+1,inEndIndex);
		return node;
	}
	
	// assumption element must be present 
	public int search(char inorder[],int start,int end,int key) {
		 
		 for(int i=start;i<=end;i++) {
			 
			 if(inorder[i]==key) {
				 return i;
			 }
		 }
		 return -1;
		
	}
	class Node {
		
		char key;
		Node left;
		Node right;
		public Node(char ch) {
			this.key=ch;
			left=null;
			right=null;
		}
	}
}
