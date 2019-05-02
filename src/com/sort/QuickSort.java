package com.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 快速排序
 * 设立两个指针，当left<righe的时候，找轴能把数组分成两部分
 * 轴
 */
public class QuickSort {
    public void sort(int[] array,int leftBound,int rightBound) {
        if(leftBound >= rightBound) return;
        partition(array,leftBound,rightBound);

    }

    private void partition(int[] array, int leftBound, int rightBound) {
        int pivoit = array[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left < right) {
            while (left <= right && array[left] <= pivoit) left++;
            while (left <= right && array[right] >= pivoit) right--;
            if(left < right) swap(array,left,right);
        }
        swap(array,left,rightBound);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7,3,2,8,1,9,5,4,6,10};
        new QuickSort().sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
