package com.sort;

public class SortTestHelper {
    //生成有n个元素的随机数组,每个元素的随机范围为[rangeL,rangeR]
    public int[] generateRandomArray(int n,int rangeL,int rangeR) {
        int[] arr = new int[n];
        for(int i = 0;i < n ;i++) {
            arr[i] = (int)(rangeL+Math.random()*(rangeR-rangeL+1));
        }
        return arr;
    }
}
