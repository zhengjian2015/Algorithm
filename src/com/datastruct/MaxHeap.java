package com.datastruct;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * heapify 把一个普通完全二叉树改成最大堆
     * 注意 节点数/2 是 第一个不是叶子的节点
     */
    public MaxHeap(E[] array) {
        int n = array.length;
        data = new Array<>(array);
        for(int i= parent(n-1);i>=0;i--) {
            siftDown(i);
        }
        // for(int i= (n-1)/2;i>=0;i--) {
        //            siftDown(i);
        //        }
    }
    public MaxHeap() {
        data = new Array<>();
    }


    //返回堆的元素个数
    public int size() {
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
        return index*2 + 2;
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
            k = parent(k);
       }
    }

    //看堆中的最大元素
    public E findMax() {
        if(data.getSize() == 0)
            throw new IllegalArgumentException("can not findmax when hedp is empty");
        return data.get(0);
    }

    //取出堆中的最大元素
    /**
     * 技巧 取堆顶的元素，但是堆顶空了，不好融合，技巧
     * 是取最小的元素换到堆顶，然后下沉，下沉遵守和子元素最大元素交换
     * @return
     */
    public E extractMax() {

        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //如果当前元素比左右孩子最大元素要小就交换
    private void siftDown(int k) {
        //当k没有孩子 即 k左孩子所在索引比元素还大时循环不存在
        while (leftChild(k) < data.getSize() ) {
            int j = leftChild(k);
            if( j+1 < data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            //data[j] 是 leftChild和rihtChild中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k,j);
            k = j;
        }
    }


}
