package com.datastruct;

/**
 * 链表 简单的线性动态数据结构 同时是递归结构
 */
public class LinkedList<E> {

    public class Node{
        public E e;
        public Node next;

        public Node(E e,Node next) {
            this.e  = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    //private Node head;
    private Node dummyHead;
    int size;

    public LinkedList() {
        //head = null;
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表头添加元素是最简单的
    public void addFirst(E e) {
   /*     Node node = new Node(e);
        node.next = head;
        head = node;
*/
        //head = new Node(e,head);
        //size++;
        add(0,e);
    }

    //在链表中添添加元素 得先找到前一元素
    //在链表中不常用
/*    public void add(int index,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("index illeage");
        if(index == 0)
            addFirst(e);
        else {
            Node pre = head;
            for(int i=0;i<index -1;i++){
               pre = pre.next;
            }
            Node node = new Node(e);
            //顺序很重要
            node.next = pre.next;
            pre.next = node;
            //等价于 pre.next = new Node(e,pre.next);
            size++;
        }
    }*/

    //在末尾添加元素
    public void addLast(E e) {
        add(size,e);
    }

    //因为不够优雅。在头节点需要特殊处理
    //设置虚拟头点
    public void add(int index,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("index illeage");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        //Node node = new Node(e);
        //顺序很重要
       /* node.next = pre.next;
        pre.next = node;*/
        pre.next = new Node(e,pre.next);
        size++;
    }

    // 查询
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++) {
            cur = cur.next;
        }
        return  cur.e;
    }

    // 查询第一个元素
    public E getFirst(){
        return get(0);
    }

    // 查询最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 判断链表中是否有元素e
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {    //（修改代码）
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;	//遍历（从第一个元素开始）
//        while(cur != null){
//            res.append(cur + "->");	//res 中加入 cur节点+ "->"
//            cur = cur.next;	//查看下一个节点
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)    //上面三行的优雅写法
            res.append(cur + "->");
        res.append("NULL");    //到达链表结尾

        return res.toString();
    }
}
