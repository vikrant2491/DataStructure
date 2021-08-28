package com.vikrant.test.ds.sorting;

import java.util.ArrayList;
import java.util.List;

public class BuubleSort {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int[] arr = {5, 4, 3, 2, 1};
		
		System.out.println(bubbleSort(list, "desc"));
		
		arr = bubbleSort(arr, "desc");		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//Accumulating from end
	public static List<Integer> bubbleSort(List<Integer> list, String order){
		int swaps = 0;
		int time = 0;
		boolean ordered = false; //To adapt if array has got sorted and exit
		// inner and outer loops will be in opposite direction
		for(int i=list.size()-1;i>0 && !ordered;i--){
			ordered = true;
			for(int j=0; j<i;j++){ 
				//order is the order in which array has to sort
				if(!order.equalsIgnoreCase("desc") && list.get(j)>list.get(j+1)){
					int temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
					swaps++;
					ordered=false;
				}
				if(order.equalsIgnoreCase("desc") && list.get(j)<list.get(j+1)){
					int temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
					swaps++;
					ordered=false;
				}
				time++;
			}						
		}
		
		
		System.out.println(swaps); //All adjacent unorder elements are swapped
		System.out.println(time); // Worst n(n-1)/2-- when reverse && Best o(n)--when sorted
		return list;
		
	}
	
	//Accumulating from start
	public static int[] bubbleSort(int[] arr, String order){
		int swaps = 0;
		int time = 0;
		boolean ordered = false; //To adapt if array has got sorted and exit
		// inner and outer loops will be in opposite direction
		for(int i=0;i<arr.length-1 && !ordered;i++){
			ordered = true;
			for(int j = arr.length-1;j>i;j--){
				//order is the order in which array has to sort
				if(!order.equalsIgnoreCase("desc") && arr[j]<arr[j-1]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					ordered = false;
					swaps++;
				}
			
				if(order.equalsIgnoreCase("desc") && arr[j]>arr[j-1]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					ordered = false;
					swaps++;
				}
				time++;
			}
		}
		System.out.println(swaps); //All adjacent unorder elements are swapped
		System.out.println(time); // Worst n(n-1)/2-- when reverse && Best o(n)--when sorted
		return arr;
	}

}
