package com.aidar.algs.quickSort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 1, 3, 3, 2, 8, 4, 2, 4, 9, 1, 3};
        quickSort(arr, 0, arr.length-1);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = lomutoPartition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static int lomutoPartition(int[] arr, int low, int high) {
        randomPivot(arr, low, high);
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, high, i);
        return i;
    }

    public static void randomPivot(int[] arr, int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high-low) + low;
        swap(arr, high, pivot);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


