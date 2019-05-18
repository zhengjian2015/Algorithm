package com.sort;

import java.util.Arrays;

/**
 * 在arr[i]中插入合适的位置
 * 插入排序
 */
public class InsertionSort {
    public void insertionSort(int[] array) {
        for(int i = 1;i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                } else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4,3,1,9};
        new InsertionSort().insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
