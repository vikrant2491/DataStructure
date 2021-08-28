package com.vikrant.test.ds.sorting;

public class ShellSort {

	public static void main(String[] args) {
		 
		int[] arr = {7,3,5,1,7};
//		7,3,5,1,7
//		5 3 7 1 7
//		5 1 7 3 7
//		
//		1 5 7 3 7
//		1 5 3 7 7
//		1 3 5 7 7
		arr = shellSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		

	}
	// 3 loops, one for gap and other two as insertion sort.
	//It eventually sorts in less passes and faster
	public static int[] shellSort(int[] arr){
		for(int gap = arr.length/2;gap>0;gap = gap/2){
			for(int j=gap;j<arr.length;j++){
				int elem = arr[j];
				int k = j;
				while(k>=gap && arr[k-gap]>elem){
					arr[k] = arr[k-gap];
					k -= gap;
				}
				arr[k]=elem;
			}
		}
		
		return arr;
	}

}
