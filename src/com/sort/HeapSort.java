package com.sort;

import java.util.Arrays;

/**
 * 原地堆排序，直接在数组上进行heapfify,空间复杂度是O(1)
 * 时间复杂度 是 O(nlog(n))
 * headpfify使数组变为最大堆，
 * 把最大堆的第1个元素和末尾交换，此时不再是最大堆，再siftdown
 * 变为最大堆(n-1), 最大元素在末尾，继续交换，第二大元素在末尾
 * 循环下去 最后变为有序数组
 */
public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        //从0开始索引，第1个非叶子节点是(n-1)/2
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }

    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    //参考最大堆的shiftDown
    private void shiftDown(int[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1;
            }
            if (arr[k] >= arr[j])
                break;
            swap(arr, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = new SortTestHelper().generateRandomArray(10000,0,10000);
        long begin2 = System.nanoTime();
        new HeapSort().sort(arr);
        long end2 = System.nanoTime();
        double time2 = (end2 - begin2)/1000000000.0;
        System.out.println("用时"+time2+"s");
        System.out.println(Arrays.toString(arr));
    }
}
