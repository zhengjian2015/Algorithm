package com.sort;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public void sort(int[] array,int left, int right) {
        if(right == left) return;
        int mid = left+(right-left)/2;  //防止溢出
        //分成2部分
        //左边
        sort(array,left,mid);
        //右边
        sort(array,mid+1,right);
        merge(array,left,mid+1,right);
    }

    private void merge(int[] array,int left,int right,int rightBound) {
        int[] temp = new int[rightBound - left + 1];
        int mid = right - 1;
        int l = left; //左指针
        int r = right; // 右指针
        int t = 0;
        while (l <= mid && r <= rightBound) {
            if(array[l] <= array[r]) {
                temp[t++] = array[l++];
            } else {
                temp[t++] = array[r++];
            }
        }
        while (l <= mid) {
            temp[t++] = array[l++];
        }
        while (r <= rightBound) {
            temp[t++] = array[r++];
        }
        t = 0;
        //注意是left+t 不然得不到正确的结果
        while (t < temp.length) {
            array[left+t] = temp[t];
            t++;
        }
        //System.out.println(Arrays.toString(temp));
    }

    public static void main(String[] args) {
        int[] arr = new SortTestHelper().generateRandomArray(10000,0,10000);
        //System.out.println(Arrays.toString(arr));
        long begin = System.nanoTime();
        new MergeSort().sort(arr,0,arr.length-1);
        long end = System.nanoTime();
        double time = (end - begin)/1000000000.0;
        System.out.println("用时"+time+"s");
        System.out.println(Arrays.toString(arr));
    }
}
