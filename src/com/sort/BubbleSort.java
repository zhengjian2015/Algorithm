package com.sort;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] array){
        int temp;
        for(int i=0;i<array.length-1;i++) {
            for(int j=0;j<array.length-i-1;j++) {
                if(array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new SortTestHelper().generateRandomArray(10000,0,10000);
        //System.out.println(Arrays.toString(arr));
        long begin = System.nanoTime();
        new BubbleSort().bubbleSort(arr);
        long end = System.nanoTime();
        double time = (end - begin)/1000000000.0;
        System.out.println("用时"+time+"s");
        System.out.println(Arrays.toString(arr));
    }
}
