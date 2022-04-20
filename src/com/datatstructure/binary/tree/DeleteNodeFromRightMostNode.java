package com.datatstructure.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeFromRightMostNode {

	 Node root;
	 
	 public DeleteNodeFromRightMostNode() {
		 root=null;
	 }
	 public void insert( Node root,int key) {
		    
		       if(root==null) {
		    	   root =new Node(key);
		    	   this.root=root;
		    	   return ;
		       }
		       Queue<Node> queue= new LinkedList<Node>();
		       queue.add(root);
		       while(!queue.isEmpty()) {
		    	   Node temp=queue.poll();
		    	   if(temp.left==null) {
		    		   temp.left=new Node(key);
		    		   break;
		    	   }else {
		    		   queue.add(temp.left);
		    	   } 
		    	   if(temp.right==null) {
		    		   temp.right=new Node(key);
		    		   break;
		    	   }else {
		    		   queue.add(temp.right);
		    	   }
		       }
	 }
	 public void FindAndDelete(Node root,int key) {
		   
		        if(root==null) {
		        	System.out.println(" Tree is empty");
		        	return ;
		        }
		        Queue<Node> queue = new LinkedList<Node>();
		        queue.add(root);
		        Node temp =null;
		        Node found=null;
		        
		        while(!queue.isEmpty()) {
		        	temp =queue.poll();
		        	if(temp.key==key) {
		        		found=temp;
		        	}
		        	if(temp.left!=null) {
		        		queue.add(temp.left);
		        	}if(temp.right!=null) {
		        		queue.add(temp.right);
		        	}
		        }
		        if(found!=null) {
		        	 int keyToReplace=temp.key;
		        	 //System.out.println("last key to delete" + temp.key);
		        	 this.root=delete(root,temp);
		        	 found.key=keyToReplace;
		        	
		        }
		 
	 }
	 public Node delete(Node root,Node temp) {
		   
		      
		      if(root==null || temp==null) {
		    	  return null;
		      }
		      if(root.key==temp.key) {
		    	  System.out.println(" element found"+ root.key);
		    	  root=null;
		    	  return root;
		      }
		      root.right=delete(root.right, temp);
		      root.left=delete(root.left, temp);
		      return root;
		      
	 }
	 public void display(Node root) {
		 
		 if(root!=null) {
			 display(root.left);
			 System.out.println(root.key);
			 display(root.right);
		 }
	 }
	public static void main(String[] args) {
		// delete the given key in such way,making sure that tree shrinks from the bottom
		DeleteNodeFromRightMostNode obj = new DeleteNodeFromRightMostNode();
		obj.insert(obj.root, 10);
		
		  obj.insert(obj.root, 11); obj.insert(obj.root, 7); obj.insert(obj.root, 12);
		  obj.insert(obj.root, 9); obj.insert(obj.root, 15);
		 
		obj.display(obj.root);
        obj.FindAndDelete(obj.root, 10);
        
		
		  System.out.println("after delete"); 
		  obj.display(obj.root);
		 
	}

}
