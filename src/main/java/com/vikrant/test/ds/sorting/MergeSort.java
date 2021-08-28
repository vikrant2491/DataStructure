package com.vikrant.test.ds.sorting;



public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {7,5,39,37,93,10, 10,19,11};
		arr = mergeSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int[] mergeSort(int[] arr){
		int[] temp = new int[arr.length];
		divideAndMerge(arr, temp, 0, arr.length-1);
		return arr;
		
	}
	
	public static void divideAndMerge(int[] arr, int[] temp, int left, int right){
		if(left<right){
			int mid = left+((right-left)/2);
			divideAndMerge(arr, temp, left, mid);
			divideAndMerge(arr, temp, mid+1, right);
			merge(arr, temp, left, mid+1, right);
		}
	}
	
	public static void merge(int[] arr, int[] temp, int left, int mid, int right){
		int i = left, start = left;
		int k = mid-1;
		while(left<=k && mid<=right){
			if(arr[left]<=arr[mid]){
				temp[i] = arr[left];
				i++;
				left++;
			}else{
				temp[i] = arr[mid];
				mid++;
				i++;
			}
		}
		
		while(left<=k){
			temp[i] = arr[left];
			left++;
			i++;
		}
		while(mid<=right){
			temp[i] = arr[mid];
			mid++;
			i++;
		}
		
		for(int j=start;j<=right;j++){
			arr[j] = temp[j];
		}
	}

}
