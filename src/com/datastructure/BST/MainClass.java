package com.datastructure.BST;

public class MainClass {

	public static void main(String[] args) {
		
		BST obj = new BST();
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(7);
		obj.insert(6);
		obj.insert(1);
		obj.display(obj.root);
		obj.delete(3);
		System.out.println(" after delete");
		obj.display(obj.root);
	}

}
