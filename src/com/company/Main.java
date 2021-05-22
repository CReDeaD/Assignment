package com.company;

public class Main {

    public static void main(String[] args) {
        int arr[] = {11,0,1,9,7};
	MergeSort ms = new MergeSort();
	ms.merge(arr,0,arr.length-1);
	ms.print(arr);
	QuickSort qs = new QuickSort();
	qs.quickSort(arr);
	qs.print(arr);
}
}
