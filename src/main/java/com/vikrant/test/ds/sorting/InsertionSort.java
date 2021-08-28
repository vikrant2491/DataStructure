package com.vikrant.test.ds.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 4, 1, 9};
		System.out.println(selectionSort2(arr));
		
		for(int i = 0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

	}
	
	public static int[] selectionSort(int[] arr){		
		for(int i=0;i<arr.length-1;i++){
			int elem = arr[i+1];
			for(int j=i;j>=0;j--){
				if(arr[j]<elem){
					arr[j+1]=arr[j];
					arr[j] = elem;
				}else{
					break;
				}
			}			
		}
		return arr;
	}
	
	public static int[] selectionSort2(int[] arr){
		for(int i=1;i<=arr.length-1;i++){
			int elem = arr[i];
			int j = i-1;
			while( j>=0 && arr[j]>elem){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1]=elem;
		}
		return arr;
	}

}
