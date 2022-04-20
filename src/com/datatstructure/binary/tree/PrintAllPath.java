package com.datatstructure.binary.tree;

import java.util.ArrayList;

public class PrintAllPath {
   
	  Node root;
	  public PrintAllPath() {
		  root=null;
	  }
	public void PrintAllPath(Node root) {
		
		if(root==null) {
			return ;
		}
		ArrayList<Integer>list = new ArrayList<Integer>();
		PrintPaths(root,list);
		
		
	}
	public void PrintPaths(Node root,ArrayList<Integer> list) {
		    
		    if(root==null) {
		    	return ;
		    }
		    list.add(root.key);
		    if(root.left==null && root.right==null) {
		    	for(int i:list) {
		    		System.out.print(i + " ,");
		    	}
		    	System.out.println();
		    }
		    PrintPaths(root.left, list);
		    PrintPaths(root.right, list);
		    list.remove(list.size()-1);
		
	}
	public boolean getPathOfGivenNode(Node root, int key ,ArrayList<Integer>list) {
		
		    if(root==null) {
		    	return false;
		    }
		    list.add(root.key);
		    if(root.key==key) {
		    	return true;
		    }
		    if(getPathOfGivenNode(root.left, key, list)|| getPathOfGivenNode(root.right, key, list)) {
		    	return true;
		    }
		    list.remove(list.size()-1);
		    return false;
	}
	public void LCA(Node root,int key1 ,int key2) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		getPathOfGivenNode(root, key1, list1);
		getPathOfGivenNode(root, key2, list2);
		
		 if(list1.isEmpty()) {
			 System.out.println("given element : "+ key1 + "not found");
			 return ;
		 }
		 if(list2.isEmpty()) {
			 System.out.println("given element : "+ key2 + "not found");
			 return ;
		 }
		 
		 int i;
		for(  i=0; i<list1.size() && i< list2.size();i++) {
			
			 if(list1.get(i)!=list2.get(i)) {
				break; 
			 }
		}
       System.out.println(" LCA of (" + key1 +"," + key2 +"): " + list1.get(i-1));
		
	}
	public static void main(String[] args) {
		
		PrintAllPath obj  = new PrintAllPath();
	    Node root = new Node(6);
	    root.left=new Node(4);
	    root.left.left= new Node(3);
	    root.left.right= new Node(5);
	    root.right=new Node(9);
	    root.right.left=new Node(8);
	    root.right.left.left=new Node(7);
	    root.right.right= new Node(10);
	    obj.root=root;
	    obj.LCA(obj.root, 5, 4);
	}

}
