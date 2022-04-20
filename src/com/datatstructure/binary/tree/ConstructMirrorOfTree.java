package com.datatstructure.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructMirrorOfTree {
       Node root;
	
       public ConstructMirrorOfTree(){
    	   root=null;
       }
	// recursive ways do postorder traversal and then swap left and right child 
	
	public Node mirror( Node root ) {
		
		  if(root!=null) {
			  mirror(root.left);
			  mirror(root.right);
			  Node temp =root.left;
			  root.left=root.right;
			  root.right=temp;
			  return root;
		  }
		  return root;
	}
	// by using queue and level order of traversal:
	public  void mirrorByLevelOrder(Node root) {
		
		   Queue<Node > queue = new LinkedList<Node>();
		   queue.add(root);
		   while(!queue.isEmpty()) {
			   
			   Node temp =queue.poll();
			   Node templeft = temp.left;
			   temp.left=temp.right;
			   temp.right=templeft;
			   
			   if(temp.left!=null) {
				   queue.add(temp.left);
			   }
			   if(temp.right!=null) {
				   queue.add(temp.right);
			   }
		   }
	}
	public void display(Node root) {
		  if(root!=null) {
			  display(root.left);
			  System.out.println(root.key);
			  display(root.right);
		  }
		
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
	 public boolean foldable(Node root ) {
		  
		     if(root==null) {
		    	 return true;
		     }
		      mirrorByLevelOrder(root.left);
		      boolean res=isStructureSame(root.left, root.right);
		      mirror(root.left);
		      return res;
		      
	 }
	 public boolean isStructureSame(Node leftNode,Node rightNode) {
		  
		    if(leftNode==null && rightNode==null) {
		    	return true;
		    }
		    return (leftNode!=null && rightNode!=null)&& isStructureSame(leftNode.left, rightNode.left) && isStructureSame(leftNode.right, rightNode.right); 
	 }
	 public boolean checkMirrorOfItSelf( Node leftRoot,Node rightRoot) {
		     
		     if(leftRoot==null && rightRoot==null) {
		    	 return true;
		     }
		     if(leftRoot!=null && rightRoot!=null && (leftRoot.key==rightRoot.key)) {
		    	 
		    	 return checkMirrorOfItSelf(leftRoot.right, rightRoot.left)&& checkMirrorOfItSelf(leftRoot.right, rightRoot.left);
		     }
		     return false;
	 }
	public static void main(String[] args) {
    
		ConstructMirrorOfTree obj = new ConstructMirrorOfTree();
		obj.insert(obj.root, 10);
		
		  obj.insert(obj.root, 11); obj.insert(obj.root, 7); obj.insert(obj.root, 12);
		  obj.insert(obj.root, 9); obj.insert(obj.root, 15);
		  obj.insert(obj.root, 18);
		  obj.insert(obj.root, 19);
		  obj.insert(obj.root, 20);
		  obj.insert(obj.root, 21);
		  obj.insert(obj.root, 22);
		  obj.insert(obj.root, 23);
		  obj.insert(obj.root, 24);
		  obj.insert(obj.root, 25);
		  obj.insert(obj.root, 26);
		  obj.display(obj.root);
		  
		  System.out.println("given is foldable :" + obj.foldable(obj.root));
		  
	}

}
