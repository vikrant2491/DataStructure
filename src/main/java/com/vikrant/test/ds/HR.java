package com.vikrant.test.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class HR {
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner s = new Scanner(System.in);
        String N = s.nextLine();                 // Reading input from STDIN
        String str = s.nextLine(); 
        
        String[] arr = str.split(" ");
        int[] arr1 = new int[arr.length];
        int i=0;
        for(String elem: arr){
        	arr1[i]= Integer.valueOf(elem);
        	i++;
        }       
        
        
        // Write your code here
        System.out.println(number(arr1));

    }

    public static int number(int[] arr){
    	int sum = 0;
    	for(int i=0;i<arr.length;i++){
    		sum += arr[i];
    	}
    	 
    	return sum/arr.length+1;
    }
    
    
}
