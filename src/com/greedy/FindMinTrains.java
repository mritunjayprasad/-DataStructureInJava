package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class FindMinTrains {

	public static void main(String[] args) {
		
		 int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	     int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
	      int n = arr.length;
	      if(n==0) {
	    	  System.out.println(" there is no train, hence no platform is needed");
	      }
	      
	      System.out.println("minmum number of platfrom is needed: "+ findPlatfrom(arr, dep, n));
	      System.out.println("minmum number of platfrom is needed: "+ findminPlatfrom(arr,dep,n));
	}
	
	public static int findPlatfrom ( int arr[], int dep[], int n) {
		
		 int platfrom =1;
		 int result = 1;
		 
		 for(int i =0; i<n;i++) {
			 
			 platfrom =1;
			 for(int j=i+1;j<n; j++) {
			  
				 if((arr[i]>=arr[j] && arr[i]<=dep[j]) || (arr[j]>=arr[i] && arr[j]<=dep[i]) ) {
					   platfrom =platfrom +1;
				 }
			 }
			 result = Math.max(result,platfrom);
		 }
		 return result;
	}
   public static int findminPlatfrom( int arr[],int dep[], int n) {
	   
	      Arrays.sort(arr);
	      Arrays.sort(dep);
	      int platfrom =1;
	      int result =1;
	      int i=1; // index 0 we need platfrom is 1 hence starting index of arr should be 1:
	      int j=0;
	      
	      while(i<n && j<n) {
	    	    
	    	    if(arr[i]<=dep[j]) {
	    	    	platfrom++;
	    	    	i++;
	    	    }else {
	    	    	j++;
	    	    	platfrom--;
	    	    }
	    	    if(platfrom>result) {
	    	    	result=platfrom;
	    	    }
	      }
	      return result;
	      
   }
}
