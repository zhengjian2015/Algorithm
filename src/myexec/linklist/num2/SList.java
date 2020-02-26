package myexec.linklist.num2;

/**
 * linkedList zz
 * 第2遍
 * 用dummyHead 虚拟头节点
 *
 * 需要牢记的是 链表里的 顺序很重要
 **/
public class SList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public SList(){
        this.dummyHead = new Node(null,null);
        size = 0;
    }

    //返回链表的长度
    public int getSize() {
        return size;
    }

    //返回是否是空
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index illegal,failed");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        //这里容易搞错，是pre.next不是 prev
        prev.next = node;
        //简写
        //prev = new Node(e,prev.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e) {
        add(size,e);
    }

    //获取时用从第一个节点开始
    public E get(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void set(E e, int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contain(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除操作
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("failed");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        return delNode.e;
    }

    public E removeFire() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
