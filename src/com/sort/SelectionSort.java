package com.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 思想是 把最小的先拉出来
 * 再在剩下的选最小的，注意记录的是索引
 */
//<E extends Comparable>
public class SelectionSort{
    public void selectionSort(int[] array) {
        for(int i=0;i<array.length;i++) {
            int minIndex = i;
            for(int j=i+1;j < array.length;j++) {
                if( array[minIndex] > array[j] ) {
                    minIndex = j;
                }
            }
            //交换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new SortTestHelper().generateRandomArray(100000,0,10000);
        //System.out.println(Arrays.toString(arr));
        long begin = System.nanoTime();
        new SelectionSort().selectionSort(arr);
        long end = System.nanoTime();
        double time = (end - begin)/1000000000.0;
        System.out.println("用时"+time+"s");
        System.out.println(Arrays.toString(arr));
    }
}
