package com.datatstructure.binary.tree;

import java.util.Stack;

public class ExpressionTree {

	   Node root;
	   public ExpressionTree() {
		   this.root=null;
	   }
	public Node constructTree(String expression) {
		      Node temp=null;
		      Node left =null;
		      Node right=null;
		      Stack<Node > stack = new Stack<Node>();
		      for(int i=0;i<expression.length();i++) {
		    	  char input = expression.charAt(i);
		    	   
		    	  if(isOperator(input)) {
		    		   temp = new Node(input);
		    		   right = stack.pop();
		    		   left = stack.pop();
		    		   temp.left=left;
		    		   temp.right=right;
		    		   stack.push(temp);
		    	  }else {
		    		  temp = new Node(input);
		    		  stack.push(temp);
		    	  }
		    	  
		      }
		      return stack.pop();
	}
	public boolean isOperator( char ch) {
		 if(ch=='/' || ch=='*' || ch=='-' || ch=='+'|| ch=='^') {
			 return true;
		 }
		 return false;
	}
	public void display(Node root) {
		
		   if(root!=null) {
			   
			   display(root.left);
			   System.out.print((char)root.key);
			   display(root.right);
		   }
	}
	public static void main(String[] args) {
        
		String postfix = "ABC*+D/";
		ExpressionTree obj = new ExpressionTree();
		obj.root=obj.constructTree(postfix);
		obj.display(obj.root);
	}

}
