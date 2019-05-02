package com.sort;

import com.datastruct.MaxHeap;

import java.util.Arrays;

/**
 * 第1版本的堆排序算法
 */
public class HeapSort1 {
    public void sort(int[] array,boolean isHeapify) {
        int n = array.length;
        MaxHeap<Integer> maxHeap;
        if(isHeapify) {
            Integer[] arrs = new Integer[array.length];
            for(int i=0;i<arrs.length;i++)
                arrs[i] = array[i];
            maxHeap = new MaxHeap<>(arrs);
        } else {
            maxHeap = new MaxHeap<>(n);
            for (int i = 0; i < n; i++) {
                maxHeap.add(array[i]);
                // System.out.println(maxHeap.findMax());
            }
        }
        for(int i = n-1;i >= 0;i--)
            array[i] = maxHeap.extractMax();

    }

    public static void main(String[] args) {
        int[] arr = new SortTestHelper().generateRandomArray(10000,0,10000);
        int[] arr1 = new SortTestHelper().generateRandomArray(10000,0,10000);
        int[] arr2 = new SortTestHelper().generateRandomArray(10000,0,10000);
        //System.out.println(Arrays.toString(arr));
        long begin = System.nanoTime();
        new HeapSort1().sort(arr,true);
        long end = System.nanoTime();
        double time = (end - begin)/1000000000.0;
        long begin2 = System.nanoTime();
        new HeapSort1().sort(arr1,false);
        long end2 = System.nanoTime();
        double time2 = (end2 - begin2)/1000000000.0;
        long begin3 = System.nanoTime();
        new QuickSort().sort(arr2,0,arr2.length - 1);
        long end3 = System.nanoTime();
        double time4 = (end3 - begin3)/1000000000.0;
        System.out.println("用时"+time+"s");
        System.out.println("用时maxheap"+time2+"s");
        System.out.println("qucik用时"+time4+"s");
        System.out.println(Arrays.toString(arr));
    }
}
