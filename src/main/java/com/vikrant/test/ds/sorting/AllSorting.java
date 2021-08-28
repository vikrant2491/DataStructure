package com.vikrant.test.ds.sorting;

public class AllSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9, 3, 7, 2, 1, 8};
		display(arr);
//		bubbleSort(arr);		
//		selectionSort(arr);
//		insertionSort(arr);
//		mergeSort(arr, 0, arr.length-1);
//		shellSort(arr);
		quickSort(arr, 0, arr.length-1);
		display(arr);
		
	}
	
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int min = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min]){
					min = j;
				}
			}
			if(i!=min){
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void insertionSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int elem = arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>elem){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = elem;
		}
	}
	
	public static void shellSort(int[] arr){
		int d = arr.length/3;
		while(d>0){
			for(int i=d;i<arr.length;i++){
				int elem = arr[i];
				int j = i-d;
				while(j>=0 && arr[j]>elem){
					arr[j+d] = arr[j];
					j=j-d;
				}
				arr[j+d]=elem;
			}
		d--;
		}
	}
	
	public static void mergeSort(int[] arr, int start, int end){
		if(start<end){
			int mid = (end+start)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	public static void merge(int[] arr, int start, int mid, int end){
		int i=start, j=mid+1, k=0;
		int[] arr1 = new int[end-start+1];
		while(i<=mid && j<=end){
			if(arr[i]<arr[j]){
				arr1[k] = arr[i];
				i++;
				k++;
			}else{
				arr1[k] = arr[j];
				j++;
				k++;
			}
		}
		while(i<=mid){
			arr1[k] = arr[i];
			i++;
			k++;
		}
		while(j<=end){
			arr1[k] = arr[j];
			j++;
			k++;
		}
		k=0;
		while(k<arr1.length && start<=end){
			arr[start++]=arr1[k++];
		}
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(high>low){
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
	}
	
	public static int partition(int[] arr, int low, int high){
		int pivot = arr[low];
		int left = low;
		int right = high;
		while(left<right){
			while(left<arr.length && arr[left]<=pivot){
				left++;
			}
			while(right>=0 && arr[right]>pivot){
				right--;
			}
			if(left<right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		arr[low] = arr[right];
		arr[right] = pivot;
		
		return right;
	}
	
	public static void display(int[] arr){
		for(int x: arr){
			System.out.print(x+" ");
		}
		System.out.println();
	}

}
