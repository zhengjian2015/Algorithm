package com.datastruct;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    //返回堆的元素个数
    public int size(){
        return data.getSize();
    }

    //返回一个布尔值，表示堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中,1个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if(index == 0)
            throw new IllegalArgumentException("index-0 dosen't have parent.");
        return (index-1)/2;
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index*2+1;
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index*2 + 1;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        //如果k所在父亲元素小于 k所在元素 就上浮
       while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k,parent(k));
       }
    }


}
