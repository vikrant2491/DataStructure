package com.vikrant.test.ds.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {4,3,5,1};
		arr = selectionSort(arr, "desc");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static int[] selectionSort(int[] arr, String order){
		int swaps = 0;
		int time = 0;
		//Uni Directional loops
		for(int i=0;i<arr.length;i++){			
			int index = i;
			//Find mind or max every time among rest of elements
			for(int j=i+1;j<arr.length;j++){
				if(!order.equalsIgnoreCase("desc") && arr[j]<arr[index]){
//					min = arr[j];
					index =j;
				}
				if(order.equalsIgnoreCase("desc") && arr[j]>arr[index]){
//					max = arr[j];
					index =j;
				}
				time++; // Time complexity Best and worst - n(n-1)/2
			}
			if(index!=i){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				swaps++; //swaps are less than bubble sort
			}			
		}
		System.out.println(swaps);
		System.out.println(time);
		return arr;
		
	}

}
