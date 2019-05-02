package com.datastruct;

public class Array<E> {
    //容量是数组的大小。size是实际数组的大小
    //size即表示数组中有多少个数据，也表示指向第1个没有元素的位置
    //当向数组末尾添加数字的时候，是向size位置添加元素
    private E[] data;
    private int size;
    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        //不能 new泛型数组
        data = (E[]) new Object[capacity];
        size = 0;
    }
    /**
     * 无参数的构造函数，默认数组的容量capacity = 10;
     */
    public Array() {
        this(10);
    }

    /**
     * 数组的构造方法
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for(int i = 0;i < arr.length;i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return size;
    }
    /**
     * 获取数组的容量
     */
    public int getCapacity(){
        return data.length;
    }
    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * 向所有元素后添加1个元素
     */
    public void addLast(E e) {
        /*if (size == data.length)
            throw new IllegalArgumentException("Addlast failed.Array is null");
        data[size++] = e;*/
        //可以复用add方法
        add(size,e);
    }

    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * 向 index位置添加元素e
     * @param index
     * @param e
     */
    public void add(int index,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Required index>=0");
        if (size == data.length)
            //自动扩容
            resize(2 * data.length);

        for(int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取index索引位置的元素
     * @return
     */
    E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal");
        return data[index];
    }

    E getFirst() {
        return get(0);
    }

    E getLast(){
        return get(size-1);
    }

    /**
     * 修改index索引位置的元素为e
     * @return
     */
    void set(int index,E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set failed,index is illegal");
        data[index] = e;
    }

    /**
     * 查找数组中是否有e
     * @return
     */
    public boolean contains(E e) {
        for(int i=0;i<size;i++) {
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数据的索引
     * @param e
     * @return
     */
    public int find(E e) {
        for(int i=0;i<size;i++) {
            if(data[i].equals(e)) {
                return size;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @return
     */
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set failed,index is illegal");

        E ret = data[index];
        for(int i = index+1; i< size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // 闲荡对象，方便垃圾回收机制启动  loitering object！= memory leack
        if(size == data.length/4 && data.length/2 != 0)
            resize(data.length/2);
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public void swap(int i,int j) {

        if(i < 0 || i >= size || j < 0 || j>= size)
            throw new IllegalArgumentException("Index is illegal");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}

