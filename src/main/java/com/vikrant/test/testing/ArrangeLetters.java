package com.vikrant.test.testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrangeLetters {

	public static List<Integer> strArr = new ArrayList<Integer>();
	
	public static void arrangeLetters(String str){
		int current = 96;
		int removal = 0;
		int insertion = 0;
		for(char c: str.toCharArray()){
			strArr.add((int)c);
		}
		
		Iterator<Integer> itr = strArr.iterator();
		while(itr.hasNext()){
			Integer elem = itr.next();
			if(elem==current+1)
				current++;
			else{
				itr.remove();
				removal++;
			}
		}
		for(int i=strArr.get(strArr.size()-1)+1; i<123;i++){
			strArr.add(i);
			insertion++;
		}
		System.out.println("Insertion is: "+insertion);
		System.out.println("Removal is: "+removal);
		System.out.println(strArr);
	}

	public static void main(String[] args) {
		String str = "zyxabcdpqrsef";
		if(str.length()==0){
			System.out.println("Insertion is 26");
			System.out.println("Removal is 0");
		}else{
			arrangeLetters(str);			
		}
	}
}
