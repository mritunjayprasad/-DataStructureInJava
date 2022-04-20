package com.dynamicprogramming;

public class EvaluteExpression {

	public static int  fun( int n) {
		 
		int sum=0;
		 if(n<=1) {
			 return 2;
		 }
		 for(int i=1;i<n;i++) {
			 sum =sum + 2*fun(i)*fun(i-1);
		 }
		 return sum;
	}
	public static void main(String[] args) {
		
		System.out.println("output: " + fun(3));
	}

}
