package com.company;

public class MergeSort {
    public void merge(int[] arr,int low, int high) {
        int mid = (high + low) / 2;
        if (high == low) {
            return;
        }

        merge(arr, low, mid);
        merge(arr, mid + 1, high);
        mergeSort(arr, low, mid, high);
    }
        public void mergeSort(int[] arr, int low, int mid, int high){
        int Larr[] = new int[mid - low + 1];
        int Rarr[] = new int[high - mid];
            int LIndex = 0;
            int RIndex = 0;

            for (int i = 0; i < Larr.length; i++)
                Larr[i] = arr[low + i];
            for (int i = 0; i < Rarr.length; i++)
                Rarr[i] = arr[mid + i + 1];

            for (int i = low; i < high + 1; i++) {
                if (LIndex < Larr.length && RIndex < Rarr.length) {
                    if (Larr[LIndex] < Rarr[RIndex]) {
                        arr[i] = Larr[LIndex];
                        LIndex++;
                    } else {
                        arr[i] = Rarr[RIndex];
                        RIndex++;
                    }
                } else if (LIndex < Larr.length) {
                    arr[i] = Larr[LIndex];
                    LIndex++;
                } else if (RIndex < Rarr.length) {
                    arr[i] = Rarr[RIndex];
                    RIndex++;
                }
            }
        }

    public void print(int[] arr){
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        }
}

