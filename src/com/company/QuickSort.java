package com.company;

public class QuickSort {
    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int[] arr,int start, int end){
        if(start < end){
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi, end);
        }
    }
    private static int partition(int[] x, int start, int end) {

        int pivot = x[start];

        int right = end;
        int left = start;

        while (left <= right) {

            while (x[left] < pivot) {
                left++;
            }

            while (x[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(x, right, left);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void print(int[] x, int length)
    {
        for(int i = 0; i < length; i++)
            System.out.print(x[i] + " ");

        System.out.println();
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void print(int[] arr){
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}
