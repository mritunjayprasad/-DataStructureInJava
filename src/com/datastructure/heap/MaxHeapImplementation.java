package com.datastructure.heap;

public class MaxHeapImplementation {

	    int size;
	    int capacity;
	    int heap[];
	    
	    public MaxHeapImplementation(int size,int capacity) {
	    	   this.size=size;
	    	   this.capacity=capacity;
	    	   this.heap=new int[capacity];
	    }
	    
	    public int getParent(int index) {
	    	return (index-1)/2;
	    }
	    public int getLeft(int index) {
	    	return (2*index+1);
	    }
	    public int getRight(int index) {
	    	return (2*index+2);
	    }
	    
	    public void heapImplementation( int heap[]) {
	    	  
	    	int level=heap.length/2;
	    	for(int i=level;i>=0;i--) {
	    		heapify(heap,i);
	    		
	    	}
	    }
	    public void heapify( int heap[],int index) {
	    	int left =getLeft(index);
	    	int right = getRight(index);
	    	int maxIndex=index;
	    	if(left<this.size && heap[maxIndex]<heap[left]) {
	    		maxIndex=index;
	    	}
	    	if(right<this.size && heap[right]>heap[maxIndex]) {
	    		 maxIndex=right;
	    	}
	    	if(maxIndex!=index) {
	    		int temp =heap[maxIndex];
	    		heap[maxIndex]=heap[index];
	    		heap[index]=temp;
	    		heapify(heap,maxIndex);
	    	}
	    }
	    public void insert(int heap[],int value) {
	    	
	    	 if(this.size<this.capacity) {
	    		 
	    		 heap[size]=value;
	    		 int index=size;
	    		 size++;
	    		 while(index!=0 && heap[index]>heap[getParent(index)]) {
	    			 
	    			 int temp=heap[index];
	    			 heap[index]=heap[getParent(index)];
	    			 heap[getParent(index)]=temp;
	    			 index=getParent(index);
	    		 }
	    		 
	    	 }else {
	    		 System.out.println("heap is full");
	    	 }
	    }
	    public int getMax() {
	    	
	    	return this.heap[0];
	    }
	    public int getExtractMax() {
	    	
	    	if(this.size>=1) {
	    	int max=this.heap[0];
	    	heap[0]=heap[this.size-1];
	    	this.size=this.size-1;
	    	this.heapify(heap, 0);
	    	return max;
	    	}else {
	    	return Integer.MIN_VALUE;
	    	}
	    	
	    }
	    public void delete(int index) {
               
	    	if(index<size) {
	    		heap[index]=heap[size-1]; // replace last index with given index.
	    		
	    		// case1: if node value is greater that parent node value
	    		while(index>0 && heap[index]>heap[getParent(index)]) {
	    			int temp =heap[index];
	    			heap[index]=heap[getParent(index)];
	    			heap[getParent(index)]=temp;
	    			index=getParent(index);
	    		}
                
	    		// case 2: if node values is less than its children node value:
	    		heapify(heap,index);
	    		
	    		// case3: if node values is equal to is parent node node value do nothing.
	    	  }
	    	  
	    }
	   public void update( int value,int index) {
		   
		    if(index<size) {
		      heap[index]=value;
		      
		      // case 1 if new node value is greater than parent node value:
		       while(index>0 && heap[index]>heap[getParent(index)] ) {
		    	    int temp =heap[index];
		    	    heap[index]=heap[getParent(index)];
		    	    heap[getParent(index)]=temp;
		    	    index=getParent(index);
		       }
		       heapify(heap,index);
		      
		    }else {
		    	System.out.println(" invalid index");
		    }
	   } 
}
